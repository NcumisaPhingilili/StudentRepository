<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	
	<form action="createStudent" name="myform" onsubmit="myFunction()">
		<label>First Name: <input type="text" name="firstname"></label><br><br><br>
		<label>Last Name: <input type="text" name="lastName"></label><br><br><br>
		<label>DateOfBirth: <input type="text" name="DOB"></label><br><br><br>
		<label>CellPhone: <input type="text" name="cellphoneNumber"></label><br><br><br>
		<label>Email Address: <input type="text" name="email"></label><br><br><br>
		<label>Score: <input type="text" name="score"></label><br><br><br>
		<input type="submit" value = "Submit" /><br><br><br>
	</form>		
</body>
</html>

