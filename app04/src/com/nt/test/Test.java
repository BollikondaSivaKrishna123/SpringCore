package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.bean.Student;

public class Test {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("/com/nt/resources/applicationContext.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		Student student=(Student)beanFactory.getBean("std");
		student.Student_Details();
	
	}

}
