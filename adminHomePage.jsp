<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="https://images.freecreatives.com/wp-content/uploads/2015/03/old-book-paper-high-quality-hd-wallpaper-desktop-Old-Book-Paper-High-Quality-HD-Wallpaper-Desktop.jpg">
    <h2>upload a book?</h2>
	 <style>
*{margin:0px; padding:0px; }
* {
	outline: none;
}

h2 {
	text-indent: 50px;
	 margin-top: 50px;
}
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
.contnt {
	border-radius: 5px;
    background-color: #fefefe;
    margin: 12px 20px;
    border: 1px solid #f49b42;
    width: 20%;
    padding-top: 17px; 
    padding-bottom: 17px;
}
button[type=delbtn]{
    background-color: #4d4d4d;
    color: white;
    padding: 10px 14px;
    margin: 8px 26px 11px 11px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 90%;
  font-size:20px;
}
button[type=lgtbtn]{
    background-color: #4d4d4d;
    color: white;
    padding: 10px 14px;
    border: none;
    margin-right:50px;
    border-radius: 5px;
    cursor: pointer;
    width: 55%;
    font-size:20px;
}
button {
    background-color:  hsl(20,75%,50%);
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

</style>
<form style = "float:right;" action = "Wise.html">
<button type="lgtbtn">Logout</button>
</form>
<div style = "float:left;width :1400px" >
     <form class="contnt" action = "RegisterLibraryBook" method = "post">
      <input type="text" placeholder="BookId" name="bookId" required="yes"><br>
      <input type="text" placeholder="Title of the book" name="bookName" required="yes"><br>
      <input type="text" placeholder="Author(s)" name="author" required="yes"><br>   
      <button type="submit">Upload Info</button>
      </form>
      <form class="contnt" action= "DeleteLibraryBook" method = "post">
       <input type="text" placeholder="BookId" name="bookId" required="yes"><br>
       <button type="delbtn">Issue A Book</button></form>
      </div>
      <script language="JavaScript">
      javascript:window.history.forward(0);
      </script> 
</body>
</html>