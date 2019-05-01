// 加载页面方法一：
window.onload = function (ev) {
    var marco = document.getElementById("marco");
    marco.addEventListener("click", function(){
        console.log("aaa");
    });
}

// 使用jquery的方式加载
/*$(document).ready(function(){
    $("#marco").click(function(){
        console.log("jquery")
    });
});*/
