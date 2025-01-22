package com.client.springbootClient.Models.Pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Employee {
	@NotNull(message = "required empno")
	private Integer empno;
	@NotBlank(message = "required ename")
	private String ename;
	@Min(value = 5000,message = "Salary must be >5000")
	private Integer sal;
	@NotNull(message = "Date must be given")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@NotBlank(message = "required email")
	private String email;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
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
	public Employee(Integer empno, String ename, Integer sal, LocalDate dob, String email) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.dob = dob;
		this.email = email;
	}
	public Employee() {
		super();
	}

}
