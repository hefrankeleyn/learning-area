'use strict';
// koa2中，导入的是一个class，所以用大写表示
const Koa = require('koa');

// require('koa-router')返回的是一个函数
const router = require('koa-router')();

// 用于解析body
const bodyParser = require('koa-bodyparser');

// 创建一个koa对象表示web app本身
const app = new Koa();

// 导入Controller
const controller = require('./mvc-controller');

const templating = require('./mvc-templating');

const isProduction = process.env.NODE_ENV === 'production';

//第一个middleware
app.use(async (ctx,next) =>{
    console.log(`Process ${ctx.request.method} ${ctx.request.url}...`);
    const start = new Date().getTime(); //当前时间

    await next();
    const ms = new Date().getTime() - start;
    console.log(`Time: ${ms}ms`);
    console.log('isProduction: '+isProduction);
    ctx.response.set('X-Response-Time', `${ms}ms`);
});

// 第二个middlerware
if(!isProduction){
    let staticFiles = require('./mvc-static-files');
    app.use(staticFiles('/statics/',__dirname+'/statics'));
}

// 第三个middlerware，解析post请求
app.use(bodyParser());

// 第四个
app.use(templating('views',{
    noCache: !isProduction,
    watch: !isProduction
}));

// 第五个
// 使用middlerware
app.use(controller());
// 在端口监听3000
app.listen(3000);
console.log('mvc app started at port 3000...');



