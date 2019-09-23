<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.javaspringclub.entity.Subject"%>
<%@page import="com.javaspringclub.entity.Book"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">

<title>Add a Book</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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


<body font-color="red">


<div id="container" >
	
	<a class="hiddenanchor" id="toregister"></a>
	<a class="hiddenanchor" id="tologin"></a>
	<div id="wrapper">
		<div id="register" class="animate form">
		<form  action="deleteSubjectById" method="post"> 
				<p><b>Delete a Subject</b></p> 
		
		 
          <div class="form-group">
			  <label for="subject_id" class="title">Subject ID:</label>  
			  <input type="text" id="subject_id" name="subject_id" class="form-control" required="required" placeholder="Enter Subject ID">
          </div>
		   
		   <p style="line-height: 10px; text-align: center;"><button class="btn btn-primary">Delete a Subject</button></p>
				
			</form>
		</div>
		
<div>
<form action="home" method="post">
<p style="line-height: 10px; text-align: center;"><button class="btn btn-primary">Back To Home</button></p>
</form>
</div>
	</div>
	
	<c:if test="${not empty subjectList}">

		<table style="width:100%" border="5" bordercolor="#000000">
			  <tr>
			  	<th>Subject ID</th>
			  	<th>Subject Title</th>
			  	<th>DurationInHours</th>
			    <th>Book ID</th>
			    <th>Book Title</th> 
			    <th>Price</th>
			    <th>Volume</th>
			    <th>Publish Date</th>
			  </tr>
			  
			  
			 <%
			 ArrayList<Subject> subjectList = (ArrayList<Subject>) request.getAttribute("subjectList");
			 	for(Subject subjectDto : subjectList) {
					Book bookDto= subjectDto.getBook();
					
			%> 
			  
			<tr>
				<td><%out.print(subjectDto.getSubject_id());%></td>
				<td><%out.print(subjectDto.getSubject_title());%></td>
				<td><%out.print(subjectDto.getDuration_inhours());%></td>
				
				
		       <td><%out.print(bookDto.getBook_id());%></td> 
			   <td><%out.print(bookDto.getBook_title());%></td>
			    <td><%out.print(bookDto.getPrice());%></td>
			    <td><%out.print(bookDto.getVolume());%></td>
			    <td><%out.print(bookDto.getPublish_date());%></td>
			 
			  
			</tr>
			   <%
			 	   }
			   %>
			  
			
			  </tr>
			  
		
			
		</table>
	
	</c:if>
	
	<c:if test="${empty subjectList && isVisible}">

		<h2>SubjectInfo does not exist for subjectId: ${subject_id}</h2>
	
	</c:if>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>