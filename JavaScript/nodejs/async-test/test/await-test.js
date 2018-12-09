const assert = require('assert');
const mocha = require('mocha');
const fs = require('mz/fs');
const hello = require('../hello');

mocha.describe('#await-test',() =>{
    it('#async with done',function(done){
        fs.readFile('./data.txt',function(err,data){
            if(err){
                done(err);
            } else{
                done()
            }
        });
    });

    it('#async with done', (done) =>{
        (async function(){
            try{
                let r = await hello();
                assert.strictEqual(r,10);
                done();
            }catch(err){
                done(err);
            }
        })();
    });

    it('#async test: ',async ()=>{
        let r =await hello();
        assert.strictEqual(r,10);
    });
});