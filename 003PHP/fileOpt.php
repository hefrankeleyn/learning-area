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
        # 打开文件
        $myFile = fopen("readyFile.txt","r") or die("file not exists.");
        # 读取文件内容
        // fread() 第一个参数，是打开的文件，第二个参数要读去的文件字节数
        echo filesize("readyFile.txt")."<br>";
        echo fread($myFile,filesize("readyFile.txt"));
        # 关闭文件
        fclose($myFile);

        #打开文件
        $myFile = fopen("readyFile.txt","r+") or die("file not exists");
        // 读取单行文件
        echo "<br>read one line.<br>";
        echo fgets($myFile);
        # 关闭文件
        fclose($myFile);

        echo "<p>循环读取文件</p>";
         #打开文件
        if(!file_exists("readyFile.txt")){
            die("file not exists.");
        }
        $myFile = fopen("readyFile.txt","r+") or die("file not exists");
        // feof() 检查指针是否到达文件最后
        while(!feof($myFile)){
            echo fgets($myFile);
            echo "<br>";
        }
        echo fgets($myFile);
        # 关闭文件
        fclose($myFile);

        echo "<p>读取单个字符，知道文件末尾</p>";
         #打开文件
        $myFile = fopen("readyFile.txt","r+") or die("file not exists");
        // 读取单个字符，直到文件末尾
        while(!feof($myFile)){
            echo fgetc($myFile);
        } 
        fclose($myFile);

        echo "<p>向文件中写入内容</p>";
        $myFile = fopen("writeFile.txt","w") or die("Write to file failed.");
        fwrite($myFile,"Li Fei\r");
        fwrite($myFile,"zy");
        fclose($myFile);

        echo "<p>向位你就爱你中追加内容</p>";
        $myFile = fopen("writeFile.txt","a") or die("write file failed");
        fwrite($myFile,"\rI have a dream.");
        fclose($myFile);
    ?>
</body>
</html>