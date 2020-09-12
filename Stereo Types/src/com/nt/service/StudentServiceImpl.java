package com.nt.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.StudentDao;
import com.nt.dto.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentdao;

	@Override
	public String add(Student student) throws SQLException {
		String status = studentdao.add(student);
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = studentdao.search(sid);
		return student;
	}

	@Override
	public String update(Student student) {
		String status = studentdao.update(student);
		return status;
	}

	@Override
	public String delete(String sid) {
		String status = studentdao.delete(sid);
		return status;
	}

}
