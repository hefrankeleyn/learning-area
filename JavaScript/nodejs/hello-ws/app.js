// 导入WebSocket 模块
const WebSocket = require('ws');

// 引入Server类
const WebSocketServer = WebSocket.Server;

// 实例化
const wss = new WebSocketServer({
    port: 3000
});


// 处理WebSocket请求
wss.on("connection",function(ws){
    console.log('[SERVER] connection()');
    ws.on('message', function(message){
        console.log(`[SERVER] Received:${message}`);
        ws.send(`ECHO: ${message}`,(err)=>{
            if(err){
                console.log(`[SERVER] error: ${err}`);
            }
        }
        );
    });
});
