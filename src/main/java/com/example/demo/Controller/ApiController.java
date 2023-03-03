package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Child;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController 
{
	@Autowired
	ApiService a;
	
	@PostMapping("/post")
	public Child addDetails(@RequestBody Child e)
	{
		return a.add(e);
	}
	@GetMapping("/get")
	public List<Child> getDetails()
	{
		return a.display();
	}
	@GetMapping("/sort/{field}")
	public List<Child> sortDetails(@PathVariable String field)
	{
		return a.sort(field);
	}
	@GetMapping("/pagin/{Offset}/{PageSize}")
	public List<Child> pagination(@PathVariable int Offset,@PathVariable int PageSize)
	{
		return a.Pagin(Offset, PageSize);
	}
	
}
