const WebSocket = require('ws');
var ws = new WebSocket('ws://localhost:3000/test');

// 打开websocket连接之后，立刻发送一条消息
ws.on('open',function(){
    console.log(`[CLIENT] open()`);
    ws.send('Hello !');
});

ws.on('message',function(message){
    console.log(`[CLIENT] Received: ${message}`);
});