// index.js
'use strict';

// 第一，严格模式，让意外创建全局变量成为不可能
//mistypeVariable = 17; // 这句话将抛出异常，ReferenceError：assignment to undeclared variable mistypeVariable

// 第二，在正常代码中的静默失败，在严格模式中将抛出异常
//var undefined =5;

// 第三，严格模式中，要删除不可删的属性，将抛出异常
//delete Object.prototype;

function People(){
	this.name = 'aaa';
	this.description = 'aaa';
	this.say = function(){
		console.log('good');
	}
}
var p =new People();
p.say();
console.log(p.name);

//delete People.name;

var p1 = new People();
p1.say();
console.log(p1.name);

// 第四，严格模式中，要求属性名在对象中是唯一的
//var o= {p:1,p:2}; //将抛出语法错误

// 第五，严格模式，要求函数的参数名称唯一

//function Student(name,name,age){} //将抛出语法错误

// 第六，严格模式，进制ECMAScript 5 的八进制语法,使用加“0o”作为八进制数字的前缀；
//var a = 012;    
var b = 0o12;

// 第七，严格模式，禁止在原始类型上设置属性
//false.true = '';


// *** 
// 第八，严格模式，禁止了with语法


// 第九， 严格模式中，eval不能引进一个进的变量到进入到相应的范围中
function strict1(str) {
  'use strict';
  return eval(str); // str will be treated as strict mode code
}
function strict2(f, str) {
  'use strict';
  return f(str); // not eval(...): str is strict if and only
                 // if it invokes strict mode
}
function nonstrict(str) {
  return eval(str); // str is strict if and only 
                    // if it invokes strict mode
}
strict1("'Strict mode code!'");
strict1("'use strict'; 'Strict mode code!'");
strict2(eval, "'Non-strict code.'");
strict2(eval, "'use strict'; 'Strict mode code!'");
nonstrict("'Non-strict code.'");
nonstrict("'use strict'; 'Strict mode code!'");


// 第十 严格模式禁止删除纯名称
//val x;
//delete x;


// 第十一 严格模式中，eval和arguments 不能绑定和赋值；
// eval = 17;


// 第十二 严格模式不会对 arguments 对象创造别名

function f(a){
	'use strict';
	a = 42;
	return [a,arguments[0]];
}

var pair = f(17);
console.log('*******************');
console.log(pair[0]);
console.log(pair[1]);
console.assert(pair[0] === 42);
console.assert(pair[1] === 17);

// 第十三 严格模式不支持 arguemnts.callee;

// 第十四 在严格模式中， this不会被封装到对象中，如果没有指定，this将是未定义,
//意味着,在浏览器中，不再可能通过严格模式中的“this”引用window对象




