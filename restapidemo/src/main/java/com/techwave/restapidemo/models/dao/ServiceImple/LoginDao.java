package com.techwave.restapidemo.models.dao.ServiceImple;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techwave.restapidemo.models.dao.Services.ILogin;
import com.techwave.restapidemo.models.pojo.RestLogin;
import com.techwave.restapidemo.models.repositories.ILoginRepository;
@Service
public class LoginDao implements ILogin{
@Autowired
ILoginRepository loginrepository;
@Autowired
PasswordEncoder passwordEncoder;
	@Override
	public String InsertUser(RestLogin R) {
		String pencode=passwordEncoder.encode(R.getPassword());
		R.setPassword(pencode);
		loginrepository.save(R);
		return "1 record Inserted";
	}

	@Override
	public int ValidateUser(String user, String Password) {
		try {
		RestLogin R=loginrepository.findById(user).get();
		boolean B =passwordEncoder.matches(Password, R.getPassword());
		if(B) {
		return 1;//User and password both are correct
		}
		else {
			return 2; //User correct and password Incorrect
		}
		}
		catch(NoSuchElementException e) {
			return 3;//when no user 
		}
	}

	@Override
	public List<RestLogin> fetchAllUsers() {
		// TODO Auto-generated method stub
		return loginrepository.findAll();
	}

}
