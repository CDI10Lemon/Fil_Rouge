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
						<th>name</th>
						<th>lastname</th>
					</tr>
					<c:forEach items="${endusers}" var="enduser">
						<tr>
							<td><c:out value="${enduser.name}" /></td>
							<td><c:out value="${enduser.surname}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>