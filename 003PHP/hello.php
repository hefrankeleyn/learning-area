<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Hello PHP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <?php 
        // hello php
        echo 'hello world, i am php.';
    ?>
    <?php
        # 函数、类、关键字不区分大小写
        echo 'hello';
        EcHo 'world';
        ECHO '<br>';
        /*
            变量区分大小写
        */
        $color="red";
        echo "my car is " . $color ."<br>";
        //echo "my hour is " . $Color . "</br>"
       // echo 'my boat is ' . $COLOR . </br>

       # 变量
       $a = 23;
       $b = 25;
       $c = $a+$b;
       echo $c;
       echo "<br/>";

       # 函数
       function testFun(){
            static $a = 0;
            echo $a;
            echo "<br/>";
            $a++;
       }

       testFun();
       testFun();
       testFun();
       echo "<br>";
       // echo 和print
       echo "<h2>PHP is fun</h2>";
       echo "This"," string ","was mad ","with multiple parameters";

       $txt1 = "PHP";
       $cars = array("aaa","bbb","ccc");

       echo "I learning $txt1";
       echo "My car is a {$cars[0]}";

       print "$txt1 is fun.<br>";
       print "I'm learning php.";

       $p1 = print("good<br>");
       echo $p1;

       class Car{
           var $color;
           function Car($color="green"){
               $this->color = $color;
           }

           function whatColor(){
               return $this->color;
           }
       }
       $a = "aaa";
       var_dump($a);
       # 常量
       define("GREENING","dream");

       //  串接
       $b = "bbb<br>";
       $c = $a.$b;
       echo $c;
       # 串接赋值
       $b .= $c;
       echo $b;
    ?>

</body>
</html>