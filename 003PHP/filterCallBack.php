<?php
function convertSpace($string){
    return str_replace("_"," ", $string);
}

$str = "I_have_a_dream.";
$reslut = filter_var($str,FILTER_CALLBACK, array("options"=>"convertSpace"));

echo $reslut;

?>