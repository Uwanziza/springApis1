package com.java.employeeAPI1;

import com.java.employeeAPI1.model.Employee;
import com.java.employeeAPI1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApi1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApi1Application.class, args);
	}
    @Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
       /* Employee employee=new Employee();
		employee.setFirstName("John");
		employee.setLastName("mack");
		employee.setEmailId("john@gmail.com");
		employeeRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirstName("Mathew");
		employee1.setLastName("Wilson");
		employee1.setEmailId("wilson@gmail.com");
		employeeRepository.save(employee1);*/

	}
}
