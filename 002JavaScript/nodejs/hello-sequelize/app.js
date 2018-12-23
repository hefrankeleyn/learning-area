'use strict';

const Sequelize = require('sequelize');
const config = require('./config');

// 创建sequelize 对象
var sequelize  = new Sequelize(config.database, config.username, config.password, {
    host: config.host,
    dialect: 'mysql',
    pool: {
        max: 5,
        min: 0,
        idle: 30000
    }
});

// 定义student模型，告诉Sequelize如何映射数据库表
var Student = sequelize.define('students', {
    id: {
        type: Sequelize.STRING(50),
        primaryKey: true
    },
    sname: Sequelize.STRING(100),
    birthday: Sequelize.STRING(10),
    createdAt: Sequelize.BIGINT,
    updatedAt: Sequelize.BIGINT,
    version: Sequelize.BIGINT
}, {
    timestamps: false
});


// 使用 Promise 方法操作数据库表
var now = Date.now();

Student.create({
    id: 'g-'+now,
    sname: 'aaa',
    birthday: '2011-07-08',
    createdAt: now,
    updatedAt: now,
    version: 0
}).then(function(p){
    console.log('created: '+JSON.stringify(p));
}).catch(function(e){
    console.log('failed: '+e);
});

/**
 * 问题修复： sequelize.js - You need to install mysql package manually
 *  npm install --save mysql2
 */

 // 使用await写法,创建一条记录
 /*
 (async ()=>{
    var student = await Student.create({
        id: 'd--'+now,
        sname: 'bbb',
        birthday: '2018-02-02',
        createdAt: now,
        updatedAt: now,
        version: 0
    });
    console.log("created: " + JSON.stringify(student));
 })();
 */

 // 查询数据，使用await写法
 /*
 (async ()=>{
     var students = await Student.findAll({
         where:{
             sname:'aaa'
         }
     });
     console.log("findAll: "+JSON.stringify(students));
     for(let s in students){
         console.log(JSON.stringify(s));
     }
 })();
*/

// 更新数据
/*
(async ()=>{
    let s = await Student.findById('d--1544250584015');
    s.sname = 'bcf';
    s.updatedAt = Date.now();
    s.version ++;
    await s.save();
})();

// 删除数据
(async ()=>{
    let s = await Student.findById('g-1544250130308');
    await s.destroy();
})();
*/