'use strict';

var fs = require('fs'),
    path = require('path');



fs.exists('default.html', function(e){
	if(e){
		console.log("It there.");
	}else{
		console.log('No there.');
	}
});
/*
process.nextTick(function(){
	console.log('Next tick callback.');
});

process.on('exit',function(code){
	
	console.log('about to exit with code,'+code);
});

console.log('nexttick was set!');

if (typeof(window) === 'undefined') {
	console.log('node.js,run...')
} else{
	console.log('browser.');
}
*/