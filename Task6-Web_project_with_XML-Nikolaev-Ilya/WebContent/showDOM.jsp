<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<a class="task" href="index.jsp">Прочитать xml-файл при помощи:  </a>
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
		<div class="inner-page-title">
			<h1>DOM PARSER</h1>
		</div>
		<div class="news">
			<table border="1" >
				<tr bgcolor="#1E90FF">
					<th>Name</th>
					<th>ID</th>
					<th>Origin</th>
					<th>Price</th>
					<th>Currency type</th>
					<th>Is Peripherals</th>
					<th>Energy Consumption</th>
					<th>Has Cooler</th>
					<th>Devices Group</th>
					<th>Port Type</th>
					<th>Port ID</th>
					<th>Critical to Work</th>
				</tr>
				<c:forEach  var = "domItem" items="${sessionScope.dom}">
					<tr>
						<td style="text-align:center">${domItem.name}</td>
						<td style="text-align:center">${domItem.id}</td>
						<td style="text-align:center">${domItem.origin.value}</td>
						<td style="text-align:center">${domItem.price.value}</td>					
						<td style="text-align:center">${domItem.price.currency}</td>					
						<td style="text-align:center">${domItem.type.isPeripheral}</td>					
						<td style="text-align:center">${domItem.type.energyConsumption}</td>					
						<td style="text-align:center">${domItem.type.hasCooler}</td>					
						<td style="text-align:center">${domItem.type.devicesGroup}</td>					
						<td style="text-align:center">${domItem.type.port.value}</td>
						<td style="text-align:center">${domItem.type.port.id}</td>
						<td style="text-align:center">${domItem.isCritical}</td>
					</tr>
						
				
				</c:forEach>
				
			</table>
		</div>
		</main>
		
		<footer class="main-footer clearfix">
			<div class="container">
				<nav class="main-navigation">
					<ul>		
						<li>
							<a class="task" href="index.jsp">Прочитать xml-файл при помощи:  </a>
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