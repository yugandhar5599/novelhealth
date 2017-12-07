<%@page import="com.siri.esmartHealthCare.beans.MedicinesBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <form action="${pageContext.request.contextPath}/search/searchpatient?searchValue">
<input type="text" name="searchValue"></input><span id="sid"></span><input type="submit" value="search"/>
</form>
 --%>
 <table border="2">
<tr>
<th style="color: blue">MedicineId</th>
<th style="color: blue">MedicineName</th>
<th style="color: blue">ManifactureDate</th>
<th style="color: blue">ExpireDate</th>
<th style="color: blue">CategoryName</th>
<th style="color: blue">Description</th>
<th style="color: blue">ManifacturedCompany</th>
<th style="color: blue">Price</th>
<th style="color: blue">StockStatus</th>
<th style="color: blue">Action</th>
</tr >


 <core:choose>
<core:when test="${not empty MedicinesList}">
<core:forEach items="${MedicinesList}" var="medibean">

<tr>
<td>${medibean.getMedicineId()}</td>
<td>${medibean.getMedicineName()}</td>
<td>${medibean.getManifactureDate()}</td>
<td>${medibean.getExpiredDate()}</td>
<td>${medibean.getCategoryName()}</td>
<td>${medibean.getDescription()}</td>
<td>${medibean.getManifacturedCompany()}</td>
<td>${medibean.getPrice()}</td>
<td>${medibean.getStockStatus()}</td>
<td>
<a href="${pageContext.request.contextPath}/getAllMediciensById?medicineId=${medibean.getMedicineId()}">edit/</a>
<a href="deleteMedicineById?medicineId=${medibean.getMedicineId()}">delete</a>
</td>
</tr>
</core:forEach>
</core:when>
</core:choose>
<%-- <core:set value="mbean" var="medbean"></core:set>
<tr>
<td>${medbean.getMedicineId()}</td>
<td>${medbean.getMedicineName()}</td>
<td>${medbean.getManifactureDate()}</td>
<td>${medbean.getExpiredDate()}</td>
<td>${medbean.getCategoryName()}</td>
<td>${medbean.getDescription()}</td>
<td>${medbean.getManifacturedCompany()}</td>
<td>${medbean.getPrice()}</td>
<td>${medbean.getStockStatus()}</td>
<td>
<a href="${pageContext.request.contextPath}/getAllMediciensById?medicineId=${medbean.getMedicineId()}">edit/</a>
<a href="deleteMedicineById?medicineId=${medbean.getMedicineId()}">delete</a>
</td>
</tr> --%>
</table>
<a href="addMedicines">addMedicines</a>
<form action="${pageContext.request.contextPath}/searchMedicines?searchValue&searchCriteria">
<select name="searchCriteria" >
<option value="name"  label="searchByName">searchByName</option>
<option value="date" label="searchByDate">searchByDate</option>
</select>
choose date:<input type="datetime"/>
<input type="text" name="searchValue"></input>
<input type="submit" value="search"/>
</form>
</body>
</html>