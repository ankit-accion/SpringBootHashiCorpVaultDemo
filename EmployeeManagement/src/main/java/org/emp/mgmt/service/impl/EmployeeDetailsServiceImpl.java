package org.emp.mgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.emp.mgmt.model.EmployeeDetails;
import org.emp.mgmt.repository.EmployeeRepository;
import org.emp.mgmt.services.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public EmployeeDetails createEmployee(EmployeeDetails empDetails) {
		return empRepo.save(empDetails);
	}

	@Override
	public Optional<EmployeeDetails> getEmployeeById(Integer id) {
		return empRepo.findById(id);
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails empDetails) {
		return empRepo.save(empDetails);
	}

	@Override
	public void deleteEmpById(Integer id) {
		empRepo.deleteById(id);
	}

	@Override
	public void deleteEmp(EmployeeDetails empDetails) {
		empRepo.delete(empDetails);
	}
}
