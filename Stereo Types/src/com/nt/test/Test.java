package com.nt.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;

import com.nt.controller.StudentController;
import com.nt.controller.StudentControllerImpl;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/nt/resources/applicationContext.xml");
		// StudentControllerImpl studentControllerImpl=new StudentControllerImpl();
		StudentController studentController = (StudentController) applicationContext.getBean("studentController");
		while (true) {
			System.out.println("1.ADD");
			System.out.println("2.SEARCH");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			System.out.println("5.EXIT");

			System.out.println("Enter Your Option: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int option = Integer.parseInt(br.readLine());

			switch (option) {
			case 1:
				studentController.addStudent();
				break;
			case 2:
				studentController.searchStudent();
				break;
			case 3:
				studentController.updateStudent();
				break;
			case 4:
				studentController.deleteStudent();

				break;
			case 5:
				System.out.println("****Thanks For Using this Application*****");
				System.exit(0);

				break;

			default:
				System.out.println("Please Enter the Options [1,2,3,4,5]");
				break;
			}
		}

	}

}
