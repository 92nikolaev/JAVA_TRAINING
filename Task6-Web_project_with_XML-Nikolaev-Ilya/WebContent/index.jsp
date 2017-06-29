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
	<main class="container">
		<div class="inner-page-title">
			<h1>Web-Project with XML</h1>
		</div>
		<div class="inner-content">
			<div class="big-heading">
				<h2>ИПрочитать xml-файл при помощи SAX, StAX и DOM парсеров.</h2>
			</div>
			<div class="inner-columns clearfix">
				<h2>Несколько слов о нас:</h2>
				<div class="inner-column-left">
					<p>	
						Написать веб-приложение, читающее из xml-файла данные и выводящее их пользователю в виде таблицы. Учесть требования к содержимому xml-файла.
					</p>
				</div>
				<div class="inner-column-right">
					<p>
						Общие требования к проекту: 
							Необходимо использовать все три типа парсеров: SAX, StAX, DOM.
							Приложение реализовать применяя технологии Servlet и JSP.
							Архитектура приложения должна соответствовать шаблонам Layered architecture и Model-View-Controller.
							Приложение должно корректно обрабатывать возникающие исключительные ситуации, в том числе вести их журналирование. В качестве логгера использовать Log4j.
							Классы и другие сущности приложения должны быть грамотно структурированы по пакетам и иметь отражающую их функциональность название.
							При реализации бизнес-логики приложения следует при необходимости использовать шаблоны проектирования (например, шаблоны GoF: Factory Method, Command, Builder, Strategy, State, Observer etc), а также необходимо избегать процедурного стиля программирования.
							При реализации страниц JSP следует использовать теги библиотеки JSTL, использовать скриплеты запрещено. Просмотр “длинных списков” желательно организовывать в постраничном режиме.
							Оформление кода должно соответствовать Java Code Convention.
					</p>
				</div>
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