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
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/">SHome</a>
            </div>
            <div class="btn-group navbar-right">
                <button id="signin" type="button" class="btn btn-default navbar-btn">Вход</button>
                <button id="registartion" type="button" class="btn btn-default navbar-btn">Регистрация</button>               
            </div>
        </div>
    </nav>
</div>