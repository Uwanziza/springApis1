package com.java.employeeAPI1.repository;

import com.java.employeeAPI1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    //ALL CRUD
}
