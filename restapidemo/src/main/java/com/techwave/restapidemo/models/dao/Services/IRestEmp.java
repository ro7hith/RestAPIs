package com.techwave.restapidemo.models.dao.Services;

import java.util.List;

import com.techwave.restapidemo.models.pojo.RestEmp;

public interface IRestEmp {
	List<RestEmp> GetAll();

	RestEmp GetById(int empno);

	String InsertEmp(RestEmp E);

	RestEmp UpdateEmp(RestEmp E, int empno);

	String DeleteEmp(int empno);

}
