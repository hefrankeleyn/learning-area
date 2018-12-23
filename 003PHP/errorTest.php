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
    /*
        # 简单的错误处理
        if(!file_exists("test.txt")){
            die("text.txt file not exists");
        }
    */
    
    /*
        # 自定义错误处理
        // 创建自定义错误处理器
        function error_function($errno, $errorStr){
            echo "<b>Error:</b>[$errno] $errorStr<br/>";
        }

        // 将上面的函数设置为脚本执行过程中，默认的错误处理函数
        set_error_handler("error_function");

        // 触发错误， trigger error
        echo $test;
    */
        # 触发错误
        /*
            //Notice: Value must be 1 or below. in F:\ApatchInstallWorkspace\dev\servers\httpd\Apache24\htdocs\errorTest.php on line 34
            $test = 2;
            if($test>1){
                trigger_error("Value must be 1 or below.");
            }
        */

        # 定义错误级别
        function customError($err_level,$err_str){
            echo "<b>Error:</b>[$err_level] $err_str<br>";
            echo "ending";
            die();
        }

        // 设置错误处理
        set_error_handler("customError",E_USER_WARNING);

        // trigger error
        $test = 2;
        if ($test>1){
            trigger_error("Value must be 1 or below",E_USER_WARNING);
        }

        echo "i have a dream."
    ?>
</body>
</html>