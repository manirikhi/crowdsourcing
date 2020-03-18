<div id="page-wrapper">

			<!-- Header -->
				<div id="header">
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li ui-sref-active="current"><a ui-sref="index">Home</a></li>
								<li ui-sref-active="current"><a ui-sref="tasks">Task List</a></li>
								<li ui-sref-active="current"><a ui-sref="workers" ng-click="getWorkers()">Workers</a></li>
								<li ui-sref-active="current"><a ui-sref="aboutUs">About Us</a></li>
								<li><a ng-click="login()">Login</a></li>
								<li ui-sref-active="current"><a ui-sref="register">Sign Up</a></li>
							</ul>
						</nav>

				</div>

			<div ui-view="mainView"></div>

			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<section class="3u 6u(narrower) 12u$(mobilep)">
								<h3>Popular assignments</h3>
								<ul class="links">
									<li><a href="#">HTML developer required @ Address</a></li>
									<li><a href="#">survey for the pollution in City</a></li>
									<li><a href="#">Baby sitter required</a></li>
									<li><a href="#">Delivery boy for Shop</a></li>
									<li><a href="#">Java Hadoop deveper @40 USA per Hour</a></li>
									<li><a href="#">Coolar repir</a></li>
									<li><a href="#">Survey for language issue</a></li>
								</ul>
							</section>
							<section class="3u 6u$(narrower) 12u$(mobilep)">
								<h3>Most liked skill</h3>
								<ul class="links">
									<li><a href="#">Shop keeper</a></li>
									<li><a href="#">Driver</a></li>
									<li><a href="#">HTML CSS java script deveoper</a></li>
									<li><a href="#">Garderner</a></li>
									<li><a href="#">plumber</a></li>
									<li><a href="#">freelancer</a></li>
									<li><a href="#">Other skill</a></li>
								</ul>
							</section>
							<section class="6u 12u(narrower)">
								<h3>Get In Touch</h3>
								<form>
									<div class="row 50%">
										<div class="6u 12u(mobilep)">
											<input type="text" name="name" id="name" placeholder="Name" />
										</div>
										<div class="6u 12u(mobilep)">
											<input type="email" name="email" id="email" placeholder="Email" />
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<textarea name="message" id="message" placeholder="Message" rows="5"></textarea>
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<ul class="actions">
												<li><input type="submit" class="button alt" value="Send Message" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>

					<!-- Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; Crowdsourcing</li><li>Design: Amandeep Singh Ghotra (27146957),Ashutosh Aggarwal (27274181) </li>
							</ul>
						</div>

				</div>

		</div>