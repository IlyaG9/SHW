<%-- 
    Document   : base
    Created on : 04.01.2015, 14:10:51
    Author     : @author ILYA_GOLOVACHEV
--%>

<%@ page contentType="text/html; charset=utf-8"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
    </body>
</html>
