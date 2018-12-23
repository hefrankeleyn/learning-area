<?php
$q = $_GET["q"];

// 加载xml文件
$xmlDoc = new DOMDocument();
$xmlDoc->load("cdxml.xml");

$x = $xmlDoc->getElementsByTagName("ARTIST");

for($i=0;$i<$x->length;$i++){
    // 判断是否为 节点，使用 nodetype = 1 ，ELEMENT_NODE
    if($x->item($i)->nodeType === 1){
        if($x->item($i)->childNodes->item(0)->nodeValue === $q){
            $y = ($x->item($i)->parentNode);
        }
    }
}
$cd = ($y->childNodes);

for($i=0;$i<$cd->length;$i++){
    if($cd->item($i)->nodeType === 1){
        echo $cd->item($i)->nodeName;
        echo " : ";
        echo $cd ->item($i)->childNodes->item(0)->nodeValue;
        echo "<br>";
    }
}

?>