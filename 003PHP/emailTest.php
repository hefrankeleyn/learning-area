
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
$to = "lifei6@asiainfo.com";
$subject = "Test mail";
$message = "Hi, this is a simple email.";
$from = "shuju@wo.cn";
$headers = "From: $from";
mail($to,$subject,$message,$headers);
echo "Mail Sent.";
*/
# 如果input email 填写了，发送email
if (isset($_REQUEST["email"])){
    // 发送email
    ini_set("SMTP","smtp.163.com");

    //
    //ini_set("smtp_server","smtp.wo.cn");
    ini_set("smtp_port","25");
    ini_set("auth_username","hefrankeleyn@163.com");
    ini_set("auth_password","LiFei1212");
    # $email = $_REQUEST["email"];
    $email = "shuju@wo.cn";
    $subject = $_REQUEST["subject"];
    $message = $_REQUEST["message"];
    mail("lifei6@asiainfo.com",$subject,$message,"From: $email");
    echo "Thank you for using our mail form";
}else{
    # input email没有填写，展示表单
    echo "<form method='POST' action='emailTest.php'>
    Email: <input name='email' type='text'><br>
    Subject: <input name='subject' type='text'><br>
    message: <textarea name='message' rows='15' cols='40'></textarea><br>
    <button type='submit'>submit</button>
    </form>";
}
?>
</body>
</html>