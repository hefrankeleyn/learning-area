'use strict';

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

var env = createEven('views',{
    watch: true,
    filters: {
        hex: function(n){
            return '0x' + n.toString(16);
        }
    }
});

var s = env.render("base.html",{"name":"xiaoming"});
console.log(s);