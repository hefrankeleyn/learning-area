(function(){// 用于获取xmlHttpRequest
function GetXmlHttpObject(){
    var xmlHttp = null;
    try{
        // Firfox, Opera 8+, safari
        xmlHttp = new XMLHttpRequest();
    }catch(e){
        try{
            // Internet Explorer
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}
var xmlHttp;

// 展示hint
function showHint(str){
    if(str.length == 0){
        document.getElementById("txtHint").innerHTML = "";
        return;
    }
    // 创建xmlHttp
    xmlHttp = GetXmlHttpObject();
    if(xmlHttp==null){
        console.log("Brower does not suppert Http Request.");
        return;
    }
    xmlHttp.onreadystatechange = stateChanged;
    url = generateUrl("input.php",str);
    console.log(url);
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}

// 拼接url，拼接一个随机数，防止使用缓存
function generateUrl(php_path,str){
    var url = php_path+"?q="+str;
    url += "&sid="+Math.random();
    return url;
}

function stateChanged(){
    if(xmlHttp.readyState == 4 || xmlHttp.readyState == "complete"){
        document.getElementById("txtHint").innerHTML = xmlHttp.responseText;
    }
}

// 添加监听事件
var inputObj = document.getElementById("txt01");

inputObj.removeEventListener("keyup",function(){
    showHint(inputObj.value);
});
inputObj.addEventListener("keyup",function(){
    showHint(inputObj.value);
});
})();

