package org.emp.mgmt.services;

import java.util.List;
import java.util.Optional;

import org.emp.mgmt.model.EmployeeDetails;

public interface EmployeeDetailsService {

	EmployeeDetails createEmployee(EmployeeDetails empDetails);

	Optional<EmployeeDetails> getEmployeeById(Integer id);

	List<EmployeeDetails> getAllEmployee();

	EmployeeDetails updateEmployee(EmployeeDetails empDetails);

	void deleteEmpById(Integer id);

	void deleteEmp(EmployeeDetails empDetails);

}