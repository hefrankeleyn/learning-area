const db = require('../db');
module.exports = db.defineModel('pets',{
    ownerId: db.ID,
    name: db.STRING(100),
    gender: db.BOOLEAN,
    birthday: db.STRING(10)
});