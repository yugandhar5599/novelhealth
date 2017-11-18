<%@include file="fragments/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>novel health</title>
<%@include file="fragments/head.jsp"%>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
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
							<li><a href="./superAdminHome">Home<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
							<li><a href="#">Profile<span style="font-size: 16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
							<li><a href="./hospitalMgmt/getAllHospitals">hospital management<span style="font-size: 16px;"
									class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
							<li><a href="./adminMgmt/getAllAdmins">admin management<span style="font-size: 16px;"
									class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope"></span></a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div align="center">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<div class="caption">
							<p></p>
							<h3>Hospital Management</h3>

							<p>
								<a href="./hospitalMgmt/getAllHospitals" class="btn btn-primary" role="button">view hospitals</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<div class="caption">
							<h3>Admin Management</h3>
							<p></p>
							<p>
								<a href="./adminMgmt/getAllAdmins" class="btn btn-primary" role="button">view admins</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<div class="caption">
							<h3>Dashboard</h3>
							<p></p>
							<p>
								<a href="#" class="btn btn-primary" role="button"> View Dashboard</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<div class="caption">
						<h3 align="center">profile</h3>
						<p></p>
						<p align="center">
							<a href="#" class="btn btn-primary" role="button">view profile</a>
						</p>
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

	<%@include file="fragments/scripts.jsp"%>

</body>

</html>
