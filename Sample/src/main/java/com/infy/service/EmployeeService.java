package com.infy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.EmployeeEntity;
import com.infy.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<EmployeeDTO> getAllEmployees() {
		
		List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for(EmployeeEntity entity : employeeEntities) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpId(entity.getEmpId());
			dto.setEmpName(entity.getEmpName());
			dto.setEmpPhone(entity.getEmpPhone());
			
			employeeDTOs.add(dto);
		}
		return employeeDTOs;
		
	}
	
	public String employeeCreate(EmployeeDTO dto) {
		
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpId(dto.getEmpId());
		entity.setEmpName(dto.getEmpName());
		entity.setEmpPhone(dto.getEmpPhone());
		employeeRepo.saveAndFlush(entity);
		return entity.getEmpName()+"\t got persisted successfully";
		
	}
	
	
	  public String employeeUpdate(long phoneNumber, EmployeeDTO dto) {
	  
	  EmployeeEntity employeeEntity = employeeRepo.findByPhoneNumber(phoneNumber);
	  
	  employeeEntity.setEmpName(dto.getEmpName());
	  employeeEntity.setEmpPhone(dto.getEmpPhone());
	  EmployeeEntity savedEntity =  employeeRepo.saveAndFlush(employeeEntity); 
	  
	  return "Employee with phone number \t"+savedEntity.getEmpPhone()+"\t updated successfully"; }
	 

}
