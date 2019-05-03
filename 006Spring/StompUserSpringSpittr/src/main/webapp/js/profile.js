$(document).ready(function () {
  var input = $("#spitter input[name='id']");
  var id = input.attr("value");
  var spitter = $("#spitter");
  var spittle = $("#spittle");
  spitter.show();
  spittle.hide();
  console.info(id);

  $("#add").click(function () {
    //input.hide();
    console.log("hello world");
    $("#spittle input[name='spitter']").attr("value", id);
    spitter.hide();
    spittle.show();
  });


  $("#save").click(function () {
    var url = "http://" + window.location.host + "/StompUserSpringSpittr/spittr";
    var sock = new SockJS(url);

    var stomp = Stomp.over(sock);

    stomp.connect("guest", "guest", function () {
      // 注意，这个目的地使用了User作为前缀
      /**
       * 将会通过UserDestinationMessageHandler进行处理， UserDestinationMessaeHandler的主要任务是将用户消息重新路由到某个用户独有的目的地上
       */
      stomp.subscribe("/user/queue/notifications", saveOk());
      stomp.send("/app/spittle", {}, generateSpittr());
    });
  });

  function saveOk(incomming) {
    console.log(incomming);
    console.log("Save ok!")
  }
  function generateSpittr() {
    var message = $("#spittle input[name='message']").attr("value");
    var latitude = $("#spittle input[name='latitude']").attr("latitude");
    var longitude = $("#spittle input[name='longitude']").attr("longitude");
    return JSON.stringify({"message":message, "latitude": latitude, "longitude": longitude});
  }

});