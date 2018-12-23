<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"])?>" method="POST">
        <p><label for="name">Name:</label><input type="text" name="name"></p>
        <p><label for="age">Age:</label><input type="text" name="age"></p>
        <p><label for="email">Email:</label><input type="text" name="mail"></p>
        <p><button type="submit">Submit</button></p>
    </form>

    <?php
    $filter = array("name"=>array("filter"=>FILTER_SANITIZE_STRING),
                    "age"=>array("filter"=>FILTER_VALIDATE_INT,
                                 "options"=>array("min_range"=>1,
                                                  "max_range"=>120)
                                ),
                    "mail"=>FILTER_VALIDATE_EMAIL, 
                    );
    if($_SERVER["REQUEST_METHOD"]==="POST"){
        $result = filter_input_array(INPUT_POST,$filter);
        if(!$result["age"]){
            echo "Age mush a number between 1 and 120";
        }elseif(!$result["mail"]){
            echo "<p>mail is not valid.</p>";
        }else{
            echo "User input is valid";
        }
    }
    ?>
</body>
</html>