<%@page contentType="text/html;" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>novel health</title>

<link rel="icon" href='<spring:url value="/assets/img/favicon.ico"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/bootstrap.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/font-awesome.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/style.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/side-navbar.css"></spring:url>'>

<!--  bootstrap,jquery css&js CDN -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="80">
	<!--banner-->
	<section id="banner" class="banner">
		<div class="bg-color">

			<!--  top nav-bar -->
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">NOVEL HEALTH CARE</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.name}</a></li>
						<li><a href="./logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
					</ul>
				</div>
			</nav>
			<!-- /top nav-bar -->

			<!-- side-navbar -->
			<nav class="navbar navbar-inverse sidebar" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.name}</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="/superAdminHome">Home<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
							<li><a href="#">Profile<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
							<li><a href="./getAllHospitals">hospital management<span style="font-size: 16px;"
									class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
							<li><a href="#">user management<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="panel-group" style="padding-right: 300px; padding-left: 250px; padding-bottom: 20px;">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: RGBA(13, 70, 83, 0.78); color: white; border-bottom-color: white;" align="center">ADD
						HOSPITAL</div>
					<div class="panel-body" align="center">

						<form:form class="form-horizontal" action="./addhospital" commandName="hospitalBean" method="post">
							<div class="form-group">
								<label class="control-label col-sm-2" for="hospitalname">HospitalName*:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
									<form:errors path="hospitalName"></form:errors>
									<form:input type="text" class="form-control" id="hospitalname" placeholder="enter hospital name" path="hospitalName"></form:input>
								</div>
								<label class="control-label col-sm-2" for="address1">address1*:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
									<form:errors path="address1"></form:errors>
									<form:input type="text" class="form-control" id="address1" placeholder="enter address1" path="address1"></form:input>
								</div>
								<label class="control-label col-sm-2" for="address2">address2:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								
									<form:input type="text" class="form-control" id="address2" placeholder="enter address2(optional)" path="address2"></form:input>
								</div>
								<label class="control-label col-sm-2" for="city">city*:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								<form:errors path="city"></form:errors>
									<form:input type="text" class="form-control" id="city" placeholder="enter city" path="city"></form:input>
								</div>
								<label class="control-label col-sm-2" for="state">state*:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								<form:errors path="state"></form:errors>
									<form:input type="text" class="form-control" id="state" placeholder="enter state" path="state"></form:input>
								</div>
								<label class="control-label col-sm-2" for="zipcode">zipcode*:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								<form:errors path="zipCode"></form:errors>
									<form:input type="text" class="form-control" id="zipcode" placeholder="enter zipcode" path="zipCode"></form:input>
								</div>
								<label class="control-label col-sm-2" for="phone">phone* :</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								<form:errors path="phone"></form:errors>
									<form:input type="text" class="form-control" id="phone" placeholder="enter phone number" path="phone"></form:input>
								</div>
								<label class="control-label col-sm-2" for="fax">Fax* :</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
								<form:errors path="fax"></form:errors>
									<form:input type="text" class="form-control" id="fax" placeholder="enter fax number" path="fax"></form:input>
								</div>
								<label class="control-label col-sm-2" for="email"> docs upload:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
									<form:input type="file" class="form-control" id="email" placeholder="Enter fax number" path="regDocs" disabled="true"></form:input>
								</div>
								<label class="control-label col-sm-2" for="email"> logo upload:</label>
								<div class="col-sm-10" style="padding-right: 200px; padding-bottom: 10px;">
									<form:input type="file" class="form-control" id="email" placeholder="Enter fax number" path="logo" disabled="true"></form:input>
								</div>
								<label class="control-label col-sm-2" for="email"> status:</label>
								<div class="col-sm-10" style="padding-right: 450px; padding-bottom: 20px;">
									<label class="radio-inline" style="color: green;"><form:radiobutton path="status" value="true" />active</label> <label class="radio-inline"
										style="color: red;">
										<form:errors path="status"></form:errors>
										<form:radiobutton path="status" value="false" />in active</label>
								</div>
								<div class="col-sm-10" style="padding-left: 100px; padding-bottom: 10px;">
									<button type="submit" class="btn btn-success" style="text-align: center">add hospital</button>
									<button type="reset" class="btn btn-primary" style="text-align: center">reset</button>
									<a href="./getAllHospitals"><button type="button" class="btn btn-danger" style="text-align: center">cancel</button></a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!--/ banner-->
	<!--footer-->
	<footer id="footer">
		<div class="footer-line">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						© Copyright Dotridge.com
						<div class="credits">
							<!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Medilab
              -->
							Designed by <a href="https://bootstrapmade.com/">Dotridge.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--/ footer-->

	<script src='<spring:url value="/assets/js/jquery.min.js"></spring:url>'></script>
	<script src='<spring:url value="/assets/js/jquery.easing.min.js"></spring:url>'></script>
	<script src='<spring:url value="/assets/js/bootstrap.min.js"></spring:url>'></script>
	<script src='<spring:url value="/assets/js/custom.js"></spring:url>'></script>
	<script src='<spring:url value="/assets/js/side-navbar.js"></spring:url>'></script>

</body>

</html>
