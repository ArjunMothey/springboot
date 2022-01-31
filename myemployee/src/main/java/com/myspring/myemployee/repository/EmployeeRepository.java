package com.myspring.myemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspring.myemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee findByName(String employee_name);

}
