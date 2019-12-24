package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.EmployeeDTO;
import com.infy.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Get all employees
	@GetMapping(produces = "application/json")
	public List<EmployeeDTO> fetchEmployees() {
		return employeeService.getAllEmployees();
		
	}
	
	//Create Employee
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		String response = "";
		response = employeeService.employeeCreate(employeeDTO);
		return ResponseEntity.ok(response);
		
	}
	
	//Update an existing employee
	
	  @PutMapping(value = "/{phoneNumber}",consumes = "application/json") public
	  String updateEmployee(@PathVariable("phoneNumber") long phoneNumber, @RequestBody EmployeeDTO employeeDTO) { return
	  employeeService.employeeUpdate(phoneNumber,employeeDTO);
	  
	  }
	 
	
	
}
