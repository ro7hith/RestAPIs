package com.techwave.restapidemo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.restapidemo.models.pojo.Emp;

@RestController
public class EmpController {
	List<Emp> list = null;

	public EmpController() {
		list = new ArrayList<Emp>();
		list.add(new Emp(10, "A", 30000, LocalDate.parse("2001-09-04")));
		list.add(new Emp(20, "B", 40000, LocalDate.parse("2000-09-04")));
		list.add(new Emp(30, "C", 50000, LocalDate.parse("2002-08-24")));
		list.add(new Emp(40, "D", 60000, LocalDate.parse("2001-07-14")));
	}

	@GetMapping("/getAllEmps")
	public List<Emp> getAllEmps() {
		return list;
	}
	@GetMapping("/getAllEmps/{id}")
	public Emp getAllEmps(@PathVariable("id") int id) {
		return list.stream().filter(i->i.getEmpno()==id).collect(Collectors.toList()).get(0);
	}
	@PostMapping("/insert")
	public String Insert(@RequestBody Emp E)
	{
		list.add(E);
		return "inserted";
	}
	@PutMapping("/update/{id}")
	public Emp update(@RequestBody Emp E,@PathVariable("id") int id)
	{
		Emp old=list.stream().filter(i->i.getEmpno()==id).collect(Collectors.toList()).get(0);
	//	System.out.println(old);
		old.setEname(E.getEname());
		old.setSal(E.getSal());
		old.setDob(E.getDob());
		return old;
	
	}
	@DeleteMapping("/deleteEmp/{id}")
	public String delete(@PathVariable int id)
	{
		Emp old=list.stream().filter(i->i.getEmpno()==id).collect(Collectors.toList()).get(0);
		System.out.println(old);
		list.remove(old);
		return "Deleted";
	}
	
}
