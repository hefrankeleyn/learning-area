var displayedImage = document.querySelector('.displayed-img');
var thumbBar = document.querySelector('.thumb-bar');

btn = document.querySelector('button');
var overlay = document.querySelector('.overlay');

/* Looping through images */
//for (var i=1;i<=5;i++){
//  var newImage = document.createElement('img');
//  newImage.setAttribute('src', 'images/pic'+i+'.jpg');
//  thumbBar.appendChild(newImage);
//  newImage.onclick = function(e){
//	  var src_v = e.target.getAttribute('src');
//	  displayImage(src_v);
//  }
//}
//function displayImage(imgSrc){
//	displayedImage.setAttribute('src',imgSrc);
//}
for (var i=1;i<=5;i++){
  var newImage = document.createElement('img');
  newImage.setAttribute('src', 'images/pic'+i+'.jpg');
  thumbBar.appendChild(newImage);
}
thumbBar.onclick = function(e){
	if(e.target && e.target.nodeName === 'IMG'){
		var src_v = e.target.getAttribute('src');
		displayedImage.setAttribute('src',src_v);
	}
}
/* Wiring up the Darken/Lighten button */
btn.onclick = function(){
	var btn_class = btn.getAttribute('class');
	if (btn_class === 'dark'){
		btn.setAttribute('class','light');
		btn.textContext = 'Lighten';
		overlay.style.backgroundColor = 'rgba(0,0,0,0.5)';
	} else if (btn_class === 'light') {
		btn.setAttribute('class','dark');
		btn.textContext = 'Darken';
		overlay.style.backgroundColor = 'rgba(0,0,0,0)';
	}
}


