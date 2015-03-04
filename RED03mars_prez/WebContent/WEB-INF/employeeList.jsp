<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Présentation</title>


</head>
<body>
	
	
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td><c:out value="${employee.name}" /></td>
						
						</tr>
					</c:forEach>
				
</body>
</html>