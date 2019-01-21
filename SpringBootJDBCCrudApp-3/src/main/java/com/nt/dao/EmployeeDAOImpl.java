package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.BO.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
     @Autowired
	private JdbcTemplate jdbctemplete;
	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String CREATE_EMPLOYEE_SQL="INSERT INTO employee_table(employee_name,email,salary)values(?,?,?)";
	int update=	jdbctemplete.update(CREATE_EMPLOYEE_SQL,employee.getEmployeeName(),employee.getEmail(),employee.getSalary());
		if(update==1) {
			System.out.println("data is inserted");
		}
		
		
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		String GET_EMPLOYEE_SQL="SELECT * FROM employee_table where employee_id=?";
	Employee employee=	jdbctemplete.queryForObject(GET_EMPLOYEE_SQL,new  EmployeerowMapper(),employeeId);
	
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(Integer employeeId, String newEmail) {
		// TODO Auto-generated method stub
		String UPDATE_EMPLOYEE_SQL="UPDATE  employee_table set email=? where employee_id=?";
	int update=	jdbctemplete.update(UPDATE_EMPLOYEE_SQL, newEmail,employeeId);
		if(update == 1) {
			System.out.println("employee email is updated");
		}
		
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		String DELETE_EMPLOYEE_SQL="DELETE  FROM employee_table  where employee_id=?";
		int delete=	jdbctemplete.update(DELETE_EMPLOYEE_SQL,employeeId);
			if(delete == 1) {
				System.out.println("employee  is deleted");
			}
		
	}

}
