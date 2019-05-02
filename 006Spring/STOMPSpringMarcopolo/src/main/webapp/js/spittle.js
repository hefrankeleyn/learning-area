window.onload = function(){
    var url = "http://" + window.location.host + "/STOMPSpringMarcopolo/marcopolo";

    var sock = new SockJS(url);
  var stomp = Stomp.over(sock);
  stomp.connect("guest", "guest", function(){
      console.log("Connected.");
      stomp.subscribe("/topic/spittlefeed", handleSpittle);
      // stomp.subscribe("/topic/marco", handleMarco);
      console.log("hello world");
      // sendMes();
  });

  function handleMarco(incoming) {
      console.log("receive...");
      console.log(incoming);
  }

  function handleSpittle(incoming) {
      console.log("receview:" + incoming);
      var spittle = JSON.parse(incoming.body);
      console.log(spittle);
      addSpittleHtml(spittle);
  }

  function addSpittleHtml(obj) {
      $("#spittle_list").append("<li><span>" +obj["id"]+
          "</span><br><span>" +obj["message"] +
          "</span><br>(<span>" +obj["latitude"] +
          "</span>,<span>" +obj["longitude"] +
          "</span>)</li>");
  }

  function sendMes(){
      console.log("send message...");
      stomp.send("/app/marco", {}, JSON.stringify({"message": "Marco!"}));
  }
};