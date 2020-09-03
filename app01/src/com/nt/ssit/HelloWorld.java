package com.nt.ssit;

public class HelloWorld {
	private String ename;
	private String eno;
	public void setEno(String eno) {
		this.eno = eno;
	}public String getEno() {
		return eno;
	}
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
	public String sayBye()
	{
		return "Bye Friends ";
	}
}
