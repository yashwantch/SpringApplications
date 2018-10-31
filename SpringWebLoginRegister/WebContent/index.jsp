<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="register" method="post">
						<label for="name">Name</label> <input type="text"
							 name="f1">
						<label for="email">Email</label> <input type="text"
							 name="f2">
						<label for="pwd">Password</label> <input type="password"
							 name="f3">
						<button class="button button1">Register
						</button>

		</form>
		
		<br/>
		<br/>
		
		<form action="login" method="post">
						<label for="email">email</label> <input type="text"
							 name="f2">
						<label for="pwd">password</label> <input type="password"
							 name="f3">
						<button class="button button1">Login
						</button>

		</form>

</body>
</html>