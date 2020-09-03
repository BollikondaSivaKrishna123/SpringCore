package com.nt.ssit;

public class HelloWorld {
	private String ename;
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEname() {
		return ename;
	}
	
	
	public String sayHello()			//Business Method
	{
		return " Hello Guru , "+ename;
	}
}


