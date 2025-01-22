package com.client.springbootClient.Models.Dao.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.client.springbootClient.Models.Dao.Services.ILogin;

public class LoginConnect implements ILogin {

	@Autowired
	RestTemplate rTemplate;
	
	
	@Override
	public String Validate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
