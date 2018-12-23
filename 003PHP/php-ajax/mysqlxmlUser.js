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
        var url = generateUrl("mysqlxmlUser.php",str);
        xmlHttp.open("GET",url,true);
        xmlHttp.send(null);
    }
    // ajax 请求成功，进行的操作
    function stateChanged(){
        if(xmlHttp.readyState==4 || xmlHttp.readyState == "complete"){
            var xmlDoc = xmlHttp.responseXML;
            // 设置firstname的值
            setElementValueByIdName("firstname",xmlDoc,"firstname");
            // 设置lastname的值
            setElementValueByIdName("lastname",xmlDoc,"lastname");
            // 设置job的值
            setElementValueByIdName("job",xmlDoc,"job");
            // 设置age_text的值
            document.getElementById("age_text").innerHTML = "Age: ";
            //设置age的值
            setElementValueByIdName("age",xmlDoc,"age");
            //设置hometown_text的值
            document.getElementById("hometown_text").innerHTML = "<br/> From: ";
            //设置homeTown的值
            setElementValueByIdName("hometown",xmlDoc,"hometown");

        }
    }

    // 为element元素设置值
    function setElementValueByIdName(idName,xmlDoc,elementName){
        //console.log(xmlDoc);
        document.getElementById(idName).innerHTML = 
                xmlDoc.getElementsByTagName(elementName)[0].childNodes[0].nodeValue;
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