package org.emp.mgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EmployeeDetails {

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull(message = "First name cannot be empty")
	@Size(min = 3, message = "Please enter minimum 3 characters for first name")
	private String empFirstName;

	@NotNull(message = "Last name cannot be empty")
	@Size(min = 3, message = "Please enter minimum 3 characters for last name")
	private String empLastName;

	@NotNull
	private String gender;

	@Email
	private String emailId;

	@NotNull(message = "Please enter a valid 10 digit mobile number")
	private long mobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
