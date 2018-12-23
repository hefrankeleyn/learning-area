const assert = require('assert');
const sum = require('../hello');

describe('#hello.js', ()=>{
    describe('#sum()',()=>{
        before(function(){
            console.log('before....');
        });
    
        after(function(){
            console.log('after....');
        });
    
        beforeEach(function(){
            console.log(' before Each ');
        });
    
        afterEach(function(){
            console.log(' after Each ');
        });
    
        it('sum() should return 0', ()=>{
            assert.strictEqual(sum(),0);
        });
    
        it('sum(1) should return 1', ()=>{
            assert.strictEqual(sum(1),1);
        });
    
        it('sum(1,2) should return 3', ()=>{
            assert.strictEqual(sum(1,2),3);
        });
    
        it('sum(1,2,3) should return 6', ()=>{
            assert.strictEqual(sum(1,2,3),6);
        });
    });
});

// 第一种测试方法，在hello-test 目录下运行：　node node_modules\mocha\bin\mocha

// 第二种方法，在package.json中配置scripts

// 第三种方法，"program": "${workspaceFolder}/node_modules/mocha/bin/_mocha"