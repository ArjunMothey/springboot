package com.myspring.myemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.myemployee.entity.Employee;
import com.myspring.myemployee.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping(value="addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("Employee saved!");
		return service.saveEmployee(employee);
	}
	@PostMapping(value="addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees){
		return service.saveEmployees(employees);
	}
	
	
	
	@GetMapping(value="employees")
	public List<Employee> findAllEmployees(){
		return service.getEmployees();
	}
	@GetMapping(value="employee/{id}")
	public Employee findEmployeeById(@PathVariable int employee_id) {
	return service.getEmployeeById(employee_id);
	}
	@GetMapping(value="employee/{name}")
	public Employee findEmployeeByName(@PathVariable String employee_name) {
		return service.getEmployeeByName(employee_name);
		}
	
	
	@PutMapping(value="update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	
	@DeleteMapping(value="delete/{id}")
	public String deleteEmployee(@PathVariable int employee_id) {
		return service.deleteEmployee(employee_id);
	}
}
