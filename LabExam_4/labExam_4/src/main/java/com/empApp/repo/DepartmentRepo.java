package com.empApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empApp.dto.DeptEmpResponse;
import com.empApp.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>  {

	
	@Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees")
	public List<Department> findAll();
	
	   @Query("SELECT new com.empApp.dto.DeptEmpResponse(e.eName, e.salary, d.dName) FROM Department d JOIN d.employees e")
   public  List<DeptEmpResponse> deptEmployeeData();
}
