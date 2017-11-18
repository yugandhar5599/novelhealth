<%@include file="fragments/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>novel health</title>
<%@include file="fragments/head.jsp"%>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
<!--  bootstrap,jquery css&js CDN -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
						<li><a href="../logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
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
							<li><a href="../superAdminHome">home<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
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
								<a id="DeleteButton" title="Delete" class="btn btn-block btn-primary btn-flat"  onclick="return confirm('are you want to delete')"><span class="hide-on-mobile">Delete </span><i
									class="fa fa-trash-o"></i></a>
							</div>
							<div class="btn-group" id="divActive">
								<a id="ActiveButton" title="Active" class="btn btn-block btn-primary btn-flat" href="./multipleActive" onclick="return conform('are you want to delete')"><span class="hide-on-mobile">Active </span><i
									class="fa fa-check"></i></a>
							</div>
							<div class="btn-group" id="divInactive">
								<a id="InactiveButton" title="Inactive" class="btn btn-block btn-primary btn-flat" href="./multipleInActive"  onclick="return conform('are you want to delete')"><span class="hide-on-mobile">Inactive </span><i
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
										<option value="status">Status</option>
									</select> <input type="text" id="txtSearchField" name="searchValue" class="form-control input-sm input-small input-inline" />
									<button type="submit" class="btn btn-default">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
					<form id="table-form" name="table-form"  method="get">
					<table class="table" border="1">
						<tr style="background-color: #337ab7;">
							<th><input type="checkbox" id="checkAll"></th>
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
								<td align="center"><input type="checkbox" class="check" value="${hospitalBean.hospitalId}" name="id"/></td>
									<td>${hospitalBean.hospitalName}</td>
									<td>${hospitalBean.email}</td>
									<td>${hospitalBean.phone}</td>
									<td>${hospitalBean.address1}</td>
									<c:choose>
										<c:when test="${hospitalBean.status}">
											<td><a id="status" href="./statusUpdate?hospId=${hospitalBean.hospitalId}" onclick="statusInactiveConform()"><span
													class="glyphicon glyphicon-ok"></span></a></td>
										</c:when>
										<c:otherwise>
											<td><a id="status" href="./statusUpdate?hospId=${hospitalBean.hospitalId}" onclick="statusActiveConform()"> <span
													class="glyphicon glyphicon-remove"></span></a></td>
										</c:otherwise>
									</c:choose>
									<td><a href="./editHospitalPage?hospId=${hospitalBean.hospitalId}"><span class="glyphicon glyphicon-edit"></span></a></td>
									<td><a href="./deleteHospital?hospId=${hospitalBean.hospitalId}" onclick="return confirm('Are you sure you want to delete this item?');"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					</form>
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

	<%@include file="fragments/scripts.jsp"%>

</body>
</html>
