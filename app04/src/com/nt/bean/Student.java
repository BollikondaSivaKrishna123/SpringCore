package com.nt.bean;

public class Student {
private int sid;
private String sname;
private float esal;
private String eaddr;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public float getEsal() {
	return esal;
}
public void setEsal(float esal) {
	this.esal = esal;
}
public String getEaddr() {
	return eaddr;
}
public void setEaddr(String eaddr) {
	this.eaddr = eaddr;
}
public void Student_Details()
{
System.out.println("Student Id            : "+sid);
System.out.println("Student Name      : "+sname);
System.out.println("Student Salary     : "+esal);
System.out.println("Student Address  : "+eaddr);
}
}
