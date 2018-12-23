function addToUserList(list, user){
    var i;
    for(i=0;i<list.length;i++){
        if(list[i].id === user.id){
            return;
        }
    }
    list.push(user);
}

function removeFromUserList(list,user){
    var i, target =-1;
    for(i=0;i<list.length;i++){
        if(list[i].id === user.id){
            target = i;
            break;
        }
    }

    if(target >= 0){
        list.splice(target,1);
    }
}


(function(){
    var vmMessageList = new Vue({
        el:'#message-list',
        data:{
            messages:[]
        }
    });
    
    var vmUserList = new Vue({
        el:"#user-list",
        data:{
            users:[]
        }
    });

    var ws = new WebSocket('ws://localhost:3000/ws/chat');

    ws.onmessage = function(event){
        var data = event.data;
        console.log(data);
        var msg = JSON.parse(data);
        if(msg.type === 'list'){
            vmUserList.users = msg.data;
        } else if (msg.type === 'join'){
            addToUserList(vmMessageList.users,msg.user);
            addMessage(vmMessageList.messages,msg.user);
        } else if (msg.type === 'left'){
            removeFromUserList(vmUserList.users,msg.user);
            addMessage(vmMessageList.messages,msg);
        } else if (msg.type === 'char'){
            addMessage(vmMessageList.messages,msg);
        }
    }


})();



