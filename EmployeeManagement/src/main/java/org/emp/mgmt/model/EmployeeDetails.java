package org.emp.mgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
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
}
