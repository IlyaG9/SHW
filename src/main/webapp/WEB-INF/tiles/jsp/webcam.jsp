<%-- 
    Document   : webcam
    Created on : 08.01.2015, 11:41:27
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div id="webcam">
    Веб камера<br>
    <c:if test="${local}">
        <img src="http://192.168.0.99:8081?action=stream"/>
    </c:if>
        <img src="http://shweb.dlinkddns.com:8081?action=stream"/>
</div>
