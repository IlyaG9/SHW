<%-- 
    Document   : menu
    Created on : 04.01.2015, 14:47:43
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div id="menu">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">              
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.servletContext.contextPath}/">Домой</a></li>               
                    <li><a id="href-webcam" href="${pageContext.servletContext.contextPath}/webcam">Веб камера</a></li>
                        <security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                        <li><a href="${pageContext.servletContext.contextPath}/temperature">Температура</a></li>
                        </security:authorize>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li><a href="${pageContext.servletContext.contextPath}/admin/users">Пользователи</a></li>
                        </security:authorize>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li><a href="${pageContext.servletContext.contextPath}/admin/settings">Настройки</a></li>
                        </security:authorize>
                </ul>
            </div>
            <div class="btn-group navbar-right">
                <security:authorize access="isAuthenticated()">
                    <button id="logout" type="button" class="btn btn-default navbar-btn">Выход</button>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <button id="signin" type="button" class="btn btn-default navbar-btn">Вход</button>
                    <button id="registartion" type="button" class="btn btn-default navbar-btn">Регистрация</button>    
                </security:authorize>
            </div>
        </div>
    </nav>
</div>