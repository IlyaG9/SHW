<%-- 
    Document   : menu
    Created on : 04.01.2015, 14:47:43
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="menu">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">              
                <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/">SHome</a>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.servletContext.contextPath}/">Домой</a></li>               
                    <li><a href="${pageContext.servletContext.contextPath}/webcam">Веб камера</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/temperature">Температура</a></li>
                </ul>
            </div>
            <div class="btn-group navbar-right">
                <button id="signin" type="button" class="btn btn-default navbar-btn">Вход</button>
                <button id="registartion" type="button" class="btn btn-default navbar-btn">Регистрация</button>               
            </div>
        </div>
    </nav>
</div>