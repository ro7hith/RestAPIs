package com.techwave.restapidemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController 
{
	List<String> list=null;
	public SampleController()
	{
		list=new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
	}
	@GetMapping("/getall")
	public List<String> getAll()
	{
		return list;
	}
	@GetMapping("/getall/{id}")
	public String getAll(@PathVariable("id") int id)
	{
		return list.get(id);
	}
	@PostMapping("/add")
	public String add(@RequestBody String s)
	{
		list.add(s);
		return "1 string added";
	}
	@PutMapping("/change/{id}")
	public String Change(@RequestBody String s,@PathVariable("id") int id)
	{
		list.set(id, s);
		return "String updated";
	}
	@DeleteMapping("/delete/{id}")
	public String Delete(@PathVariable("id") int id)
	{
		list.remove(id);
		return "String deleted";
	}
	
}
