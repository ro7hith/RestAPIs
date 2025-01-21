package com.techwave.restapidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.restapidemo.models.dao.Services.ILogin;
import com.techwave.restapidemo.models.pojo.RestLogin;

@RestController
public class LoginController {
	@Autowired
	ILogin loginDao;
@PostMapping("/InsertUser") 
public String InsertUser(@RequestBody RestLogin R) {
	return loginDao.InsertUser(R);
}
@GetMapping("/fetchUsers")
public List<RestLogin> fetchUser(){
	return loginDao.fetchAllUsers();
}
@GetMapping("/validate/{user}/{password}")
public String Validate(@PathVariable ("user") String user, @PathVariable("password") String password)
{
	int st=loginDao.ValidateUser(user, password);
		if(st==1)
		return "User Valid";
	else if(st==2) 
		return "Invalid Password";
	else
		return "Invalid User";
	}
	
}
