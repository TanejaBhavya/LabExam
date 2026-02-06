package com.empApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.empApp.entity.Department;
import com.empApp.exceptions.ResouceNotFoundException;
import com.empApp.repo.DepartmentRepo;
@RestController
public class DeptController {
    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping(path = "departments")
    public List<Department> getAll(){
        return departmentRepo.findAll();
    }

    @GetMapping(path = "departments/{id}")
    public Department getById(@PathVariable int id){
        return departmentRepo.findById(id).orElseThrow(()->new ResouceNotFoundException("dept is not found"));
    }

}
