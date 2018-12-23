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

        echo date_default_timezone_get()."<br>";
        /*
        如果返回的时间不正确，可能是因为服务器位于其他国家或被设置成其他时区,
        设置正确的时区之后，就可以返回正确的值了。
        */
        date_default_timezone_set("Asia/Shanghai");
        # date
        # Y m d h i s a
        $nowDatetime = date("Y-m-d h:i:s a");
        echo $nowDatetime;
        echo "<br>";
        echo "now is ".date("H:i:sa")."<br>";

        # mktime 返回时间戳
        # mktime(hour,minute,second,month,day,year);
        $d = mktime(5,30,00,12,18,2018);
        echo $d;
        echo "<br>";
        echo date("Y-m-d",$d);

        # 使用字符串创建时间
        $d02 = strtotime("2018-10-11");
        echo "<br>".date("Y-m-d H:i:s",$d02)."<br>";
    ?>
</body>
</html>