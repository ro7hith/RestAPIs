package com.client.springbootClient.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import com.client.springbootClient.Models.Dao.Services.IEmployee;
import com.client.springbootClient.Models.Pojo.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ClientController {

	@Autowired
	IEmployee empConnect;

	@RequestMapping("/Extract")
	public String Extract() {
		return "Extract";
	}

	@RequestMapping("fetchAll")
	public String fetchAll(Model M) {
		try {
			Employee[] E = empConnect.GetAllEmps();
			M.addAttribute("Earray", E);
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("msg", Ex.getResponseBodyAsString());
		}

		return "Extract";

	}

	@RequestMapping("/ExtractById")
	public String ExtractById() {
		return "ExtractById";
	}

	@RequestMapping("/fetchById")
	public String fetchById(@RequestParam("empno") int empno, Model M) {
		try {
			Employee E = empConnect.GetById(empno);
			M.addAttribute("employee", E);
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("msg", Ex.getResponseBodyAsString());
		}
		return "ExtractById";
	}

	@RequestMapping("Insert")
	public String Insert(Model M) {
		M.addAttribute("employee", new Employee());
		return "Insert";
	}

	@RequestMapping("InsertEmp")
	public String InsertEmp(@Valid @ModelAttribute("employee") Employee E, BindingResult Bs, Model M) {
		String msg = "";
		try {
			if (Bs.hasErrors())
				return "Insert";
			else {
				msg = empConnect.Insert(E);
				M.addAttribute("msg", msg);
			}
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("msg", Ex.getResponseBodyAsString());

		}
		return "Insert";

	}

	@RequestMapping("Update")
	public String Update(Model M) {
		M.addAttribute("employee", new Employee());

		return "update";
	}

	@RequestMapping("UpdateEmp")
	public String UpdateEmp(@Valid @ModelAttribute("employee") Employee E, BindingResult bs, Model M) {
		try {
			if (bs.hasErrors())
				return "update";
			else {

				Employee emp = empConnect.Update(E);
				M.addAttribute("employee", emp);
			}
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("msg", Ex.getResponseBodyAsString());
		}
		return "update";
	}

@RequestMapping("DeleteEmp")
	public String DeleteEmp(@RequestParam("empno")int empno,Model  M) {
		try {
			M.addAttribute("employee", new Employee());

				empConnect.Delete(empno);
				M.addAttribute("msg","Record deleted ");
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("msg", Ex.getResponseBodyAsString());
		}
		return "update";
	}

	@RequestMapping("/fetchByEmpId")
	public String fetchByEmpId(@RequestParam("empno") int empno, Model M) {
		try {
			Employee E = empConnect.GetById(empno);
			M.addAttribute("employee", E);
		} catch (HttpServerErrorException Ex) {
			M.addAttribute("employee", new Employee());
			M.addAttribute("msg", Ex.getResponseBodyAsString());
		
		}
		return "update";
	}

}
