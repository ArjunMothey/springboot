package com.myspring.myemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.myemployee.entity.Employee;
import com.myspring.myemployee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> saveEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}
	
	
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(int employee_id) {
		return repository.findById(employee_id).orElse(null);
	}
	
	public Employee getEmployeeByName(String employee_name) {
		return repository.findByName(employee_name);
	}
	
	
	public String deleteEmployee(int employee_id) {
		repository.deleteById(employee_id);
		return "employee removed !"+employee_id;
	}
		
	
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee=repository.findById(employee.getEmployee_id()).orElse(null);
		existingEmployee.setEmployee_name(employee.getEmployee_name());
		existingEmployee.setEmployee_email(employee.getEmployee_email());
		existingEmployee.setEmployee_location(employee.getEmployee_location());
		return repository.save(existingEmployee);
	}

}
