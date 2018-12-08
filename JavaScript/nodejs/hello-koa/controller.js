'use strict';

// 导入fs模块，fs是nodeJs的内置模块，用于读取读写文件
const fs = require('fs');

// 将处理映射的函数封装起来
function executeMapping(router,mapping){
    // 遍历mapping
    for(let url in mapping){
        console.log(url);
        if(url.startsWith("GET")){
            var path = url.substring(4);
            console.log('path: '+path+'mapping[url]: '+mapping[url]);
            router.get(path,mapping[url]);
            console.log(`Register url mapping:GET ${path}`);
        } else if (url.startsWith("POST")){
            var path = url.substring(5);
            router.post(path,mapping[url]);
            console.log(`register url mapping:POST ${path}`);
        } else{
            console.log(`invalid URL: ${url}`);
        }
    }
}

// 将执行流程也封装起来
function addController(router,dir){
    // 同步读取Controller文件目录
    var files = fs.readdirSync(__dirname+"/"+dir);
    // 过滤出fs文件
    var js_files = files.filter((f)=>{
        return f.endsWith('.js');
    });

    // 处理每一个js文件
    for(var f of js_files){
        console.log(`process controller: ${f}...`);
        // 导入js文件模块
        console.log(__dirname+'/'+dir+'/'+f);
        let mapping = require(__dirname+'/'+dir+'/'+f);
        executeMapping(router,mapping);
    }
}

module.exports = function(dir){
    //默认为controller目录
    let controller_dir = dir || 'controller';
    // require('koa-router')返回的是一个函数,用于处理不同请求的URL：GET、POST
    let router = require('koa-router')();
    addController(router,controller_dir);
    // 将处理的结果返回，随后由Koa进行http处理
    return router.routes();
}