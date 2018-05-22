<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Page</title>
<!-- Change Style to come from .css file -->
<style>
	table, th,td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<!-- User add/edit logic -->
	
	<!-- User list logic -->
	<c:if test="${not empty requestScope.getUsers}">
		<table>
			<tbody>
				<tr>
					<th>UUID</th>
					<th>Uname</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>email</th>
					<th>valid</th>

				</tr>
				<c:forEach items="${requestScope.getUsers}" var="user">
					<c:url value="/editUser" var="editURL">
						<c:param name="id" value="${user.UUID}"></c:param>
					</c:url>
					<c:url value="/deleteUser" var="deleteURL">
						<c:param name="id" value="${user.UUID}"></c:param>
					</c:url>
					<c:url value="/endUser" var="endUserURL">
						<c:param name="id" value="${user.UUID}"></c:param>
					</c:url>
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.uname}"></c:out></td>
						<td><c:out value="${user.firstname}"></c:out></td>
						<td><c:out value="${user.lastname}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<%-- <td><a href='<c:out value="${editURL}" escapeXML="true"></c:out>'>Edit</a></td>
						<td><a href='<c:out value="${deleteURL}" escapeXML="true"></c:out>'>Delete</a></td>
						<td><a href='<c:out value="${endUserURL}" escapeXML="true"></c:out>'>End	</a></td>
						 --%>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>