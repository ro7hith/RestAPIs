package com.techwave.restapidemo.models.pojo;

import java.time.LocalDate;

public class Emp {
	private int empno;
	private String ename;
	private double sal;
	private LocalDate dob;

	public Emp() {
		super();
	}

	public Emp(int empno, String ename, double sal, LocalDate dob) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.dob = dob;
	}

	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
