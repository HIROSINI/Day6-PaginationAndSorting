package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ApiService 
{
	@Autowired
	ChildRepo c;
	
	public Child add(Child c1)
	{
		return c.save(c1);
	}
	public List<Child> display()
	{
		return c.findAll();
	}
	public List<Child> sort(String field)
	{
		return c.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Child> Pagin(@PathVariable int Offset,@PathVariable int PageSize)
	{
		Page<Child> page=c.findAll(PageRequest.of(Offset, PageSize));
		return page.getContent();
	}
}
