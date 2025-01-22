package com.techwave.demoClient.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

	@RequestMapping("/Extract")
	public String Extract()
	{
		return "extract";
	}
	@RequestMapping("/ExtractAll")
	public String ExtractAll()
	{
		return "extractall";
	}
}
