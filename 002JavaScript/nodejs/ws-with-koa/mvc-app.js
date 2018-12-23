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

const WebSocket = require('ws');

const WebSocketServer = WebSocket.Server;

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
let server = app.listen(3000);

function parseUser(obj){
    if(!obj){
        return;
    }
    console.log('try parse:'+obj);

    let s='';
    if(typeof obj === 'string'){
        s=obj
    } else if(obj.headers){
        let cookies = new Cookies(obj,null);
        s= cookies.get('name');
    }

    if(s){
        try{
            let user = JSON.parse(Buffer.from(s, 'base64').toString());
            console.log(`User: ${user.name},ID:${user.id}`);
            return user;
        }catch(err){
            console.log(err);
        }
    }
}

var messageIndex = 0;

function createMessage(type, user, data){
    messageIndex++;
    return JSON.stringify({
        id: messageIndex,
        type: type,
        user: user,
        data:data
    });
}

function onConnect(){
    let user = this.user;
    let msg = createMessage('join',user,`${user.name} joined`);
    this.wss.broadcast(msg);
    // build user list
    let users = this.wss.clients.map(function(client){
        return client.user;
    });
    this.send(createMessage('list', user, users));
}

function onMessage(message){
    console.log(message);
    if(message && message.trim()){
        let msg = createMessage('char',this.user,message.trim());
        this.wss.broadcast(msg);
    }
}

function onClose(){
    let user = this.user;
    let msg = createMessage('left', user, `${user.name} is left.`);
    this.wss.broadcast(msg);
}

function onError(err){
    console.log(err);
}

function createWebSocketServer(server, onConnect, onMessage, onClose){
    let wss = new WebSocketServer({
        server: server
    });

    wss.broadcast = function(data){
        wss.clients.forEach(function(client){
            client.send(data);
        });
    }

    onConnect = onConnect || function(){
        console.log('[WebSocket] connected.');
    };

    onMessage = onMessage || function(msg){
        console.log('[WebSocket] message received: '+msg);
    };

    onClose = onClose || function(code, message){
        console.log(`[WebSocket] closed: ${code},${message}`);
    };

    onError = onError || function(err){
        console.log('[WebSocket] error: '+err);
    };

    wss.on('connection',function(ws){

        let location = url.parse(ws.upgradeReq.url,true);
        console.log('[WebSocketServer] connection: '+location.href);
        ws.on('message',onMessage);
        ws.on('close',onClose);
        ws.on('error',onError);
        if(location.pathname != '/ws/chat'){
            // close ws
            ws.close(4000,'Invalid URL');
        }

        // check user
        let user = parseUser(ws.upgradeReq);
        if(!user){
            ws.close(4000, 'Invalid user');
        }
        
    
        // 识别成功，把user绑定到WebSocket对象上
        ws.user = user;
    
        // 绑定wss对象
        ws.wss = wss;
        onConnect.apply(ws);
    });
    console.log('WebSocketServer was attached.');
    return wss;
}

app.wss = createWebSocketServer(server,onConnect,onMessage,onClose,onError);

console.log('app started at port 3000...');


