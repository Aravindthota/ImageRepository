<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/form.css" type="text/css" rel="stylesheet"></link>
<script type="text/javascript" src="js/formValidation.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		var today = new Date();
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			autoclose : true,
			endDate : "today",
			maxDate : today

		});
	});
</script>

</head>
<body>
	<p style="color: red;">${errorString}</p>
	<p style="color: red;">${successString}</p>

	<div class="container register-form">
		<form name="myform" class="form" method="post"
			action="${pageContext.request.contextPath}/register"
			enctype="multipart/form-data" onsubmit="return validation()">
			<div class="note">
				<p>Online Health Care System</p>
			</div>

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="label">First Name</label> <input required
								type="text" name="firstName" class="form-control" id="txt"
								maxlength="20" onkeyup="fname_validate(this.value);"
								placeholder="Your First Name *" value="" /> <span id="fName"
								style="color: red" class="fName"></span>
						</div>
						<div class="form-group">
							<label class="label">Last Name</label> <input required
								type="text" name="lastName" class="form-control" id="txt"
								maxlength="20" onkeyup="lname_validate(this.value);"
								placeholder="Your Last Name *" value="" /> <span id="lName"
								style="color: red" class="lName"></span>
						</div>
						<div class="form-group">
							<label class="label">Email</label> <input required type="email"
								name="email" class="form-control" id="email"
								onchange="email_validate(this.value);"
								placeholder="Your Email *" value="" />
							<div class="status" style="color: red" id="status"></div>
						</div>
						<div class="form-group">
							<label class="label">Date of Birth</label> <input type="text"
								required name="dob" id="datepicker" class="form-control"
								value="" />
						</div>

						<div class="form-group">
							<label class="label">Address</label>
							<textarea name="address" class="form-control"
								onkeyup="add_validate(this.value);" placeholder="Your address *"></textarea>
							<span id="addresserr" style="color: red" class="addresserr"></span>
						</div>


					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="label">Password</label> <input required
								type="password" name="password" id="pass1" class="form-control"
								onkeyup="pass_validate(this.value);"
								placeholder="Your Password *" value="" /> <span id="passerr"
								style="color: red" class="passerr"></span>
						</div>
						<div class="form-group">
							<label class="label">Confirm Password</label> <input required
								type="password" name="confirmPassword" id="pass2"
								class="form-control" placeholder="Confirm Password *"
								onkeyup="checkPass(); return false;" value="" /> <span
								id="confirmMessage" class="confirmMessage"></span>
						</div>
						<div class="form-group">
							<label class="label">Phone</label> <input required type="tel"
								name="phone" class="form-control"
								onkeyup="validatephone(this.value);"
								placeholder="Your Phone Number *" value="" /> <span id="mblerr"
								style="color: red" class="mblerr"></span>
						</div>
						<div class="form-group">
							<p class="label">Gender</p>
							<input type="radio" name="gender" value="m" checked>Male
							<input type="radio" name="gender" value="f">Female
						</div>

						<br> <br>

						<div class="form-group">
							<label style="width: 230px;" class="label">Upload Image
								Here</label> <input required type="file" name="imageFile" id="imageFile"
								onchange="return upload_validate(this.value)"
								accept=".png, .jpg, .jpeg" style="display: none;">
							<label class="btnUpload" for="imageFile">Select Image</label><br>
							<span class="uploadStatus" style="color: green" id="uploadStatus"></span>
							<span class="uploaderr" style="color: red" id="uploaderr"></span>
							
						</div>

					</div>
				</div>
				<br>
				<div align="center">
					<input type="submit" class="btnSubmit" value="Submit"
						 />
				</div>
			</div>
		</form>
	</div>
</body>
</html>