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
        $cars = array(
            array("aaa",11,111),
            array("bbb",22,222),
            array("ccc",33,333),
        );

        echo $cars[0][0].",".$cars[0][1].",".$cars[0][2]."<br>";
        echo $cars[1][0].",".$cars[1][1].",".$cars[1][2]."<br>";
        echo $cars[2][0].",".$cars[2][1].",".$cars[2][2]."<br>";

        for($row=0; $row<3; $row++){
            echo "<p><b>Row number $row</b></p>";
            echo "<ul>";
            for($col=0;$col<3;$col++){
                echo "<li>".$cars[$row][$col]."</li>";
            }
            echo "</ul>";
        }
    ?>
</body>
</html>