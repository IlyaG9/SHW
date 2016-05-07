
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>
    <script type="text/javascript">
        $(function() {
            day =<c:out value="${employee.birthdate.date}"/>;
            month =<c:out value="${employee.birthdate.month}"/> + 1;
            year =<c:out value="${employee.birthdate.year}"/> + 1900;
            var date = day + "/" + month + "/" + year;
            $("#employee_birthdate").attr("value", date);
        });
    </script>
    <sf:errors cssClass="error" path="*" delimiter=", "/>
    <sf:form  method="POST" modelAttribute="user" id="user_form" action="${pageContext.servletContext.contextPath}/admin/userExecuteEdit">
        <fieldset>
            <sf:hidden id="id" path="id"/>
            Активный: <sf:checkbox path="active" id="user_active"/>
            <sf:errors path="active" cssClass="error" /><br>
            Имя:  <sf:input path="firstName" id="user_first_name"/>
            <sf:errors path="firstName" cssClass="error" /><br>
            Фамилия:  <sf:input path="secondName" id="user_last_name"/>
            <sf:errors path="secondName" cssClass="error" /><br>
             E-mail:  <sf:input path="email" id="user_email"/>
            <sf:errors path="email" cssClass="error" /><br>
            Дата рождения:  <sf:input path="birthdate" id="user_birthdate"/>
            <sf:errors path="birthdate" cssClass="error" /><br>
            Логин:  <sf:input path="login" id="user_login"/>
            <sf:errors path="login" cssClass="error" /><br>
            Пароль:  <sf:input path="password" id="user_password"/>
            <sf:errors path="password" cssClass="error" /><br>
           
            <input type="submit" value=" Сохранить"/>
        </fieldset>
    </sf:form>

</div>
