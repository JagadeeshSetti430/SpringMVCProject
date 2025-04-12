package com.ccp.service;

import com.ccp.entity.Employee;

public interface ISerivceRepo {
	public Iterable<Employee> getAllEmployees();
   String addEmployee(Employee emp);
   public Employee getEmployeeByNo(int eno);
   public String updateEmployee(Employee emp);
   public String deleteEmlpoyeeById(int eno);
   
}
