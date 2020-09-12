package com.nt.resources;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.nt.controller.StudentController;
import com.nt.controller.StudentControllerImpl;
import com.nt.dao.StudentDao;
import com.nt.dao.StudentDaoImpl;
import com.nt.dto.Student;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;

@Configuration
public class AppConfig {
	MysqlDataSource dataSource=null;
	@Bean
	public MysqlDataSource mysqlDataSource2()
	{
		dataSource=new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost/Demo507?serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("");
		return dataSource;
	}
	@Bean
	public StudentService studentService()
	{
		StudentService service=new StudentServiceImpl();
		return service;
			}
	@Bean		
	public StudentDao studentDao()
	{
		StudentDao studentDao=new StudentDaoImpl();
		return studentDao;
	}
			@Bean
	public StudentController studentController()
	{
		StudentController studentController=new StudentControllerImpl();
		return studentController;
		
	}
		
	
}
