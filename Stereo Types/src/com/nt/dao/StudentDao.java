package com.nt.dao;

import java.sql.SQLException;

import com.nt.dto.Student;

public interface StudentDao {

	public String add(Student student) throws SQLException;

	public Student search(String sid);

	public String update(Student student);

	public String delete(String sid);

}
