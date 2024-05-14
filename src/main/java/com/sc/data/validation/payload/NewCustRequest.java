package com.sc.data.validation.payload;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;


public class NewCustRequest {

	@NotBlank(message = "The name is required.")
	@Size(min = 3, max = 20, message = "The name must be from 3 to 20 characters.")
	private String name;

	@NotEmpty(message = "The email is required.")
	@Email(message = "The email is not a valid email.")
	private String email;


	@NotNull(message = "The date of birth is required.")
	@Past(message = "The data of birth must be in the past.")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date birthDate;

	
	@NotNull(message = "The SSN is required.") 
	@Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", message="the ssn number should be of size 11 in the format xxx-xx-xxxx")
	private String ssn;

	@Pattern(regexp = "(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "the phone number should be of formats xxx-xxx-xxxx/xxx xxx xxxx")
	@NotNull(message = "The phone number is required.") 
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}

