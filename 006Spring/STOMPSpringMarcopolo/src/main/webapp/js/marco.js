window.onload = function(){
    var marco = document.getElementById("marco");
    marco.addEventListener("click", function(){
        var url = "http://" + window.location.host + "/STOMPSpringMarcopolo/marcopolo";

        // 创建SockJS连接
        var sock = new SockJS(url);

        // 创建STOMP客户端
        var stomp  = Stomp.over(sock);

        var payload = JSON.stringify({"message": "Marco!"});
        // 连接STOMP端点
        // 使用内存消息代理的时候，前两个值可以随便写
        stomp.connect("guest", "guest", function(){
            // 发送消息
            stomp.send("/app/marco", {}, payload);
        });
    });
};
