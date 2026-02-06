package com.empApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empApp.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
