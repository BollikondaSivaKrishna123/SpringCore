package com.nt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dao.StudentDao;
import com.nt.dto.Student;
import com.nt.service.StudentService;

@Controller("studentController")
public class StudentControllerImpl implements StudentController {

	BufferedReader br = null;

	@Autowired(required = true)
	private StudentService studentService111;
	@Autowired
	private StudentDao studentDao;

	public StudentControllerImpl() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStudent() {
		try {
			System.out.println("Enter the Student ID:  ");
			String sid = br.readLine();
			System.out.println("Enter the Studnet Name : ");
			String sname = br.readLine();
			System.out.println("Enter the Student Address: ");
			String saddr = br.readLine();
			Student student = new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);

			String status = studentService111.add(student);

			if (status == "existed") {
				System.out.println("Student Existed Already !!!");
			} else if (status == "failure") {
				System.out.println("Insertion Failure !!! Sorry");
			} else if (status == "success") {
				System.out.println("Student Insertion Success !!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void searchStudent() {
		System.out.println("Enter the Student ID : ");
		try {
			String sid = br.readLine();

			Student student = studentService111.search(sid);
			if (student == null) {
				System.out.println("Student Not Existed... Sorry!!!");
			} else {

				System.out.println("Student ID          :" + student.getSid());
				System.out.println("Student Name     :" + student.getSname());
				System.out.println("Student Address :" + student.getSaddr());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student ID : ");
		try {
			String sid = br.readLine();
			Student student = studentDao.search(sid);
			if (student == null) {
				System.out.println("Student Not Existed...");
			} else {
				System.out.println("Student Id     :" + student.getSid());
				System.out.print(
						"Old Student Name           :" + student.getSname() + " " + "Enter New Student Name  	  : ");
				String sname = br.readLine();
				System.out.print(
						"Old Student Address    :" + student.getSaddr() + " " + "Enter New Student Address    : ");
				String saddr = br.readLine();
				Student student2 = new Student();
				student2.setSid(sid);
				student2.setSname(sname);
				student2.setSaddr(saddr);
				String status = studentService111.update(student2);
				if (status == "success") {
					System.out.println("Student Updated Successfullyy.............");

				} else if (status == "failure") {
					System.out.println("Student Updation Failure.....Sorry");
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {
		System.out.println("Enter the Student ID :");
		String sid;
		try {
			sid = br.readLine();
			Student student = studentDao.search(sid);
			if (student == null) {
				System.out.println("Student Not Existed !!! Sorry ....");

			} else {
				String status = studentService111.delete(sid);
				if (status == "success") {
					System.out.println("Student Deletion Success !!!....");
				} else if (status == "failure") {
					System.out.println("Student Deletion Failure");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
