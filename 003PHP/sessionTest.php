<?php
# 使用session，必须先开启session
# 启动session必须位于<html>之前
session_start();

# 存错session
//$_SESSION["view"] = 1;
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <?php
    # 获取session
    #echo "Pageviews= ".$_SESSION["view"];

    # 制作一个简单的计数器
    if(isset($_SESSION["view"])){
        $_SESSION["view"]=$_SESSION["view"]+1;
    }else{
        $_SESSION["view"]=1;
    }
    echo "views= ".$_SESSION["view"]."times";

    # 终结session
    # 终结特定的session
    unset($_SESSION["view"]);

    # 终结所有的session
    session_destroy();
    ?>
</body>
</html>