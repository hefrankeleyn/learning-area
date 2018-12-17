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
        // 定义变量，并设置为空值
        $username = $email = $website = $comment = $gender = "";
        // 对用户输入的数据进行处理
        function test_input($data){
            # 去除数据两边的空格
            $data = trim($data);
            # 删除用户输入的反斜杠
            $data = stripslashes($data);
            # 转换用户输入的特殊字符
            $data = htmlspecialchars($data);
            return $data;
        }
        // 
        if ($_SERVER["REQUEST_METHOD"] === "POST"){
            $username = test_input($_POST["username"]);
            $email = test_input($_POST["email"]);
            $website = test_input($_POST["website"]);
            $comment = test_input($_POST["comment"]);
            $gender = test_input($_POST["gender"]);
        }
        
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
        <p>
            姓名：<input name="username" type="text">
        </p>
        <p>
            邮箱：<input name="email" type="text">
        </p>
        <p>
            网址：<input name="website" type="text">
        </p>
        <p>
            评论：<textarea name="comment" id="" cols="30" rows="10"></textarea>
        </p>
        <p>
            <span>性别：</span>
            <span><input type="radio" name="gender" value="female"> FeMale </span>
            <span><input type="radio" name="gender" value="male"> Male </span>
        </p>
        <p><button type="submit">submit</button></p>
    </form>

    <?php
        echo "<h2>输入的值如下：</h2>";
        echo $username."<br>";
        echo $email."<br>";
        echo $website."<br>";
        echo $comment."<br>";
        echo $gender."<br>";
    ?>
</body>
</html>