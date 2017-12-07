<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updateMediciens" modelAttribute="medBean" method="POST">
MedicineId:<form:input path="medicineId"/><br>
MedicineName:<form:input path="medicineName"/><br>
ManifactureDate:<form:input path="manifactureDate"/><br>
ExpiredDate:<form:input path="expiredDate"/><br>
CategoryName:<form:input path="categoryName"/><br>
Price:<form:input path="price"/><br>
Description:<form:input path="description"/><br>
StockStatus:<form:input path="stockStatus"/><br>
ManifacturedCompany:<form:input path="manifacturedCompany"/><br>
<input type="submit" value="update">
<input type="submit" value="cancel">
</form:form>

</body>
</html>