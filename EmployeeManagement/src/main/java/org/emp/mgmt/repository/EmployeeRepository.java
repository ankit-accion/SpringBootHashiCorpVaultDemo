package org.emp.mgmt.repository;

import java.util.List;

import org.emp.mgmt.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

	List<EmployeeDetails> findByEmpFirstName(String firstName);

	List<EmployeeDetails> findByEmpLastName(String lastName);

	List<EmployeeDetails> findByGender(String gender);

	List<EmployeeDetails> findByEmailId(String emailId);

	List<EmployeeDetails> findByMobile(long mobile);
}
