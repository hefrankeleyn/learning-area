'use strict';
// koa2中，导入的是一个class，所以用大写表示
const Koa = require('koa');

// 创建一个koa对象表示web app本身
const app = new Koa();
//
/*
// 对于任何请求，app将调用该异步函数处理请求
app.use(async (ctx,next) =>{
    await next();
    ctx.response.type = 'text/html';
    ctx.response.body = '<h1>Hello,koa2!</h1>';
});
*/
// 测试await next() 的效果。koa将很多async函数组成一个处理链，
// 每一个async函数都可以做一些自己的事情，然后用 await next() 执行下一个async
app.use(async (ctx,next) =>{
    console.log(`${ctx.request.method}${ctx.request.url}`);
    await next();
});

app.use(async (ctx,next) =>{
    const start = new Date().getTime(); //当前时间
    await next();
    const ms = new Date().getTime() - start;
    console.log(`Time: ${ms}ms`);
});
app.use(async (ctx,next) =>{
    await next();
    ctx.response.type = 'text/html';
    ctx.response.body = '<h1>Hello,Koa2,haha!</h1>';
});

// 在端口监听3000
app.listen(3000);
console.log('app started at port 3000...');