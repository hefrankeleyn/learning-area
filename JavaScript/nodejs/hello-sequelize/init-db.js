const model = require('./model.js');
model.sync();

console.log('init db ok...');

// 注释掉这一行，运行 node init-db.js 就可以建表了
//process.exit(0);