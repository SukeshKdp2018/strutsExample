
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<form action="registeruser" method="post">
	<div class="container">
		<div class="col-lg-5">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="uname" id="uname" class="form-control input-sm" placeholder="Full Name">
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="udeg" id="udeg" class="form-control input-sm" placeholder="Designation">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="text" name="uemail" id="uemail" class="form-control input-sm" placeholder="Email">
			</div>
			<div class="form-group">
				<input type="password" name="upass" id="upass" class="form-control input-sm" placeholder="Password">
			</div>
			<input type="submit" class="btn btn-success btn-block" value="Register">
			<div class="text-center" id="resp" style="margin-top: 14px;"></div>
		</div>
	</div>
	</form>
</body>
</html>