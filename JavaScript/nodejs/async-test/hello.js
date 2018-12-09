const fs = require('mz/fs');

// a simple asyn function
module.exports = async ()=>{
    let expression = await fs.readFile('./data.txt','UTF-8');
    let fn = new Function("return " + expression);
    let r = fn();
    console.log(`Calculate: ${expression} = ${r}`);
    return r;
}
