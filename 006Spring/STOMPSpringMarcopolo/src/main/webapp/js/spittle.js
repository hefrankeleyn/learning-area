window.onload = function(){
  var sock = new SockJS("spittr");
  var stomp = Stomp.over(sock);
  stomp.connect("guest", "guest", function(){
      console.log("Connected.");
      stomp.subscribe("/topic/spittlefeed", handleSpittle);
  });

  function handleSpittle(incoming) {
      var spittle = JSON.parse(incoming.body);
      console.log(spittle);
  }
};