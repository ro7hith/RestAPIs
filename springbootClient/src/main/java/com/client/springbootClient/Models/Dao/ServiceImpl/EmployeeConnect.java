package com.client.springbootClient.Models.Dao.ServiceImpl;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.springbootClient.restUrls;
import com.client.springbootClient.Models.Dao.Services.IEmployee;
import com.client.springbootClient.Models.Pojo.Employee;
@Service
public class EmployeeConnect implements IEmployee {

	@Autowired
	RestTemplate rTemplate;

	@Override
	public Employee[] GetAllEmps() {
		ResponseEntity<Employee[]> Earray = rTemplate.getForEntity(restUrls.GET_ALL_EMPLOYESS, Employee[].class);
		return Earray.getBody();
	}

	@Override
	public Employee GetById(int empno) {
		ResponseEntity<Employee> E = rTemplate.getForEntity(restUrls.GET_EMPLOYEE_BY_ID, Employee.class, empno);
		return E.getBody();

	}

	@Override
	public String Insert(Employee E) {
		ResponseEntity<String> S=rTemplate.postForEntity(restUrls.INSERT_EMPLOYEE, E,String.class);
		return S.getBody();
	}

	@Override
	public Employee Update(Employee E) {
		rTemplate.put(restUrls.UPDATE_EMPLOYEE, E,E.getEmpno());
		return E;
	}

	@Override
	public void Delete(int empno) {
		rTemplate.delete(restUrls.DELETE_EMPLOYEE, empno);
	
	}

	
	

}
