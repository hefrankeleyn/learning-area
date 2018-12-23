<?php
# 设置cookie必须在html之前 
#setcookie("username","xiaoMing",time()+3600);
# 防止url编码
setrawcookie("username","xiaoMing",time()+3600);

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
    # 获取cookie
    echo $_COOKIE["username"]." ni hao.<br>";

    # 展示所有的cookie
    print_r($_COOKIE);

    # 删除cookie
    setcookie("username","",time()-3600);

    # 判断是否设置cookie，如果设置了，获取到cookie
    if(isset($_COOKIE["username"])){
        echo "<br>welcome to ".$_COOKIE["username"]." <br>";
    }else{
        echo "<br>Welcome to guess.<br>";
    }
    ?>
</body>
</html>