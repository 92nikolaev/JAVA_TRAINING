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
	
		<main class="container">
		<div class="inner-page-title">
			<h1>SAX PARSER</h1>
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
				<c:forEach  var = "saxItem" items="${sessionScope.sax}">
					<tr>
						<td style="text-align:center">${saxItem.name}</td>
						<td style="text-align:center">${saxItem.id}</td>
						<td style="text-align:center">${saxItem.origin.value}</td>
						<td style="text-align:center">${saxItem.price.value}</td>					
						<td style="text-align:center">${saxItem.price.currency}</td>					
						<td style="text-align:center">${saxItem.type.isPeripheral}</td>					
						<td style="text-align:center">${saxItem.type.energyConsumption}</td>					
						<td style="text-align:center">${saxItem.type.hasCooler}</td>					
						<td style="text-align:center">${saxItem.type.devicesGroup}</td>					
						<td style="text-align:center">${saxItem.type.port.value}</td>
						<td style="text-align:center">${saxItem.type.port.id}</td>
						<td style="text-align:center">${saxItem.isCritical}</td>
					</tr>
						
				
				</c:forEach>
				
			</table>
		</div>
		</main>
		
		<footer class="main-footer">
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
		</footer>

</body>
</html>