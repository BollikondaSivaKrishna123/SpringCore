package com.nt.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.ssit.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee=(Employee)applicationContext.getBean("emp");
		employee.EmployeeDetails();
	}
}
