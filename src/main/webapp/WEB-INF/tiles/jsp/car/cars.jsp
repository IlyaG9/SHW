
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div align="center">

    <c:forEach var="car" items="${cars}">
     
        <a href="<c:out value="${car.link}"/>">
        <c:out value="${car.name}"/></a><br>
    </c:forEach>

</div>
<%-- <div id="pagin" align="center">
    <c:if test='<%= (Integer) request.getAttribute("pages") > 0%>'>
        <%
            int pages = (Integer) request.getAttribute("pages");
            for (int i = 0; i < pages; i++) {
        %>
        <a href="<c:out value="${pageContext.servletContext.contextPath}"/>/department/search?page=<%=i%>&name=<%=request.getAttribute("name")%>"><%=i + 1%></a>
        <%
            }
        %>
    </c:if>
</div> --%>