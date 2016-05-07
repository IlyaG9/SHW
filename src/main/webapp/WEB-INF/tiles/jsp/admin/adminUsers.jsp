<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div align="center">
	<table border="1">
		<thead>
			<tr>
				<th>Активный</th>
				<th>ид</th>
				<th>Имя</th>
				<th>Фамилия</th>
				<th>Дата рождения</th>
				<th>E-mail</th>
				<th>Логин</th>
				<th>Пароль</th>
			<!-- 	<th>Группы</th> -->
				<th>Редактировать</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.isActive()}" /></td>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.secondName}" /></td>
				<td><c:out value="${user.birthdate}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.login}" /></td>
				<td><c:out value="${user.password}" /></td>
		<%-- 		<td><c:forEach var="group" items="${user.userGroups}">
						<c:out value="${group.groupIdentifier}" />; 
					</c:forEach></td> --%>
			 <td><a href="<c:out value="${pageContext.servletContext.contextPath}"/>/admin/userEdit/${user.id}">Изменить</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
