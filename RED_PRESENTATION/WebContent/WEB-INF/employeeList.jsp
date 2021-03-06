<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CYBER BASE</title>
<link href="Semantic-UI-1.7.3/dist/semantic.min.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<header>
		<div class="ui fixed main inverted menu">
			<div class="container"><div class="item">CYBER BASE</div></div>
		</div>
	</header>
		<section style="">
			<div style="display: flex; width: 100%; padding-top: 35px;">
			<div style="flex-basis: 150px;"></div>
			<div style="flex: 1;">
				<table class="ui table celled striped ">
					<tr>
						<th>employee - name</th>
						<th>employee - lastname</th>
						<th>employee - password</th>
						<th>employee -category - name</th>
						<th>employee - category - sedentary</th>					
						<th>employee - structure - name</th>
						<th>employee - site - name</th>
						<th>employee - site - max_unit</th>
						<th>employee - site_1 - name</th>
						<th>employee - site_1 - max_unit</th>
					</tr>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.lastname}" /></td>
							<td><c:out value="${employee.password}" /></td>
							<td><c:out value="${employee.category.name}" /></td>
							<td><c:out value="${employee.category.sedentary}" /></td>
							<td><c:out value="${employee.structure.name}" /></td>
							<td><c:out value="${employee.site.name}" /></td>
							<td><c:out value="${employee.site.maxUnit}" /></td>
							<td><c:out value="${employee.site1.name}" /></td>
							<td><c:out value="${employee.site1.maxUnit}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>