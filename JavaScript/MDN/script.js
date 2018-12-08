/**/
document.addEventListener('DOMContentLoaded',function(){
  function createParagraph(){
    var para = document.createElement('p');
    para.textContent = 'You click this button.';
    document.body.appendChild(para);
  }
  
  var buttons = document.querySelectorAll('button');
  
  for (var i=0; i<buttons.length; i++){
    buttons[i].addEventListener('click', createParagraph);
  }
});