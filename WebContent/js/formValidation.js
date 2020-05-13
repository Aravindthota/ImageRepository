var pcount=0;
var acount=0;
var fcount=0;
var lcount=0;
var icount=0;
function validation() {
	

	var checkImageFile = document.getElementById("imageFile").value;
	var imageName = checkImageFile.replace(/^.*[\\\/]/, '');
	var idxDot = imageName.lastIndexOf(".") + 1;
	var extFile = imageName.substr(idxDot, imageName.length).toLowerCase();
	if (imageName == null) {
		document.getElementById("uploaderr").innerHTML = "<span class='warning'>Please upload an image</span>";
	} 
	 if(pcount == 1 || acount == 1 || lcount == 1 || fcount==1 || icount==1){
		return false;
	} 	

}

function checkPass() {
	//Store the password field objects into variables ...
	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	//Store the Confimation Message Object ...
	var message = document.getElementById('confirmMessage');
	//Set the colors we will be using ...
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	//Compare the values in the password field 
	//and the confirmation field
	if (pass1.value == pass2.value) {
		//The passwords match. 
		//Set the color to the good color and inform
		//the user that they have entered the correct password 
		pass2.style.backgroundColor = goodColor;
		message.style.color = goodColor;
		message.innerHTML = "Passwords Match"
	} else {
		//The passwords do not match.
		//Set the color to the bad color and
		//notify the user.
		pass2.style.backgroundColor = badColor;
		message.style.color = badColor;
		message.innerHTML = "Passwords Do Not Match!"
	}
}
function validatephone(phone) {
		 var regNum = /^(?:\((?=.*\)))?(0?[2-57-8])\)? ?(\d\d(?:[- ](?=\d{3})|(?!\d\d[- ]?\d[- ]))\d\d[- ]?\d[- ]?\d{3})$/;
//	var regNum = /^\(([0]{1})\)?([2-4]{1})\)?([0-9]{1})\)?([0-9]{3})?([0-9]{4})$/	;
	if (regNum.test(phone) == false) {
		document.getElementById("mblerr").innerHTML = "<span class='warning' >Enter a valid australian phone number</span>";
		 pcount = 1;
	}  else {
		document.getElementById("mblerr").innerHTML = "";
		 pcount = 0;
	}
}
// validates text only
function fname_validate(txt) {
	var regName = /^[a-z ,.'-]+$/i;

	if (regName.test(txt) == false) {
		document.getElementById("fName").innerHTML = "<span class='warning' >Name should contain only alpha characters</span>";
		fcount=1;
	} else if (txt.length < 3) {
		document.getElementById("fName").innerHTML = "<span class='warning'>Name should have minimum three characters</span>";
		fcount=1;

	} else {
		document.getElementById("fName").innerHTML = "";
		fcount=0;
	}
}

function lname_validate(txt) {
	var regName = /^[a-z ,.'-]+$/i;

	if (regName.test(txt) == false) {
		document.getElementById("lName").innerHTML = "<span class='warning' >Name should contain only alpha characters</span>";
		lcount=1;
	} else if (txt.length < 3) {
		document.getElementById("lName").innerHTML = "<span class='warning'>Name should have minimum three characters</span>";
		lcount=1;

	} else {
		document.getElementById("lName").innerHTML = "";
		lcount=0;
	}
}

// validate email
function email_validate(email) {
	var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

	if (regMail.test(email) == false) {
		document.getElementById("status").innerHTML = "<span class='warning' >Email address is not valid yet.</span>";
	} else {
		document.getElementById("status").innerHTML = "";
	}
}

// validate address
function add_validate(address) {
	if (address == "") {
		document.getElementById("addresserr").innerHTML = "<span class='warning'>Please enter valid Address</span>";
		address.focus();
		return false;
	}
	if ((address.length < 20) || (address.length > 100)) {
		document.getElementById("addresserr").innerHTML = "<span class='warning'>Your textarea must be 20 to 100 characters</span>";
		acount=1;

	} else {
		document.getElementById("addresserr").innerHTML = "";
		acount=0;
	}

}
//validate password
function pass_validate(password) {
	if (password == "") {
		document.getElementById("passerr").innerHTML = "<span class='warning'>Please enter valid password</span>";
	}
	if ((password.length < 6) || (password.length > 14)) {
		document.getElementById("passerr").innerHTML = "<span class='warning'>Your password must be 6 to 14 characters</span>";

	} else {
		document.getElementById("passerr").innerHTML = "";
	}

}
function upload_validate() {
	var checkImageFile = document.getElementById("imageFile").value;
	var imageName = checkImageFile.replace(/^.*[\\\/]/, '');
	var idxDot = imageName.lastIndexOf(".") + 1;
	var extFile = imageName.substr(idxDot, imageName.length).toLowerCase();
	console.log("extFile",extFile);
	document.getElementById("uploadStatus").innerHTML = "";
	document.getElementById("uploaderr").innerHTML = "";

	if (imageName == null) {
		document.getElementById("uploaderr").innerHTML = "<span class='warning'>Please upload an image</span>";
		icount=1;
		return false;
	} else if ((extFile == "jpg") || (extFile == "jpeg") || (extFile == "png")
			|| (extFile == "bmp") || (extFile == "gif")) {
		document.getElementById("uploadStatus").innerHTML = imageName+ " is uploaded";
		icount=0;
		return true;
		
	} else {
		document.getElementById("uploaderr").innerHTML = "<span class='warning'> Only jpg/jpeg,png,gif and bmp files allowed!</span>";
		icount=1;
return false;
	}

}