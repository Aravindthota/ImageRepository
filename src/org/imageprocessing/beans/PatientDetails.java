package org.imageprocessing.beans;

public class PatientDetails {
	
	public static final String GENDER_MALE="M";
	public static final String GENDER_FEMALE="F";
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String mobile;
	private String gender;
	private String base64Image;
	private String address;
	
	public PatientDetails() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	 public String getGender() {
	       return gender;
	   }
	 
	   public void setGender(String gender) {
	       this.gender = gender;
	   }
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
	