<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
    font-family: arial, sans-serif;
    width: 50%;
    margin-left:296px;
    border-radius: 5px;
    border-color: #1f2123;
    background-color:#1f2123 ;

 }


td, th {
    border: 1px solid #1f2123;
    text-align: center;
    padding: 8px;
    border-radius: 5px;
}

tr {
    background-color: white;
}
</style>
</head>
<body>
<jsp:include page="libSearch.html"/>
<table border=1>
		<tr>
			<th>bookName</th>
			<th>author</th>
			<th>available</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.bookName }</td>
				<td>${book.author}</td>
				<td>${book.available}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>