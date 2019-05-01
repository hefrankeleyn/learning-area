window.onload = function () {
    var marco = document.getElementById("marco");
    marco.addEventListener("click", function(){
        console.log("hello world");
        // var url = "ws://localhost:8080/SpringWebSocketMoarcoPolo/marco"
        // var sock = new WebSocket(url);
        //SocketJs方案二：使用url
        // var url = "http://localhost:8080/SpringWebSocketMoarcoPolo/marco"

        //SocketJS方案一： 使用url
        var url = "marco";
        var sock  = new SockJS(url);
        sock.onopen = function(){
            console.log("Openging");
            sayMarco(sock);
        }

        sock.onmessage = function(e){
            console.log("Received message; ", e.data);
            setTimeout(function(){sayMarco(sock)}, 2000);
        }

        sock.onclose = function(){
            console.log("Closing");
        }
    });
    function sayMarco(sock){
        console.log("Sending Marco!");
        sock.send("Marco!");
    }
}