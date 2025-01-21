package com.techwave.restapidemo.models.dao.ServiceImple;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.techwave.restapidemo.models.dao.Services.IRestEmp;
import com.techwave.restapidemo.models.pojo.RestEmp;
import com.techwave.restapidemo.models.repositories.IEmpRepository;

@Service
public class RestEmpDao implements IRestEmp {
	@Autowired
	IEmpRepository empRepository;

	@Override
	public List<RestEmp> GetAll() {
		return empRepository.findAll();
	}

	@Override
	public RestEmp GetById(int empno) {
		try {
			return empRepository.findById(empno).get();
		}
		catch(NoSuchElementException Ex)
		{
			return null;
		}
	}
	@Override
	public String InsertEmp(RestEmp E) 
	{
		try {
		RestEmp RE=GetById(E.getEmpno());
		if(RE==null)
		{
		empRepository.save(E);
		return "Employee details added";
		}
		else
		{
			return "Employee details alrceady existing";
		}
		}
		catch(DataIntegrityViolationException Ex)
		{
			if(Ex.getMessage().contains("CHK_SAL"))
				return "Sal > 5000";
			if(Ex.getMessage().contains("UK9BE1PY45M9YD9NDCMITEHBRS9"))
				return "Email must be unique";
			else
				return Ex.getMessage();
		}
	}
	

	@Override
	public RestEmp UpdateEmp(RestEmp E, int empno) {
		// TODO Auto-generated method stub
		
		RestEmp R=GetById(empno);
		if(R!=null)
		{
		empRepository.save(E);
		return E;
		}
		else
		{
			return null;
		}
		}
		
		
		

	@Override
	public String DeleteEmp(int empno) {
		RestEmp R=GetById(empno);
		if(R!=null) {
		 empRepository.deleteById(empno);
		 return" record with empno"+empno+" deleted";
		}else
			return "No record Found with the given"+empno;
		
	}

}
