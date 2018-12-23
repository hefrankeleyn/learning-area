(function(){
    var cds = document.getElementById("users")
    cds.removeEventListener("change",function(){
        showCD(cds.value);
    });
    cds.addEventListener("change",function(){
        showCD(cds.value);
    });

    var xmlHttp;
    function showCD(str){
        xmlHttp = GetXmlHttpRequestObject();
        if(xmlHttp === null){
            console.log("Browser does not support Http request.");
            return;
        }
        xmlHttp.onreadystatechange = stateChanged;
        var url = generateUrl("mysqlUser.php",str);
        xmlHttp.open("GET",url,true);
        xmlHttp.send(null);
    }
    // ajax 请求成功，进行的操作
    function stateChanged(){
        if(xmlHttp.readyState==4 || xmlHttp.readyState == "complete"){
            var txtHint = document.getElementById("txtHint")
            txtHint.innerHTML = xmlHttp.responseText;
        }
    }
    // 拼接url，拼接一个随机数，防止使用缓存
    function generateUrl(php_path,str){
        var url = php_path+"?q="+str;
        url += "&sid="+Math.random();
        return url;
    }
    // 获取xmlRequestObject
    function GetXmlHttpRequestObject(){
        var xmlHttp=null;
        try{
            // Fire,Opera 8+, Safari
            xmlHttp = new XMLHttpRequest();
        }catch(e){
            // Internet Explorer
            try{
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            }catch(e){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        return xmlHttp;
    }
})();