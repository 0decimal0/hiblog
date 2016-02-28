function checkpassmatch(){
  var password=$("#newpwd").val();
  var confirmpassword=$("#confirmpwd").val();

  if (password!= confirmpassword)
    $("#divcheckpassmatch").html("passwords do not match!");
  else
    $("#divcheckpassmatch").html("password confirmed");
}
$(document).ready(function(){
  $("#confirmpwd").keyup(checkpassmatch);
});
