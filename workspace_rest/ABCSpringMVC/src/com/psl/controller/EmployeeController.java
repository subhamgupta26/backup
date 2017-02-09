package com.psl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//http://localhost:8080/ABCSpringMVC/home
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.psl.bean.Employee;

@Controller
@RequestMapping(value="/emp")
public class EmployeeController {
	
	private EmployeeService service;
	

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showHomePage(Model model){
		System.out.println("hi in controllers home page");
		Employee e=new Employee();
		model.addAttribute("employee", e);
		return "home";
	}
	
	@RequestMapping(value="/{empName}",method=RequestMethod.GET)
	public String showEmpPage(@PathVariable String empName,@RequestParam(value="addr") String addr,@RequestParam String dept){
		System.out.println("show emp page "+ empName+" from dept "+dept+" lives in "+ addr);
		return "emp";
	}

	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String register(Employee e){
		System.out.println("hi in controllers home page"+e.getName() );
		return "home";
	}
	
	
}
