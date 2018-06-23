
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<style>
input[type=text],input[type=password] {
    width: 90%;
    padding: 10px 20px;
    margin: 10px 30px 12px 13px;
    display: inline-block;
    border: 1px solid #f49b42;
    border-radius: 5px;
    box-sizing: border-box;
  font-size:16px;
}
button[type=submit] {
    background-color: hsl(20,75%,50%);
    color: white;
    padding: 10px 14px;
    margin: 8px 26px 11px 11px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 90%;
   font-size:20px;
}
button:hover {
    opacity: 0.8;
}
button:active {
outline: none;
border: none;
}
button:focus {outline:0;}

.modal {
  display:none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 70%;
    overflow: auto;
    background-color: rgba(10,10,0,0.4);
}

/* Modal Content Box */
.modal-content {
    background-color: #fefefe;
    margin: 4% auto 15% auto;
    border: 1px solid #f49b42;
    border-radius: 5px;
    width: 40%; 
    padding-left: 30px;
    padding-bottom:20px;
    padding-top:100px;
}
/* Add Zoom Animation */
.animate {    animation: zoom 0.6s
}
@keyframes zoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}
a {
 color: hsl(20,75%,50%);
 margin-left:435px;
}
</style>
</head>
<body>
<jsp:include page="sbSearch.jsp"/>

 <form class="modal-content animate" action = "UpdateServlet" method = "POST">
        
    <div class="imgcontainer">
    <h1 style="text-align:center">Reset your Password</h1>
    </div>

    <div class="container">
      <input type="text" placeholder="Example:16wh1a502" name="rollNumber"  value=${std.rollNumber} readOnly=true><br>
      <input type="password" placeholder="New Password" name="password"  required="yes"><br>        
      <button type="submit">Save Changes</button><br>
      <a href="sbSearch.jsp">Go back</a>
    </div>
    </form>
    </div>

    <script>
// If user clicks anywhere outside of the modal, Modal will close
var modal = document.getElementById('modal-wrapper');
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

</script>
</body>
</html>