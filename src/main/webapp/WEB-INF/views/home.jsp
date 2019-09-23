<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring_Restful_MVC</title>
<style>
body{
	background-color : Tan;
	width : 70%;
}
label{
font-color: black;
}

</style>

</head>
<body>

	<p align="center"><h1>SpringMVC-SpringData Application<h1/></p>

	<form action="addBook" method="post">
		<input type="submit" id="addBook" value="Add a Book" style="width: 250px">
	</form> 
	
	<form action="deleteSubject" method="post">
		<input type="submit" id="deleteSubject" value="Delete a Subject" style="width: 250px">
	</form>  
	
	<form action="deleteBook" method="post">
		<input type="submit" id="deleteBook" value="Delete a Book" style="width: 250px">
	</form> 
	
	<form action="searchSubject" method="post">
		<input type="submit" id="searchSubject" value="Search for a Subject" style="width: 250px">
	</form> 
	
	<form action="getBookInfoId" method="post">
		<input type="submit" id="getBookInfo" value="Search for a Book" style="width: 250px">
	</form> 
	
	<form action="getBookByTitle" method="post">
		<input type="submit" id="getBookByTitle" value="Search for a Book By Title" style="width: 250px">
	</form>
	
	<form action="getSubjectByDuration" method="post">
		<input type="submit" id="getSubjectByDuration" value="Search for a Subject By Duration" style="width: 250px">
	</form>    

	<form action="exit" method="post">
		<input type="submit" id="exit" value="Exit" style="width: 250px">
	</form> 
	
</body>
</html>