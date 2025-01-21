package com.techwave.restapidemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.restapidemo.models.dao.Services.IRestEmp;
import com.techwave.restapidemo.models.pojo.RestEmp;

@RestController
@CrossOrigin
public class RestEmpController {
	@Autowired
	IRestEmp restDao; 
	@PostMapping("/InsertEmp")
	public String InsertEmp(@RequestBody RestEmp E)
	{
		return restDao.InsertEmp(E);
	}
	@GetMapping("/fetchall")
	public ResponseEntity<Object> getall()
	{
		List<RestEmp>list=  restDao.GetAll();
		if(list.size()!=0)
		{
			return ResponseEntity.of(Optional.of(list));
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records found");
	}
	@GetMapping("/fetchall/{id}")
	public ResponseEntity<Object> getall(@PathVariable("id")int empno)
	{
		RestEmp R = restDao.GetById(empno);
		if(R!=null) {
			return ResponseEntity.of(Optional.of(R));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("No record found with"+empno);
		}
		
	}
	@PutMapping("/Updateemp/{id}")
	public ResponseEntity<Object> updatemp(@RequestBody RestEmp E,@PathVariable("id") int empno)
	{	
		try {
		RestEmp R= restDao.UpdateEmp(E, empno);
		if(R!=null) {
			return ResponseEntity.of(Optional.of(R));
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records found with"+empno+"to update");
		}
		}catch(DataIntegrityViolationException Ex) {
			if(Ex.getMessage().contains("CHK_SAL"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sal > 5000");
			if(Ex.getMessage().contains("UK9BE1PY45M9YD9NDCMITEHBRS9"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email must be unique");
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Ex.getMessage());
		}
	}
	@DeleteMapping("/Deleteemp/{id}")
	public ResponseEntity<String> DeleteEmp(@PathVariable("id") int empno) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restDao.DeleteEmp(empno));
	}
}
