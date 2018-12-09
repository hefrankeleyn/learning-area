const db = require('../db');

module.exports = db.defineModel('users',{
    email: {
        type: db.STRING(100),
        unique: true
    },
    uname: db.STRING(50),
    password: db.STRING(30),
    gender: db.BOOLEAN
});