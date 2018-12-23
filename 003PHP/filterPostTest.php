<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>" method="POST">
        URL: <input type="text" name="url">
        <p>
        <button type="submit">submit</button>
        </p>
    </form>

    <?php
    if($_SERVER["REQUEST_METHOD"] === "POST"){

        if(!filter_has_var(INPUT_POST, "url")){
            echo "url not exists";
        }else{
            $url = filter_input(INPUT_POST, "url", FILTER_SANITIZE_URL);
            echo $url;
        }
    }
    ?>
</body>
</html>