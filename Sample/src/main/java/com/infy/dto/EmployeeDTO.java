package com.infy.dto;

import org.springframework.stereotype.Component;


public class EmployeeDTO {
	


	private Integer empId;
	private String empName;
	private long empPhone;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(long i) {
		this.empPhone = i;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee: "+empName;
	}
	
	
}
