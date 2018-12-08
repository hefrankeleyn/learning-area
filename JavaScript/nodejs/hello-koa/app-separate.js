'use strict';
// koa2中，导入的是一个class，所以用大写表示
const Koa = require('koa');

// 导入Controller
const controller = require('./controller');
// 用于解析body
const bodyParser = require('koa-bodyparser');
// 创建一个koa对象表示web app本身
const app = new Koa();
//在合适的位置添加上下面的一句话,如果不添加这句话，会报错误：name没有发现。
app.use(bodyParser());

// 使用middlerware
app.use(controller());
// 在端口监听3000
app.listen(3000);
console.log('app started at port 3000...');