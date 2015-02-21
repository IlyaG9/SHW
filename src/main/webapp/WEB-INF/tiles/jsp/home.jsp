<%-- 
    Document   : home
    Created on : 11.01.2015, 20:35:46
    Author     : @author ILYA_GOLOVACHEV.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div>
    <table id="temperatureTable">
        <tr>
            <td>Температура на улице*: </td>
            <td><c:out value="${streetTemperature}"/> </td>
        </tr>
        <tr>
            <td>Влажность  на улице*: </td>
            <td><c:out value="${streetHumidity}"/> %</td>
        </tr>
        <tr>
            <td><a href="${pageContext.servletContext.contextPath}/webcam">Веб камера</a> </td>
        </tr>
    </table>
  
    <span class="label label-default down">* Температура и влажность считываюься с датчика DHT11. 
        Согласно спецификации, датчик может считывать температуру в диапазоне 0-50(±2)℃ и
        влажность 20-90(±5)%RH
    </span>
</div>
