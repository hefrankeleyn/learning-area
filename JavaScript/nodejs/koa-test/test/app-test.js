const supertest = require('supertest');
const app = require('../app');

describe('#test koa app:',() =>{
    let server = app.listen(9090);
    describe('#test server', ()=>{
        it('#test GET /',async ()=>{
            let res = await supertest(server)
                      .get("/")
                      .expect('Content-type', /text\/html/)
                      .expect(200,'<h1>Hello,world!</h1>');
        });

        it('#test GET /path?name=Body',async ()=>{
            let res = await supertest(server)
                            .get("/path?name=Body")
                            .expect('Content-type', /text\/html/)
                            .expect(200,'<h1>Hello,Body!</h1>');
        });
    });
});