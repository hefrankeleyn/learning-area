(function(){
   let colorPicker = document.getElementById("colorPicker");
   let box = document.getElementById("box");
   let output = document.getElementById("output");
   box.style.borderColor = colorPicker.value;

   colorPicker.addEventListener("input", function(even){
        box.style.borderColor = even.target.value;
        console.log("input even...");
    },false);
    
    colorPicker.addEventListener("change", function(even){
        output.innerText = "Color set to "+ colorPicker.value +".";
        console.log("change even...");
   },false);
})();