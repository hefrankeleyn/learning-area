var helpText = [{'id':'email','help':'Please enter email.'},
				{'id':'name','help':'Please enter name.'},
				{'id':'age','help':'Please enter age.'}]

/** 问题
function changeHelp(help){
	document.querySelector('#help').textContent = help
}

for(var i=0; i<helpText.length; i++){
	var id_value = helpText[i]['id']
	var v_text =helpText[i]['help']
	console.log('**********')
	document.querySelector('#'+id_value).addEventListener('focus',function(){changeHelp(v_text)});
}
*/

/** 方案一：*/
function changeHelp(help){
	document.querySelector('#help').textContent = help
}

function changeHelpCallBack(help){
	return function(){
		changeHelp(help)
	};
}

for(var i=0; i<helpText.length; i++){
	var id_value = helpText[i]['id']
	var v_text =helpText[i]['help']
	console.log('**********')
	//document.querySelector('#'+id_value).addEventListener('focus',changeHelpCallBack(v_text));
}


/** 方案二：使用匿名的闭包
function changeHelp(help){
	document.querySelector('#help').textContent = help
}

for(var i=0; i<helpText.length; i++){
	(function(){
		var id_value = helpText[i]['id']
		var v_text = helpText[i]['help']
	document.querySelector('#'+id_value).addEventListener('focus',function(){
		changeHelp(v_text);
	});
	})();
}
*/

/** 方案三： 使用let
function changeHelp(help){
	document.querySelector('#help').textContent = help
}

for(var i=0; i<helpText.length; i++){
	let id_value = helpText[i]['id']
	let v_text =helpText[i]['help']
	console.log('**********')
	document.querySelector('#'+id_value).addEventListener('focus',function(){changeHelp(v_text)});
}

*/

/** 方案四： 使用forEach
function changeHelp(help){
	document.querySelector('#help').textContent = help
}


helpText.forEach(function(text){
	document.querySelector('#'+text.id).addEventListener('focus',function(){changeHelp(text.help)})
});

*/