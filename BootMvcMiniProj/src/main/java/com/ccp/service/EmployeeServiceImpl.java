package com.ccp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.entity.Employee;
import com.ccp.repo.EmpRepo;
@Service
public class EmployeeServiceImpl implements ISerivceRepo {
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		Employee em=empRepo.save(emp);	   
		return "emp Id Value"+em.getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(int empno) {
		Employee emp=empRepo.findById(empno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "Employee id Value"+empRepo.save(emp).getEmpno();		
	}

	@Override
	public String deleteEmlpoyeeById(int eno) {
		// TODO Auto-generated method stub
		empRepo.deleteById(eno);
		return eno+"employee is deleted";
	}
	

}
