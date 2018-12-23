'use strict';

var fn_index = async (ctx,next) => {
    ctx.render('index.html',{
        title: 'Welcome'
    });
};

var fn_signin = async (ctx,next) =>{
    var 
        email = ctx.request.body.email || '',
        password = ctx.request.body.password || '';
        console.log(`signin with name:${email},password: ${password}`);
    if (email === 'admin@example.com' && password ==='123'){
        ctx.render('signin-ok.html', {
            title: 'Sign In Ok',
            name: 'Node test'
        });
    }else {
        ctx.render('signin-failed.html',{
            title: 'Sign In Failed'
        });
    }
};

var fn_ws_dialog = async (ctx,next) =>{
    ctx.render('ws-dialog.html',{
        title: 'dialog'
    });
};

module.exports = {
    "GET /": fn_index,
    "POST /signin": fn_signin,
    "GET /views/ws-dialog": fn_ws_dialog
};