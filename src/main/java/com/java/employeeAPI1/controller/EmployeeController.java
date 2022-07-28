package com.java.employeeAPI1.controller;

import com.java.employeeAPI1.exception.ResourceNotFoundException;
import com.java.employeeAPI1.model.Employee;
import com.java.employeeAPI1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    //build create an employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        Employee employee1=new Employee();
        return employeeRepository.save(employee);
    }

    //get employee by Id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update api
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetail){
        Employee updateEmployee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateEmployee.setFirstName(employeeDetail.getFirstName());
        updateEmployee.setLastName(employeeDetail.getLastName());
        updateEmployee.setEmailId(employeeDetail.getEmailId());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
 //delete the id of employee

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
