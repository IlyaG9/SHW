<%-- 
    Document   : registration
    Created on : 08.01.2015, 12:04:59
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="content-area registration-area">
	<sf:form class="form-horizontal" action="${pageContext.servletContext.contextPath}/user/createNewUser" method="POST" modelAttribute="user">
		<div class="form-group">
			<label for="text" class="col-sm-2 control-label">Имя</label>
			<div class="col-sm-4">
			<sf:input type="text" class="form-control" path="firstName" id="firstName" placeholder="Имя"/>
			</div>
		</div>
		<div class="form-group">
			<label for="text" class="col-sm-2 control-label">Логин</label>
			<div class="col-sm-4">
				<sf:input  type="text" class="form-control" id="login" path="login"
					placeholder="Логин"/>
			</div>
		</div>
		<div class="form-group">
			<label for="mail" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-4">
				<sf:input type="email" class="form-control" id="mail" path="email"
					placeholder="Email"/>
			</div>
		</div>
		<div class="form-group">
			<label for="pass" class="col-sm-2 control-label">Пароль</label>
			<div class="col-sm-4">
				<sf:input  type="password" class="form-control" id="password" path="password"
					placeholder="Пароль"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-success">Зарегистрировать</button>
			</div>
		</div>
	</sf:form>
</div>