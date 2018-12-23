<?php
    # 基于时间的解析器
    echo "<p>PHP xml</p>";
    // 初始化xml解析器
    $parser = xml_parser_create();
    
    // 使用开启标签的函数
    function start($parser, $element_name, $element_attr){
        switch($element_name){
            case "NOTE":
            echo "---Node---<br>";
            break;
            case "TO":
            echo "To:";
            break;
            case "FROM":
            echo "From";
            break;
            case "HEADING":
            echo "Heading:";
            break;
            case "BODY":
            echo "Message:";
            break;
        }
    }
        
    echo "<p>****************</p>";
    // 使用结束标签做的事情
    function stop($parser, $element_name){
        echo "<br>";
    }
        
    // 对字符做的处理
    function char($parser, $data){
        echo $data;
    }
    echo "<p>read begin...</p>";
    //  定义处理器，当遇到开始和结束标签所要做的动作
    xml_set_element_handler($parser, "start", "stop");
    // 定义处理器，当遇到字符要做的动作
    xml_set_character_data_handler($parser, "char");
    // 打开xml文件
    $fp = fopen("php_text.xml","r");
    // 读取数据
    while($data=fread($fp,4096)){
        echo $data;
        xml_parse($parser, $data, feof($fp)) or 
        die (sprintf("Xml Error: %s at line %d", 
        xml_error_string(xml_get_error_code($parser)),
        xml_get_current_line_number($parser)));
        
    }
    // 释放xml解析器
    xml_parser_free($parser);
    
?>