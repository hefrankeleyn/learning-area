<?php
// 填充数组
$a = array("Anna", "Brittany", "Cinderella", "Diana", "Eva", 
          "Fiona", "Gunda", "Hege", "Inga", "Johanna", "Kitty", 
          "Linda", "Nina", "Ophelia", "Petunia", "Amanda", "Raquel", 
          "Cindy", "Doris", "Eve", "Evita", "Sunniva", "Tove", "Unni", 
          "Violet", "Liza", "Elizabeth", "Ellen", "Wenche", "Vicky");
#print_r($a);
// 从url请求中获取q参数
$q = $_GET["q"];

// 如果 $q的长度大于0，从数组中查找所有的长度
if(strlen($q)>0){
    $hint = "";
    for($i=0;$i<count($a);$i++){
        if(strtolower($q) === strtolower(substr($a[$i],0,strlen($q)))){
            if($hint===""){
                $hint = $a[$i];
            }else{
                $hint =$hint.", ".$a[$i];
            }
        }
    }
    // 如果提示没有发现，就输出 “no suggestion”
    // or to the current values
    if($hint === ""){
        $response = "no suggestion";
    }else{
        $response = $hint;
    }

    // 输出$response
    echo $response;
}

?>