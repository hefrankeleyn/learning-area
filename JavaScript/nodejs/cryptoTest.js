'use strict';

const crypto = require('crypto');

const hash = crypto.createHash('md5');

// 可任意多次调用update()

hash.update("Hello,world");
hash.update("I,have,a,dream");

console.log(hash.digest('hex'));

//
console.log('*******************************');
const hmac = crypto.createHmac('sha256','secret-key');
hmac.update('Hello,world');
hmac.update('Good');

console.log(hmac.digest('hex'));

//  AES

function aesEncrypt(data,key){
    const cipher = crypto.createCipher("aes192",key);
    var crypted = cipher.update(data, 'utf8', 'hex');
    crypted += cipher.final('hex');
    return crypted;
}

function aesDecrypt(encrypted, key) {
    const decipher = crypto.createDecipher('aes192',key);
    var decrypted = decipher.update(encrypted, 'hex', 'utf8');
    decrypted += decipher.final('utf8');
    return decrypted;
}

var data = "My name is lifei.";
var key =  "password";

var encrypted = aesEncrypt(data,key);
var decrypted = aesDecrypt(encrypted,key);

console.log('Plain text: '+data);
console.log('Encrypted text:'+ encrypted);
console.log('Decrypted text:'+decrypted);

// 密钥交换
console.log('密钥交换：************************');

var onePeople = crypto.createDiffieHellman(512);
var onePeopleKeys = onePeople.generateKeys();

var prime = onePeople.getPrime();
var generator = onePeople.getGenerator();

console.log('Prime: '+ prime.toString('hex'));
console.log('Generator: '+ generator.toString('hex'));

var anotherPeople = crypto.createDiffieHellman(prime, generator);
var anotherPeopleKeys = anotherPeople.generateKeys();

var onePeopleSecret = onePeople.computeSecret(onePeopleKeys);
var anotherPeopleSecret = anotherPeople.computeSecret(anotherPeopleKeys);

console.log('Secret of onePeople: '+ onePeopleSecret.toString('hex'));
console.log('Secret of anotherPeople: '+ anotherPeopleSecret.toString('hex'));

