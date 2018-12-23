<?php
    $ip = "localhost";
    $username = "php";
    $password = "php@world";
    $database = "php_db";
    // 建立mysql数据库连接
    function getMysqli($ip,$username,$password,$database){
        $mysqli = new mysqli($ip,$username,$password,$database);
        if($mysqli->connect_errno){
            echo "Failed to connect (".$mysqli->connect_errno."), ".$mysqli->connect_error;
            return "error";
        }
        return $mysqli;
    }
    //错误处理
    function echoError($mysqli){
        return "Failed (".$mysqli->errno.") ".$mysqli->error;
    }
    // 初始化表
    function initTable($ip,$username,$password,$database){
        $mysqli = getMysqli($ip,$username,$password,$database);

        // 如果表存在，就将表删除
        $drop_table = "drop table if exists users";
        $drop_res = $mysqli->query($drop_table);

        if(!$drop_res){
            echo echoError($mysqli);
            return;
        }

        // 创建表
        $create_table = "create table if not exists users(
                        uid int,
                        firstname varchar(50),
                        lastname varchar(50),
                        age int,
                        hometown varchar(30),
                        job varchar(30)
                        )";
        $create_res = $mysqli->query($create_table);
        if (!$create_res){
            echo echoError($create_res);
            return;
        }

        // 对表中的数据进行初始化
        $insert_data = "insert into users(uid,firstname,lastname,age,hometown,job)
                        values(1,'Peter','Griffin',41,'Quahog','Brewery'),
                        (2,'Lois','Griffin',40,'Newport','Piano Teacher'),
                        (3,'Joseph','Swanson',39,'Quahog','Police Officer'),
                        (4,'Glenn','Quagmire',41,'Quahog','Pilot')";
        $insert_res = $mysqli->query($insert_data);
        if(!$insert_res){
            echo echoError($mysqli);
            return;
        }
        $mysqli->close();
    }
    # 对数据库进行初始化
    //initTable($ip,$username,$password,$database);

    function selectUsersByid($id){
        $select_str = "select uid,firstname,lastname,age,hometown,job
                       from users where uid=$id";
        // 创建mysqli
        
        $mysqli = getMysqli($GLOBALS['ip'],$GLOBALS['username'],$GLOBALS['password'],$GLOBALS['database']);
        $select_res = $mysqli->query($select_str);
        if(!$select_res){
            echo echoError($mysqli);
            return;
        }
        // 遍历 查询结果
        for($row_num=0;$row_num<$select_res->num_rows;$row_num++){
            $select_res->data_seek($row_num);
            $rows = $select_res->fetch_assoc();
            foreach($rows as $key=>$value){
                echo "$key : $value <br>";
            }
            echo "*******";
        }
        $mysqli->close();
    }

    $id = $_GET["q"];
    selectUsersByid($id);
?>