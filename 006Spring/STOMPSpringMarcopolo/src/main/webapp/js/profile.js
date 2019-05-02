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

});