<?php
$xmlDoc = new DOMDocument();
$xmlDoc->load("xmlLink.xml");

$x = $xmlDoc->getElementsByTagName("link");

// 从url中获取参数为q的值
$q = $_GET["q"];

// 检查$q的长度是否大于0
$hint = "";
if(strlen($q)>0){
    for($i=0;$i<($x->length);$i++){
        $titles = $x->item($i)->getElementsByTagName("title");
        $urls = $x->item($i)->getElementsByTagName("url");

        if($titles->item(0)->nodeType === 1){
            // 查找匹配$q值的链接
            if(stristr($titles->item(0)->childNodes->item(0)->nodeValue,$q)){
                if($hint === ""){
                    $hint = "<a href='
                    ".$urls->item(0)->childNodes->item(0)->nodeValue."' target='_blank'>".
                    $titles->item(0)->childNodes->item(0)->nodeValue
                    ."</a>";
                }else{
                    $hint =$hint."<br>"."<a href='
                    ".$urls->item(0)->childNodes->item(0)->nodeValue."' target='_blank'>".
                    $titles->item(0)->childNodes->item(0)->nodeValue
                    ."</a>";
                }
            }
        }
    }
}
if($hint === ""){
    $response = "no suggestion";
}else{
    $response = $hint;
}
// 输出 response 
echo $response;
?>