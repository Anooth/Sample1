package com.infy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

	@Query("SELECT t FROM EmployeeEntity t WHERE t.empPhone=?1")
   	EmployeeEntity findByPhoneNumber(long empPhone);
	
}
