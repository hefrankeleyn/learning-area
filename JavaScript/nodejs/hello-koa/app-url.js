'use strict';
// koa2中，导入的是一个class，所以用大写表示
const Koa = require('koa');

// require('koa-router')返回的是一个函数
const router = require('koa-router')();

// 用于解析body
const bodyParser = require('koa-bodyparser');

// 创建一个koa对象表示web app本身
const app = new Koa();
//在合适的位置添加上下面的一句话
app.use(bodyParser());

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
    console.log(`Process ${ctx.request.method}${ctx.request.url}`);
    await next();
});

// add router
/** 处理get请求
router.get("/hello/:name",async (ctx, next) =>{
    var name = ctx.params.name;
    ctx.response.body = `<h1>Hello,${name}</h1>`;
});

router.get('/',async (ctx,next) =>{
    ctx.response.body = '<h1>Index</h1>';
});
*/
/*
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
*/

// post 请求,创建一个表单
router.get("/",async (ctx,next) =>{
    ctx.response.body = `<h1>Index</h1>
        <form action="/signin" method="post">
            <p>Name:<input name="name" value="koa"></p>
            <p>Password:<input name="password" value="123"></p>
            <p><input type="submit" value="Submit"></p>
        </form>`;
});

router.post("/signin",async (ctx,next) =>{
    var 
        name = ctx.request.body.name || '',
        password = ctx.request.body.password || '';
    console.log(`signin with name:${name},password: ${password}`);
    if (name === 'koa' && password ==='123'){
        ctx.response.body = `<h1>Welcome,${name}</h1>`;
    }else {
        ctx.response.body = `<h1>Login failed!</h1>
            <p><a href="/">Try again!</a></p>`;
    }

});
// add router middleware
app.use(router.routes());

// 在端口监听3000
app.listen(3000);
console.log('app started at port 3000...');