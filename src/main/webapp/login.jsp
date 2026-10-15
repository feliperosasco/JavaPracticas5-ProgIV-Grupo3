<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style.css">
<title>Login</title>
</head>
<body>

	<div class= "login">
		<h1> Iniciar sesión </h1>
		<form action="ServletLogin" method="post">
		
		Usuario
		<input class="txtBox" type="text" name="txtUsuario" required>
		
		Constraseña
		<input class="txtBox" type="password" name="txtContra" required>
		
		<input class="btn" type="submit" name="btnSubmit" value="Ingresar">
		
	</form>
	
	<p style="color: red;">${error} </p>	
	
	</div>

</body>
</html>