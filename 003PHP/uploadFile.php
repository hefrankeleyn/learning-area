<?php
    # 打印上传文件的信息
    /*
    if($_FILES["file"]["error"]>0){
        echo "Error:".$_FILES['file']['error']."<br>";
    }else{
        echo "文件名称：".$_FILES["file"]["name"]."<br>";
        echo "文件类型：".$_FILES["file"]["type"]."<br>";
        echo "文件大小：".($_FILES["file"]["size"]/1024)."kb<br>";
        echo "临时目录：".$_FILES["file"]["tmp_name"]."<br>";
    }
    */

    # 对上传文件类型和大小进行过滤
    # 对于IE，识别 jpg文件，文件类型是pjpeg；对于Firefox 必须是jpeg
    echo $_FILES["file"]["type"]."<br>".",".$_FILES["file"]["size"];
    /*
    if(($_FILES["file"]["type"] == "image/gif" || 
        $_FILES["file"]["type"] == "image/jpeg" ||
        $_FILES["file"]["type"] == "image/pjpeg"
        ) && ($_FILES["file"]["size"] < 200000)){
            if($_FILES["file"]["error"]>0){
                echo "Error:".$_FILES['file']['error']."<br>";
            }else{
                echo "文件名称：".$_FILES["file"]["name"]."<br>";
                echo "文件类型：".$_FILES["file"]["type"]."<br>";
                echo "文件大小：".($_FILES["file"]["size"]/1024)."kb<br>";
                echo "临时目录：".$_FILES["file"]["tmp_name"]."<br>";
            }
    }else{
        echo "Invalid file";
    }
    */
    #将上传的文件存到一个地方
    if(($_FILES["file"]["type"] == "text/plain"
        ) && ($_FILES["file"]["size"] < 200000)){
            if($_FILES["file"]["error"]>0){
                echo "Error:".$_FILES['file']['error']."<br>";
            }else{
                echo "文件名称：".$_FILES["file"]["name"]."<br>";
                echo "文件类型：".$_FILES["file"]["type"]."<br>";
                echo "文件大小：".($_FILES["file"]["size"]/1024)."kb<br>";
                echo "临时目录：".$_FILES["file"]["tmp_name"]."<br>";
                if(file_exists("upload_files".$_FILES["file"]["name"])){
                    echo $_FILES["file"]["name"]." file already exists.";
                }else{
                    move_uploaded_file($_FILES["file"]["tmp_name"],
                                        "upload_files/".$_FILES["file"]["name"]
                                        );
                    echo "file store in: ".$_FILES["file"]["name"];
                }
            }
    }else{
        echo "Invalid file";
    }
?>