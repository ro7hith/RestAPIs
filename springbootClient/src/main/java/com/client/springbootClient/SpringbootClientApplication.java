package com.client.springbootClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.client.springbootClient.Models.Dao.ServiceImpl.EmployeeConnect;
import com.client.springbootClient.Models.Dao.ServiceImpl.LoginConnect;
import com.client.springbootClient.Models.Dao.Services.IEmployee;
import com.client.springbootClient.Models.Dao.Services.ILogin;

@SpringBootApplication
public class SpringbootClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootClientApplication.class, args);
	}

	@Bean
	public RestTemplate rTemplate() {
		return new RestTemplate();
	}
	@Bean 
	public IEmployee empConnect()
	{
		return new EmployeeConnect();
	}
	@Bean 
	public ILogin loginConnect()
	{
		return new LoginConnect();
	}
	
}
//RestTemplate rTemplate=new RestTemplate()

//IEmployee empConnect=new EmployeeConnect();