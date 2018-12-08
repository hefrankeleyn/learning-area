'use strict'

const nunjucks = require('nunjucks');

function createEven(path,opts){
    var 
        autoescape = opts.autoescape === undefined ? true:opts.autoescape,
        noCache = opts.noCache || false,
        watch = opts.watch || false,
        throwOnUndefined = opts.throwOnUndefined || false,
        env = new nunjucks.Environment(new nunjucks.FileSystemLoader('views',{
            noCache: noCache,
            watch: watch,
        }),{
            autoescape: autoescape,
            throwOnUndefined: throwOnUndefined
        });
    if (opts.filters){
        for(let f in opts.filters){
            env.addFilter(f, opts.filters[f]);
        }
    }
    return env;
}

function templating(path, opts){
    // 创建Nunjucks 的env对象
    var env = createEven(path,opts);

    return async (ctx, next) =>{
        // 给ctx绑定render函数
        ctx.render = function(view,model){
            // 给ctx绑定render函数
            ctx.response.body = env.render(view, Object.assign({}, ctx.state || {}, model || {}));

            // 设置Content-type
            ctx.response.type = 'text/html';
        };

        //继续处理请求
        await next();
    };
}

module.exports = templating;