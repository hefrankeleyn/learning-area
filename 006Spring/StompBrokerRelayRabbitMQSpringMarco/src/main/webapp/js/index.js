window.onload = function(){
  var sendMes = document.getElementById("send_mes");
  sendMes.addEventListener("click", function (ev) {
      console.log("hello world");
      var url = "http://" + window.location.host + "/StompBrokerRelayRabbitMQSpringMarco/marcopopl";

      // 创建SocketJs连接
      var sock = new SockJS(url);

      // 创建 STOMP 客户端
      var stomp = Stomp.over(sock);

      stomp.connect("guest", "guest", function(){
          // stomp.subscribe("/topic/marco", receivePolo);
          stomp.subscribe("/topic/shout", receivePolo);
          // sendServiceMessage();
      });

      function sendServiceMessage() {
          stomp.send("/app/marco", {}, JSON.stringify({"message": "Marco!"}));
      }

      function receivePolo(incoming) {
          console.log("client receive .....")
          console.log(incoming)
          console.log(JSON.parse(incoming.body));
      }
  })
};