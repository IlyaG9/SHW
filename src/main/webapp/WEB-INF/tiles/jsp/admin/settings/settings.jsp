<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content-area registration-area">
	<sf:form class="form-horizontal"
		action="${pageContext.servletContext.contextPath}/admin/changeSettings"
		method="POST" modelAttribute="settings">

		<c:forEach var="setting" items="${settings}">
			<c:out value="${setting.identifier}" />; 			
				<div class="form-group">
				<label for="text" class="col-sm-2 control-label">Идентификатор</label>
				<div class="col-sm-4">
					<sf:input type="W" class="form-control" path="identifier"
						id="identifier" placeholder="Идентификатор" />
				</div>
			</div>
		</c:forEach>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-success">Сохранить
					изменения</button>
			</div>
		</div>
	</sf:form>
</div>