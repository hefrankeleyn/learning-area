'user strict';

module.exports = function(...rest){
    var sum =0;
    console.log(rest);
    for (let n of rest){
        sum += n;
    }
    return sum;
}