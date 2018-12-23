<?php
    //连接数据库
    // mysql_ 这种方法在php7中已经移除，改为连接数据库
    # mysql_* functions have been removed in PHP 7
   /*
    $con = mysql_connect("localhost","php","world");
    if(!$con){
        die("could not connect: ". mysql_error());
    }
    mysql_close($con);
    */
    # 从老的mysql拓展迁移，面向过程
    /*
    $mysqli = mysqli_connect("localhost","php","php@world","php_db");

    $res = mysqli_query($mysqli, "select 'Please, do not use ' as _msg from dual");
    $row = mysqli_fetch_assoc($res);
    echo $row['_msg'];
    */

    # 面向过程和面向对象的方法

    // 面向过程
    $mysqli = mysqli_connect("localhost","php","php@world", "php_db");
    if(mysqli_connect_errno($mysqli)){
        echo "Failed to connect to MySql: ".mysqli_connect_error();
        return;
    }
    $res = mysqli_query($mysqli,"select 'A world full of' as _msg from dual");
    $row = mysqli_fetch_assoc($res);
    echo $row["_msg"]."<br>";
    mysqli_close($mysqli);

    // 面向对象
    $mysqli_o = new mysqli("localhost","php","php@world","php_db");
    if($mysqli_o ->connect_errno){
        echo "Failed to connect Mysql: ".$mysqli_o ->connect_errno;
        return;
    }
    $res_o = $mysqli_o ->query("select 'object-oriented interface' as _msg from dual");
    $row_o = $res_o->fetch_assoc();
    echo $row_o["_msg"]."<br>";

    $mysqli_o->close();

    echo "<p>特殊的localhost</p>";
    $mysqli01 = new mysqli("localhost","php","php@world","php_db");
    if($mysqli01->connect_errno){
        echo "Failed to connect MySql (".$mysqli01->connect_errno.") ".$mysqli01->connect_error;
    }
    echo $mysqli01->host_info ."\n";
    $mysqli01->close();
    
    $mysqli02 = new mysqli("127.0.0.1","php","php@world","php_db");
    if($mysqli02->connect_errno){
        echo "Failed to connect MySql (".$mysqli02->connect_errno.") ".$mysqli02->connect_error;
    }
    echo $mysqli02->host_info ."\n";
    $mysqli02->close();

    echo "<p>执行语句</p>";
    $mysqli03 = new mysqli("localhost","php","php@world","php_db");
    if($mysqli03->connect_errno){
        echo "Failed to connect Mysql [".$mysqli03->connect_errno."]".$mysqli03->connect_error;
    }


    $drop_str = "drop table if exists php_test";
    $create_str = "create table if not exists php_test(id int,name varchar(50))";
    $insert_str = "insert into php_test(id,name) values(0,'aaa'),(1,'bbbb'),(2,'ccc'),(3,'ddd')";

    # 删除表
    $drop_result = $mysqli03->query($drop_str);
    echo "drop table:".$drop_result."<br>";
    if(!$drop_result){
        echo "Failed (".$mysqli03->errno.") :".$mysqli03->error;
        return;
    }
    # 创建表
    $create_result = $mysqli03->query($create_str);
    echo "create table: $create_result <br>";
    if(!$create_result){
        echo "Failed (".$mysqli03->errno.") :".$mysqli03->error;
        return;
    }
    # 插入数据
    $insert_result = $mysqli03->query($insert_str);
    echo "insert: $insert_result";
    if(!$insert_result){
        echo "Failed (".$mysqli03->errno.") :".$mysqli03->error;
        return;
    }
    # 查询数据
    $select_result = $mysqli03->query("select id,name from php_test");
    print_r($select_result);
    echo "<br>";
    # 遍历结果,第一种遍历方法
    echo "<p>第一种遍历方法：</p>";
    for($row_no=0; $row_no<$select_result->num_rows;$row_no++){
        $select_result->data_seek($row_no);
        $rows = $select_result->fetch_assoc();
        foreach($rows as $key=>$value){
            echo "$key:$value ";
        }
        echo "<br>";
    }

    # 遍历查询结果，第二种遍历方法
    //$select_result = $mysqli03->query("select id,name from php_test");
    $select_result->data_seek(0);
    echo "<p>第二种遍历方法：</p>";
    while($row=$select_result->fetch_assoc()){
        echo " id= ".$row["id"]." name=".$row["name"];
        echo "<br>";
    }
    echo "<br>";

    # 关闭连接
    $mysqli03->close();
    
?>