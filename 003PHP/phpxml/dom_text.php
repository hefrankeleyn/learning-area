<?php
    # dom 把xml当做树状进行处理
    $xmlDoc = new DOMDocument();
    $xmlDoc ->load("php_text.xml");

    print $xmlDoc->saveXML();

    // 循环note中的所有元素
    $x = $xmlDoc->documentElement;
    foreach($x ->childNodes as $item){
        print $item->nodeName." = ".$item->nodeValue. "<br>";
    }
?>