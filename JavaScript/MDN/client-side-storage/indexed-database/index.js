// Create needed constants
const list = document.querySelector('ul');
const titleInput = document.querySelector('#title');
const bodyInput = document.querySelector('#body');
const form = document.querySelector('form');
const submitBtn = document.querySelector('form button');

// Create an instance of a db object for us to store the open database in
let db;

window.onload = function(){
	// Open our database, it is created if it doesn't already exist
	let request = window.indexedDB.open('notes',1);
	
	// onerror handler signifies that the database didn't open successfully
	request.onerror = function(){
		console.log('Database failed to open');
	};
	
	// onsuccess handler signifies that the database open successfully
	request.onsuccess = function(){
		console.log('Database open succuessfully');
		
		// Store the opened database object in the db variable. This is used a log below
		db = request.result;
		
		// Run the displayData() function to display the notes already in the IDB
		displayData();
	};
	
	// Setup the database tables if this has not already been done
	request.onupgradeneeded = function(e){
		// Grab a reference to the opened database
		let db = e.target.result;
		
		// Create a objectStore to store our notes in (basically like a single table)
		//including a auto-incrementing key
		let objectStore = db.createObjectStore('notes',{ keyPath:'id',autoIncrement:true});
		
		// Define what data items the objectStore will contain
		objectStore.createIndex('title', 'title', { unique:false });
		objectStore.createIndex('body', 'body', { unique:false });
		
		console.log('Database setup complete');
	};
	
	// Create an onsubmit handler so that when the form is submitted the addDate() function is run
	form.onsubmit = addData;
	//submitBtn.addEventListener('click',addData);
	// Define the addData() function
	function addData(e){
		console.log('add data run...');
		// prevent default - we don't want the form to submit in the conventional way
		e.preventDefault();
		
		// grab the values entered into the form fields and store them in an object ready for being inserted into the DB.
		let newItem = { title: titleInput.value, body: titleInput.value};
		
		// open a read/write db transaction ,ready for adding the data
		let transaction = db.transaction(['notes'], 'readwrite');
		
		// call an object store that's already been added to the database
		let objectStore = transaction.objectStore('notes');
		
		// Make a request to add our newItem object to the object store
		var request = objectStore.add(newItem);
		request.onsuccess = function(){
			// Clear the form, ready for adding the next entry
			titleInput.value = '';
			bodyInput.value = '';
		};
		
		// Report on the success of transaction completing, when everying is done
		transaction.oncomplete = function(){
			console.log('Transaction completed:  database modification finished.');
			
			// update the display of data to show the newly added item, by running displayData() again.
			displayData();
		};
		
		transaction.onerror = function(){
			console.log('Transaction not opened due to error.');
		};
		
	};
	
	// Define the displayData() function
	function displayData(){
		console.log('display data run...');
		// Here we empty the contents of the list element each time the display is updated
		// If you didn't do this, you'd get duplicates listed each time a new 
		while(list.firstChild){
			list.removeChild(list.firstChild);
		}
		
		// Open our object store and then get a cursor - which iterators through all the 
		// different data items in the store.
		let objectStore = db.transaction('notes').objectStore('notes');
		console.log(objectStore);
		objectStore.openCursor().onsuccess = function(e){
			console.log('run...run..cursor');
			// Get a reference to the cursor
			let cursor = e.target.result;
			
			// If there is  still  another data item to iterator through, keeping running this code
			if (cursor) {
				// Create a list item, h3, and p to put each data item inside when displaying it
				// structure the HTML fragment, and append it inside the list
				let listItem = document.createElement('list');
				let h3 = document.createElement('h3');
				let para = document.createElement('p');
				
				listItem.appendChild(h3);
				listItem.appendChild(para);
				list.appendChild(listItem);
				
				// Put the data from cursor inside the h3 and para
				h3.textContent = cursor.value.title;
				para.textContent = cursor.value.body;
				
				// Store the ID of the data item inside an attribute on the listItem, so we know
				// which item it corresponds to. This will be useful later when we want to delete items
				listItem.setAttribute('data-node-id',cursor.value.id);
				
				// Create a button and please it inside each listItem
				let deleteBtn = document.createElement('button');
				listItem.appendChild(deleteBtn);
				deleteBtn.textContent = 'Delete';
				
				// Set an event handler so that when the button is clicked, the deleteItem()
				// function is run
				deleteBtn.addEventListener('click',deleteItem);
				
				// Iterator to the next item in the cursor
				cursor.continue();
			} else {
				// Again, if item is empty, display a 'No notes stored' message
				if(!list.firstChild){
					let listItem = document.createElement('li');
					listItem.textContent = 'No notes stored';
					list.appendChild(list);
				}
				
				console.log('Notes all displayed.');
			}
			
		};
	};
	
	// Define the deleteItem() function
	function deleteItem(e){
		// retrieve the name of the task we want to delete. We need to convert 
		// it to a number before trying it use it with IDB.
		// IDB key values are type-sensitive.
		let noteId = Number(e.target.parentNode.getAttribute('data-node-id'));
		
		// Open a database transaction and delete the task, finding it using 
		// the id we retrieved above 
		let transaction = db.transaction(['notes'],'readwrite');
		let objectStore = transaction.objectStore('notes');
		let request = objectStore.delete(noteId);
		
		// report that the data  item has been deleted
		transaction.oncomplete = function(){
			// delete the parent of the button
			// which is the list item, so it is no longer displayed
			e.target.parentNode.parentNode.removeChild(e.target.parentNode);
			console.log(' Node ' + noteId + ' deleted.');
			
			// Again, if list item is empty, display a 'No notes stored.' message
			if(!list.firstChild){
				let listItem = document.createElement('li');
				listItem.textContent = 'No notes stored';
				list.appendChild(listItem);
			}
			
		}
	};
};