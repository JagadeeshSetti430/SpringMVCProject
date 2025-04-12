package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;

import com.ccp.entity.Employee;

public interface EmpRepo extends CrudRepository<Employee, Integer>{

}
