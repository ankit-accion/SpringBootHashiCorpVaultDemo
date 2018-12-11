package org.emp.mgmt.controller;

import java.util.List;
import java.util.Optional;

import org.emp.mgmt.model.EmployeeDetails;
import org.emp.mgmt.services.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeedDetailsController {

	@Autowired
	private EmployeeDetailsService empService;

	@PostMapping(path = "/save")
	public EmployeeDetails saveEmployee(@RequestBody EmployeeDetails empDetails) {
		return empService.createEmployee(empDetails);
	}

	@GetMapping(path = "/id")
	public Optional<EmployeeDetails> getEmpById(@RequestParam Integer id) {
		return empService.getEmployeeById(id);
	}

	@GetMapping(path = "/all")
	public List<EmployeeDetails> getAllEmployee() {
		return empService.getAllEmployee();
	}

	@PutMapping(path = "/update")
	public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails empDetails) {
		return empService.updateEmployee(empDetails);
	}

	@DeleteMapping(path = "/deleteById")
	public void deleteById(@RequestParam Integer id) {
		empService.deleteEmpById(id);
	}

	@DeleteMapping(path = "/deleteEmp")
	public void deleteEmp(@RequestBody EmployeeDetails employeeDetails) {
		empService.deleteEmp(employeeDetails);
	}
}
