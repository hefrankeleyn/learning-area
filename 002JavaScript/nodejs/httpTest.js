'use strict';
// 导入http模块
var http = require('http');

// 创建http server,并导入回调函数
var server = http.createServer(function(request,response){
    //回调函数接受request和response
    // 获取HTTP请求的method和url
    console.log(request.method+":"+request.url);
    // 将http响应200 写入response，同时设置Content-type:text/html
    response.writeHead(200,{'Content-type':'text/html'});
    // 将http响应的HTML内容写入到response；
    response.end("<h1>Hello World!</h1>");

});

// 让服务器监听8080端口
server.listen(8080);
console.log('Server is running at http://127.0.0.1:8080/');
