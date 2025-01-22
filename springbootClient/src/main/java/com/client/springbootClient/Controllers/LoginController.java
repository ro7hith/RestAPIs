package com.client.springbootClient.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.springbootClient.Models.Pojo.Login;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@RequestMapping("/Login")
	public String Login(Model M) {
		M.addAttribute("login", new Login());
		return "Login";
	}
	@RequestMapping("/ValidateLogin")
	public String ValidateLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		String S=loginConnect
	}
}
