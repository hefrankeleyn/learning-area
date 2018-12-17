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
        // 添加一组变量，用于存放每个字段的错误消息
        $usernameError = $emailError = $websiteError = $commentError = $genderError = "";
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
            # 判断username是否为空
            if (empty($_POST["username"])){
                $usernameError = "Username is required.";
            }else{
                $username = test_input($_POST["username"]);
                // 检验名字是否包含字母空格
                if(!preg_match("/^[a-zA-Z ]*$/",$username)){
                    $usernameError = "Only letters and white space allowed.";
                }
            }
            if (empty($_POST["email"])){
                $emailError = "Email is required.";
            }else{
                $email = test_input($_POST["email"]);
                // 检查邮箱是否有效
                if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$email)){
                    $emailError = "Invalid email format.";
                }
            }
            if (empty($_POST["website"])){
                $websiteError = "";
            }else{
                $website = test_input($_POST["website"]);
                // 检查URL地址语言是否有效（此URL中同样允许URL中的下划线）
                if(!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)){
                    $websiteError = "Invalid URL";
                }
            }
            if (empty($_POST["comment"])){
                $commentError = "";
            }else{
                $comment = test_input($_POST["comment"]);
            }
            if (empty($_POST["gender"])){
                $genderError = "Gender is required.";
            }else{
                $gender = test_input($_POST["gender"]);
            }

        }
        
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
        <p>
            姓名：<input name="username" type="text" value="<?php echo $username;?>"><span class="error">*<?php echo $usernameError?></span>
        </p>
        <p>
            邮箱：<input name="email" type="text" value="<?php echo $email;?>"><span class="error">*<?php echo $emailError?></span>
        </p>
        <p>
            网址：<input name="website" type="text" value="<?php echo $website;?>"><span class="error"><?php echo $websiteError?></span>
        </p>
        <p>
            评论：<textarea name="comment" id="" cols="30" rows="10"><?php echo $comment;?></textarea><span class="error"><?php echo $commentError?></span>
        </p>
        <p>
            <span>性别：</span>
            <span><input type="radio" name="gender" <?php if(isset($gender) && $gender == "female") echo "checked";?> value="female" > FeMale </span>
            <span><input type="radio" name="gender" value="male" <?php if(isset($gender) && $gender=="male") echo "checked";?>> Male </span> 
            <span class="error">*<?php echo $genderError?></span>
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