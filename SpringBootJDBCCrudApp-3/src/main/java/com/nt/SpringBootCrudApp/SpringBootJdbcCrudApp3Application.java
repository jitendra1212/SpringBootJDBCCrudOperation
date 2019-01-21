package com.nt.SpringBootCrudApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nt.BO.Employee;
import com.nt.dao.EmployeeDAO;

@SpringBootApplication
@ComponentScan(basePackages="com.nt.dao")
public class SpringBootJdbcCrudApp3Application implements CommandLineRunner {
    @Autowired
	private EmployeeDAO employeeDAO;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcCrudApp3Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//cerateEmployee();
		//getEmployeeById();
		//employeeDAO.updateEmployeeEmailById(1, "jitendra98@gmail.com");
		employeeDAO.deleteEmployeeById(2);
		//getEmployeeById();
		
	}
	
	
	private void getEmployeeById() {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.getEmployeeById(1);
		System.out.println(employee);
		
	}
	private void cerateEmployee() {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmployeeName("Jitendra");
		employee.setEmail("bansal@gmail.com");
	
		employee.setSalary(10000.00);
		employeeDAO.createEmployee(employee);
		
	}

}

