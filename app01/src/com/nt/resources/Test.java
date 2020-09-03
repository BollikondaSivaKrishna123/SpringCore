package com.nt.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.ssit.HelloWorld;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld=(HelloWorld)applicationContext.getBean("hello");
		//helloWorld.setEname("Rohit Sharma");
		
		System.out.println(helloWorld.sayHello());
	}

}
