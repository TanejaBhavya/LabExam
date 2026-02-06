package com.empApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.dto.DeptEmpResponse;
import com.empApp.entity.Employee;
import com.empApp.repo.DepartmentRepo;
import com.empApp.repo.EmployeeRepo;

@RestController
public class EmpController {
	  @Autowired
	    private DepartmentRepo departmentRepo;

	    @Autowired
	    private EmployeeRepo employeeRepo;

	    @GetMapping(path = "/employees")
	    public List<Employee> getAllEmp(){
	        return employeeRepo.findAll();
	    }

	    @GetMapping(path = "/employeesdata")
	    public List<DeptEmpResponse> getAllEmpSelectedData(){
	        return departmentRepo.deptEmployeeData();
	    }

}
