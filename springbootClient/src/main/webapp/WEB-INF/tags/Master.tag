<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" rtexprvalue="true" required="true"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>

<link href="/styles/Mystyles.css" rel="Stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<script>
	function prevent() {
		window.history.forward();
	}
	setTimeout("prevent()", -1);
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<title>${title}</title>
<jsp:invoke fragment="head"></jsp:invoke>
</head>
<body>


	<div class="logo">
		<img src="/images/Logo2.jfif" style="width: 100%; height: 100%;">
	</div>
	<div style="position: absolute; left: 50%; height: 20%; width: 50%;">
		<img src="/images/Team.png" style="width: 100%; height: 100%;">

	</div>


	<div class="menu">

		<ul>
			<li><a href="Extract">Extract</a></li>
			<li><a href="#news">News</a></li>
			<li><a href="#contact">Contact</a></li>
			<li style="float: right"><a class="active" href="#about">About</a></li>
		</ul>


	</div>

	<div class="content">
		<jsp:invoke fragment="content"></jsp:invoke>
	</div>
</body>
</html>

