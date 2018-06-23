
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Buy/Sell Books</title>
<style>
table {
    font-family: arial, sans-serif;
    width: 50%;
    border-radius: 5px;
    border-color: #f49b42;
    background-color:#f49b42;
	margin-left:390px;
 
}

td, th {
    border: 1px solid #f49b42;
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
<jsp:include page="sbSearch.jsp"/>
<table >
		<tr>
			<th>bookName</th>
			<th>edition</th>
			<th>author</th>
			<th>price</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.bookName }</td>
				<td>${student.edition }</td>
				<td>${student.author }</td>
				<td>${student.price }</td>
				<td><a href ="deleteServlet?rollNumber=${student.rollNumber}&amp;bookName=${student.bookName}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>