<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<title>Log in with your account</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<form method="POST" action="${loginUrl}" class="form-signin">
			<h2 class="form-heading">Log in</h2>
			<div class="alert alert-danger error-class">${error}</div>
			<div class="alert alert-success logout-class">${logout}</div>
			<div class="form-group">
				<input name="username" type="text" class="form-control" placeholder="Username" />
				<input name="password" type="password" class="form-control" placeholder="Password" />
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
			</div>
		</form>
	</div>
	<!-- /container -->
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
