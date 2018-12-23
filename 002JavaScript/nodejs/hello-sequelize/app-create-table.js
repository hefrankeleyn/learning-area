const model = require('./model.js');
let Pet = model.Pet;
let User = model.User;
(async () =>{
    var user = await User.create({
        uname: 'xiao ming',
        password: '123',
        gender: false,
        email: 'xiaoming03@gmail.com'
    });
    console.log('created: '+ JSON.stringify(user));

    var pet = await Pet.create({
        ownerId: user.id,
        name: 'aaa',
        gender: true,
        birthday: '2018-10-11'
    });
    console.log('created: '+JSON.stringify(pet));
})();