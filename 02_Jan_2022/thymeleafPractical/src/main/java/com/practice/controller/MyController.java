package com.practice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		try {
			System.out.println("inside about handler");
			model.addAttribute("name", "Rohit");
			model.addAttribute("date", new Date().toLocaleString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "about";
		// about.html
	}

//	this is for handling iteration
	@GetMapping("/example-loop")
	public String iteratHendler(Model m) {
		List<String> names = List.of("Rohit", "Ankit", "Sajan");
		m.addAttribute("names", names);
		return "iterat";
	}

//	handler for condition
	@GetMapping("/condition")
	public String contionalHandler(Model m)
	{
		System.out.println("condition handler");
		m.addAttribute("isActive",true);
		m.addAttribute("Gender","F");
		List<Integer> list = List.of(25,26,548,5,85,65,225,52);
		m.addAttribute("myList",list);
		return "condition";
	}
	
	
//	handler for including fragment
	@GetMapping("/service")
	public String serviceHandler(Model m)
	{
		m.addAttribute("title","title from controller");
		m.addAttribute("subtitle","subtitle from controller");
		return "service";
	}

//	handler for aboutnew
	@GetMapping("/newabout")
	public String newabout(Model m)
	{
		
		return "aboutnew";
	}
	
//	handler for contact
	@GetMapping("/contact")
	public String contact(Model m)
	{
		
		return "contant";
	}
	
}
