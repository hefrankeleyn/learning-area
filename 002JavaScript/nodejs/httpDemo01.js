'use strict';

var 
    fs = require('fs'),
    url = require('url'),
    path = require('path'),
    http = require('http');

//从命令行获取root目录，默认为当前目录
var root = path.resolve(process.argv[2]||'.');

console.log('Static root dir: '+root);


//创建服务器
var server = http.createServer(function(request,response){
    // 获取url的path
    var pathname = url.parse(request.url).pathname;
    // 获取对应的本地文件路径
    var filepath = path.join(root,pathname);
    // 获取文件状态
    fs.stat(filepath,function(err,stats){
        if (!err && stats.isFile()){
            // 没有出错，并且文件存在
            console.log('200'+request.url);
            //发出200 响应
            response.writeHead(200);
            // 将文件流导向response
            fs.createReadStream(filepath).pipe(response);
        }else if (!err && stats.isDirectory()){
            console.log('This is a dictionary.');
            // 没有文件，是一个目录
            let f_p = path.join(root,'index.html');
            fs.exists(f_p,function(e){
                if(e){
                    console.log('200 '+' index.html or default.html');
                    response.writeHead(200);
                    fs.createReadStream(f_p).pipe(response);
                }else{
                    let f_p = path.join(root,'default.html');
                    fs.exists(f_p,function(e){
                        if(e){
                            console.log('200 '+' index.html or default.html');
                            response.writeHead(200);
                            fs.createReadStream(f_p).pipe(response);
                        }else{
                            // 文件不存在
                            console.log("404" + request.url);
                            // 发出404 响应
                            response.writeHead(404);
                            response.end("404 Not Found");
                        }
                    });
                }
            });
        }else{
            // 文件不存在
            console.log("404" + request.url);
            // 发出404 响应
            response.writeHead(404);
            response.end("404 Not Found");
        }
    });
});

server.listen(8080);
console.log('Server is running at http://127.0.0.1:8080/');