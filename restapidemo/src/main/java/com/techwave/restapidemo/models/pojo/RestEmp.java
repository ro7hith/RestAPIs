package com.techwave.restapidemo.models.pojo;

import java.time.LocalDate;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "RestEmp")
@Check(name = "chk_sal",constraints = "sal>5000")
public class RestEmp {
	@Id
	private int empno;
	@Column(length = 30,nullable = false)
	private String ename;
	
	private double sal;
	private LocalDate dob;
	@Column(length = 30,unique = true)
	private String email;
	public RestEmp() {
		super();
	}

	public RestEmp(int empno, String ename, double sal, LocalDate dob,String email) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.dob = dob;
		this.email=email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
