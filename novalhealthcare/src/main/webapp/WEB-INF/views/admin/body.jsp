<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">

		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="./resources/images/dashboard_1.png" alt="" height="100"
					width="130">
				<div class="caption">
					<h3>DashBoard</h3>
					<p>...</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">View
							DashBoard</a>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img src="./resources/images/hospital-logo.jpg" alt="" height="150"
					width="150">
				<div class="caption">
					<h3>Patient Management</h3>
					<p>
						<a href="${pageContext.request.contextPath}/patientMgmt/getAllPatients" class="btn btn-primary" role="button">View Patients</a>
					</p>
				</div>
			</div>
		</div>

	</div>

</body>
</html>