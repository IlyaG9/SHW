<%-- 
    Document   : home1
    Created on : 08.01.2015, 11:31:55
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div>
    Температура зал:<c:out value="${hole}"/><br>
    Температура спальня:<c:out value="${liveroom}"/><br>
    Температура на котле:<c:out value="${boiler}"/>
</div>
