package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.nt.dto.Student;

//@Component
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private MysqlDataSource mysqlDataSource;

	@Override
	public String add(Student student) throws SQLException {

		Connection connection = mysqlDataSource.getConnection();
		PreparedStatement pStatement = connection.prepareStatement("select * from Student where sid=?");
		pStatement.setString(1, student.getSid());
		ResultSet rSet = pStatement.executeQuery();
		boolean b = rSet.next();
		String status = "";
		if (b == true) {
			return status = "existed";

		} else if (b == false) {
			pStatement = connection.prepareStatement("insert into Student values(?,?,?)");
			pStatement.setString(1, student.getSid());
			pStatement.setString(2, student.getSname());
			pStatement.setString(3, student.getSaddr());
			int rowcount = pStatement.executeUpdate();
			if (rowcount == 1) {
				return status = "success";
			} else {
				return status = "failure";
			}
		}
		return status;

	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = mysqlDataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Student  where sid=?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				student = new Student();
				student.setSid(rs.getString(1));
				student.setSname(rs.getString(2));
				student.setSaddr(rs.getString(3));

			} else {
				student = null;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		try {
			Connection connection = mysqlDataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Update Student set sname=?, saddr=? where sid=? ");
			preparedStatement.setString(3, student.getSid());
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setString(2, student.getSaddr());
			int rowcount = preparedStatement.executeUpdate();
			if (rowcount == 1) {
				return status = "success";

			} else {
				return status = "failure";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		Connection connection;
		try {
			connection = mysqlDataSource.getConnection();
			PreparedStatement pStatement = connection.prepareStatement("delete from Student where sid=?");
			pStatement.setString(1, sid);
			int rowCount = pStatement.executeUpdate();
			if (rowCount == 1) {
				return status = "success";

			} else {
				return status = "failure";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

}
