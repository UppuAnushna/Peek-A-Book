<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BSSearch</title>
</head>
<body background = "https://i.pinimg.com/originals/73/53/c8/7353c8bcda6926f5c11382ad97727e50.jpg"
>
	 <style>
*{margin:0px; padding:0px; }
* {
	outline: none;
}

h2 {
	text-indent: 50px;
	 margin-top: 10px;
}
button {
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
 input[type=text] {
    width: 90%;
    padding: 10px 20px;
    margin: 10px 30px 12px 13px;
    display: inline-block;
    border: 1px solid #f49b42;
    border-radius: 5px;
    box-sizing: border-box;
  font-size:16px;
}
 input[type=file] {
    width: 90%;
    padding: 10px 20px;
    margin: 10px 30px 12px 13px;
    display: inline-block;
    border: 1px solid #f49b42;
    border-radius: 5px;
    box-sizing: border-box;
  font-size:16px;
}
.contnt {
	border-radius: 5px;
    background-color: #fefefe;
    margin: 12px 20px;
    border: 1px solid #f49b42;
    width: 20%;
    padding-top: 17px; 
    padding-bottom: 17px;
}

.butn {
    
    color: white;
    border: none;
    margin: 8px 50px 4px 23px;
    border-radius: 5px;
    cursor: pointer;
    width: 20%;
  font-size:20px;
}
.butn1 {
 
    color: white;
    border: none;
    margin-left:20px;
    margin-bottom:-500px;
    border-radius: 5px;
    cursor: pointer;
    width: 20%;
  font-size:20px;
}
.butn2 {
    float:right;
    color: white;
    border: none;
    margin-right:150px;
    border-radius: 5px;
    margin-top:-100px;
    cursor: pointer;
    width: 10%;
    font-size:17px;
}
</style>

<div style = "float:left;width:1400px" >
     <form class="contnt" action = "RegisterServlet" method = "post" enctype="multipart/form-data">
      <input type="text" placeholder="RollNumber" name="rollNumber" required="yes"><br>
      <input type="text" placeholder="Title of the book" name="bookName"  required="yes"><br>
      <input type="text" placeholder="Author(s)" name="author"  required="yes"><br>   
      <input type="text" placeholder="Edition(Enter 0 if not known)" name="edition" required="yes"><br>
      <input type="text" placeholder="Your price for the book" name="price" required="yes"><br>
      	<input type=file placeholder="Upload coverpage image here" name="photo" required="yes"/><br>
      	<button type="submit">Sell My Book</button>
      	</form>
      <form class ="butn" action="DisplayAllBooks">
      	<button>Show Books</button>
      	</form>
      	<form class ="butn1" action="ManageAllBooks">
      	<button>Manage My Books</button>
      	</form>
      	<form class ="butn2" action="Wise.html">
      	<button>Logout</button>
      	</form>
      	 </div>
      	<form action="editServlet">
      	<button style="text-decoration:none;float:right; margin-right:220px; margin-top:-92px; width:10%; height:7%; font-size:17px;">Set Password</button>
      	</form>
      	<script language="JavaScript">
      javascript:window.history.forward(0);
      </script> 
</body>
</html>