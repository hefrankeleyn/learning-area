<?php
$int = 123;
// validate
function validateInt($int){
    if(!filter_var($int, FILTER_VALIDATE_INT)){
        echo "Integer is not valid";
        echo "<br/>";
    }else{
        echo "Integer is valid";
        echo "<br/>";
    }
}

validateInt($int);
validateInt("1l");

echo "<p>使用选线标志</p>";
# 使用选项和标志
function validateIntPlusParams($int,$validParam){
    echo "$int:<br>";
    if(!filter_var($int, FILTER_VALIDATE_INT,$validParam)){
        echo "Integer is not valid";
        echo "<br/>";
    }else{
        echo "Integer is valid";
        echo "<br/>";
    }
}

// 选项标志
$int_options = array("options"=>array(
    "min_range"=>3,
    "max_range"=>100
));

validateIntPlusParams(23,$int_options);
validateIntPlusParams(100,$int_options);
validateIntPlusParams(101,$int_options);
validateIntPlusParams(1,$int_options);

echo "<p>验证form</p>";
# 验证输入内容
if(!filter_has_var(INPUT_GET,"username")){
    echo "username is not exists.";
}else{
    if(!filter_has_var(INPUT_GET,"mail")){
        echo "mail is not exists";
    }
}
?>