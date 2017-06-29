<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<header class="main-header">
		<div class="container clearfix">
			<nav class="main-navigation">
				<ul>		
							<li>
								<span class="task">Прочитать xml-файл при помощи:  </span>
							</li>				
							<li>
								<a href="MainServlet?command=showSAX">SAX</a>
							</li>
							<li>
								<a href="MainServlet?command=showStAX">StAX</a>
							</li>
							<li>
								<a href="MainServlet?command=showDOM">DOM</a>
							</li>
						</ul>	
			</nav>
		</div>
	</header>
	<main class="container clearfix">
		<div class="inner-page-title clearfix">
			<h1>Web-Project with XML</h1>
		</div>
		<div class="inner-content">
			<div class="big-heading">
				<h2>ИПрочитать xml-файл при помощи SAX, StAX и DOM парсеров.</h2>
			</div>
			<div class="inner-columns clearfix">
				<h2>Когда что-то пошло не так</h2>
			</div>	
		</div>
	</main>
		
		<footer class="main-footer">
			<div class="container clearfix">
				<nav class="main-navigation">
					<ul>		
							<li>
								<span class="task">Прочитать xml-файл при помощи:  </span>
							</li>				
							<li>
								<a href="MainServlet?command=showSAX">SAX</a>
							</li>
							<li>
								<a href="MainServlet?command=showStAX">StAX</a>
							</li>
							<li>
								<a href="MainServlet?command=showDOM">DOM</a>
							</li>
					</ul>	
				</nav>
			</div>
		</footer>

</body>
</html>