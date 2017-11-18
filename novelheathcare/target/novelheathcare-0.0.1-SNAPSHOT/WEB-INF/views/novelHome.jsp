<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>novel health</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href='<spring:url value="/assets/img/favicon.ico"></spring:url>'>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/font-awesome.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/bootstrap.min.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/style.css"></spring:url>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/assets/css/login.css"></spring:url>'>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="80">
	<!--banner-->
	<section id="banner" class="banner">
		<div class="bg-color">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="col-md-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img src='<spring:url value="/assets/img/novel_logo.png"></spring:url>' class="img-responsive"
								style="width: 500px; margin-top: -16px;"></a>
						</div>
						<div class="collapse navbar-collapse navbar-right" id="myNavbar">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#banner">Home</a></li>
								<li class=""><a href="#service">Services</a></li>
								<li class=""><a href="#about">About</a></li>
								<li class=""><a href="#testimonial">Testimonial</a></li>
								<li class=""><a href="#contact">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="banner-info">
						<div class="form-container">
							<form:form class="form-signin" action="login" commandName="loginBean" method="post">

								<h2 class="form-signin-heading">login here</h2>
								<hr>
								<h4 style="color: red;">
									<%
										if (request.getAttribute("msg") != null) {
												out.println(request.getAttribute("msg"));
											}
									%>
								</h4>
								<label for="inputEmail" class="sr-only">user name</label>
								<form:input path="userName" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="true" />
								<label for="inputPassword" class="sr-only">password</label>
								<form:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="true" />
								<div class="checkbox">
									<label> <input type="checkbox" value="remember-me" /> Remember me
									</label>
								</div>
								<form:button class="btn btn-lg btn-primary btn-block" type="submit">login</form:button>
							</form:form>
							<a href="forgotPassword" style="color: white; text-align: right;"><b>forgot password?</b></a>
						</div>
						<div class="banner-text text-left">
							<h1 class="white">Healthcare at your desk!!</h1>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod <br>tempor incididunt ut labore et dolore magna aliqua.
							</p>
							<a href="#contact" class="btn btn-appoint">Make an Appointment.</a>
						</div>
						<div class="overlay-detail text-center">
							<a href="#service"><i class="fa fa-angle-down"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ banner-->

	<!--service-->
	<section id="service" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4">
					<h2 class="ser-title">Our Service</h2>
					<hr class="botm-line">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
						minim veniam, quis nostrud exercitation ullamco laboris cillum.</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-stethoscope"></i>
						</div>
						<div class="icon-info">
							<h4>24 Hour Support</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-ambulance"></i>
						</div>
						<div class="icon-info">
							<h4>Emergency Services</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-user-md"></i>
						</div>
						<div class="icon-info">
							<h4>Medical Counseling</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-medkit"></i>
						</div>
						<div class="icon-info">
							<h4>Premium Healthcare</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ service-->

	<!--cta-->
	<section id="cta-1" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="schedule-tab">
					<div class="col-md-4 col-sm-4 bor-left">
						<div class="mt-boxy-color"></div>
						<div class="medi-info">
							<h3>Emergency Case</h3>
							<p>I am text block. Edit this text from Appearance / Customize / Homepage header columns. Lorem ipsum dolor sit amet, consectetur
								adipiscing elit.</p>
							<a href="#" class="medi-info-btn">READ MORE</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-4">
						<div class="medi-info">
							<h3>Emergency Case</h3>
							<p>I am text block. Edit this text from Appearance / Customize / Homepage header columns. Lorem ipsum dolor sit amet, consectetur
								adipiscing elit.</p>
							<a href="#" class="medi-info-btn">READ MORE</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 mt-boxy-3">
						<div class="mt-boxy-color"></div>
						<div class="time-info">
							<h3>Opening Hours</h3>
							<table style="margin: 8px 0px 0px;" border="1">
								<tbody>
									<tr>
										<td>Monday - Friday</td>
										<td>8.00 - 17.00</td>
									</tr>
									<tr>
										<td>Saturday</td>
										<td>9.30 - 17.30</td>
									</tr>
									<tr>
										<td>Sunday</td>
										<td>9.30 - 15.00</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--cta-->

	<!--about-->
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4 col-xs-12">
					<div class="section-title">
						<h2 class="head-title lg-line">
							The Medilap <br>Ultimate Dream
						</h2>
						<hr class="botm-line">
						<p class="sec-para">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua..</p>
						<a href="" style="color: #0cb8b6; padding-top: 10px;">Know more..</a>
					</div>
				</div>
				<div class="col-md-9 col-sm-8 col-xs-12">
					<div style="visibility: visible;" class="col-sm-9 more-features-box">
						<div class="more-features-box-text">
							<div class="more-features-box-text-icon">
								<i class="fa fa-angle-right" aria-hidden="true"></i>
							</div>
							<div class="more-features-box-text-description">
								<h3>It's something important you want to know.</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam,
									quis nostrud.</p>
							</div>
						</div>
						<div class="more-features-box-text">
							<div class="more-features-box-text-icon">
								<i class="fa fa-angle-right" aria-hidden="true"></i>
							</div>
							<div class="more-features-box-text-description">
								<h3>It's something important you want to know.</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam,
									quis nostrud.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ about-->

	<!--doctor team-->
	<section id="doctor-team" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="ser-title">Meet Our Doctors!</h2>
					<hr class="botm-line">
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="thumbnail">
						<img src='<spring:url value="/assets/img/doctor1.jpg"></spring:url>' alt="..." class="team-img">
						<div class="caption">
							<h3>Jessica Wally</h3>
							<p>Doctor</p>
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="thumbnail">
						<img src="<spring:url value="/assets/img/doctor2.jpg"></spring:url>" alt="..." class="team-img">
						<div class="caption">
							<h3>Iai Donas</h3>
							<p>Doctor</p>
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="thumbnail">
						<img src="<spring:url value="/assets/img/doctor3.jpg"></spring:url>" alt="..." class="team-img">
						<div class="caption">
							<h3>Amanda Denyl</h3>
							<p>Doctor</p>
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="thumbnail">
						<img src="<spring:url value="/assets/img/doctor4.jpg"></spring:url>" alt="..." class="team-img">
						<div class="caption">
							<h3>Jason Davis</h3>
							<p>Doctor</p>
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ doctor team-->
	<!--testimonial-->
	<section id="testimonial" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="ser-title">see what patients are saying?</h2>
					<hr class="botm-line">
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src='<spring:url value="/assets/img/thumb.png"></spring:url>' alt="" class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src='<spring:url value="/assets/img/thumb.png"></spring:url>' alt="" class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src='<spring:url value="/assets/img/thumb.png"></spring:url>' alt="" class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ testimonial-->
	<!--cta 2-->
	<section id="cta-2" class="section-padding">
		<div class="container">
			<div class=" row">
				<div class="col-md-2"></div>
				<div class="text-right-md col-md-4 col-sm-4">
					<h2 class="section-title white lg-line">
						« A few words<br> about us »
					</h2>
				</div>
				<div class="col-md-4 col-sm-5">
					Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the
					1500s, when an unknown printer took a galley of type and scrambled it to make a typek
					<p class="text-right text-primary">
						<i>— Medilap Healthcare</i>
					</p>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</section>
	<!--cta-->
	<!--contact-->
	<section id="contact" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="ser-title">Contact us</h2>
					<hr class="botm-line">
				</div>
				<div class="col-md-4 col-sm-4">
					<h3>Contact Info</h3>
					<div class="space"></div>
					<p>
						<i class="fa fa-map-marker fa-fw pull-left fa-2x"></i>321 Awesome Street<br> New York, NY 17022
					</p>
					<div class="space"></div>
					<p>
						<i class="fa fa-envelope-o fa-fw pull-left fa-2x"></i>info@companyname.com
					</p>
					<div class="space"></div>
					<p>
						<i class="fa fa-phone fa-fw pull-left fa-2x"></i>+1 800 123 1234
					</p>
				</div>
				<div class="col-md-8 col-sm-8 marb20">
					<div class="contact-info">
						<h3 class="cnt-ttl">Having Any Query! Or Book an appointment</h3>
						<div class="space"></div>
						<div id="sendmessage">Your message has been sent. Thank you!</div>
						<div id="errormessage"></div>
						<form action="" method="post" role="form" class="contactForm">
							<div class="form-group">
								<input type="text" name="name" class="form-control br-radius-zero" id="name" placeholder="Your Name" data-rule="minlen:4"
									data-msg="Please enter at least 4 chars" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<input type="email" class="form-control br-radius-zero" name="email" id="email" placeholder="Your Email" data-rule="email"
									data-msg="Please enter a valid email" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control br-radius-zero" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4"
									data-msg="Please enter at least 8 chars of subject" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<textarea class="form-control br-radius-zero" name="message" rows="5" data-rule="required" data-msg="Please write something for us"
									placeholder="Message"></textarea>
								<div class="validation"></div>
							</div>

							<div class="form-action">
								<button type="submit" class="btn btn-form">Send Message</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ contact-->
	<!--footer-->
	<footer id="footer">
		<div class="top-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">About Us</h4>
						</div>
						<div class="info-sec">
							<p>Praesent convallis tortor et enim laoreet, vel consectetur purus latoque penatibus et dis parturient.</p>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Quick Links</h4>
						</div>
						<div class="info-sec">
							<ul class="quick-info">
								<li><a href="index.html"><i class="fa fa-circle"></i>Home</a></li>
								<li><a href="#service"><i class="fa fa-circle"></i>Service</a></li>
								<li><a href="#contact"><i class="fa fa-circle"></i>Appointment</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Follow us</h4>
						</div>
						<div class="info-sec">
							<ul class="social-icon">
								<li class="bglight-blue"><i class="fa fa-facebook"></i></li>
								<li class="bgred"><i class="fa fa-google-plus"></i></li>
								<li class="bgdark-blue"><i class="fa fa-linkedin"></i></li>
								<li class="bglight-blue"><i class="fa fa-twitter"></i></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-line">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						� Copyright Dotridge.com
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
	<script src='<spring:url value="/assets/contactform/contactform.js"></spring:url>'></script>

</body>

</html>
