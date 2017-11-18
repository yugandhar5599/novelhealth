<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
							<li><a href="${pageContext.request.contextPath}/superAdminHome">home<span style="font-size: 16px;"
									class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
							<li><a href="#">Profile<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
							<li><a href="./getAllHospitals">hospital management<span style="font-size: 16px;"
									class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
							<li><a href="#">user management<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="panel panel-default" style="width: 85%; float: right;">
				<div class="panel-heading">
					<b>HOSPITAL MANAGEMENT BOARD</b>
				</div>
				<div class="panel-body">
					<div class="row">

						<div class="col-md-6 col-sm-12 btn-margin-bottom action-buttons">
							<div class="btn-group" id="divAddNew">
								<a title="Add new" class="btn btn-block btn-danger btn-flat" href="./addHospitalPage"><span class="hide-on-mobile">Add New </span><i
									class="fa fa-plus"></i></a>
							</div>
							<div class="btn-group" id="divDelete">
								<a id="imgDelete" title="Delete" class="btn btn-block btn-primary btn-flat" href="#"><span class="hide-on-mobile">Delete </span><i
									class="fa fa-trash-o"></i></a>
							</div>
							<div class="btn-group" id="divActive">
								<a id="imgActive" title="Active" class="btn btn-block btn-primary btn-flat"><span class="hide-on-mobile">Active </span><i
									class="fa fa-check"></i></a>
							</div>
							<div class="btn-group" id="divInactive">
								<a id="imgInactive" title="Inactive" class="btn btn-block btn-primary btn-flat"><span class="hide-on-mobile">Inactive </span><i
									class="fa fa-ban"></i></a>
							</div>
							<div class="btn-group">
								<a title="Show All" class="btn btn-block btn-primary btn-flat" onclick="showAllRecords();" href="./getAllHospitals"><span
									class="hide-on-mobile">Show All&nbsp;&nbsp;</span><i class="fa fa-th-list"></i></a>
							</div>
							<div align="left">
								<form class="navbar-form navbar-center" role="search" action="./searchHospitals">
									<select id="ddlFilter" class="ddlFilter form-control input-sm input-small input-inline" name="searchKey">
										<option value="-- Select --">-- Select --</option>
										<option value="HospitalName">Hospital Name</option>
										<option value="Address1">Address1</option>
										<option value="Email">Email</option>
										<option value="Phone">Phone</option>
										<option value="IsActive">Status</option>
									</select> <input type="text" id="txtSearchField" name="searchValue" class="form-control input-sm input-small input-inline" />
									<button type="submit" class="btn btn-default">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
					<table class="table" border="1">
						<tr style="background-color: #337ab7;">
							<th>Hospital Id</th>
							<th>Hospital Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Address1</th>
							<th>Status</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<c:if test="${hospitalList >= '1'}">
							<c:forEach items="${hospitalList}" var="hospitalBean">
								<tr>
									<td>${hospitalBean.hospitalId}</td>
									<td>${hospitalBean.hospitalName}</td>
									<td>${hospitalBean.email}</td>
									<td>${hospitalBean.phone}</td>
									<td>${hospitalBean.address1}</td>
									<td>${hospitalBean.status}</td>
									<td><a href="./editHospital?hospId=${hospitalBean.hospitalId}"><span class="glyphicon glyphicon-edit"></span></a></td>
									<td><a href="./deleteHospital?hospId=${hospitalBean.hospitalId}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>

			</div>
		</div>
		<!-- side navbar -->
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
