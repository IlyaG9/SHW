
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div>
    <table id="temperatureTable">
        <tr>
            <td>Температура зал: </td>
            <td><c:out value="${hole}"/> </td>
        </tr>
        <tr>
            <td>Температура спальня: </td>
            <td><c:out value="${liveroom}"/> </td>
        </tr>
        <tr>
            <td>Температура на котле: </td>
            <td><c:out value="${boiler}"/> </td>
        </tr>
        <tr>
            <td>Температура на улице: </td>
            <td><c:out value="${streetTemperature}"/> </td>
        </tr>
        <tr>
            <td>Влажность  на улице: </td>
            <td><c:out value="${streetHumidity}"/> %</td>
        </tr>
        <tr>
            <td>Температура на openweathermap.org (Перевальное) </td>
            <td><c:out value="${openweathermap}"/>  </td>
        </tr>
    </table>
</div>
