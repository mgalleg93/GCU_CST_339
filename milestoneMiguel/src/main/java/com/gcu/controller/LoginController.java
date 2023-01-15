package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.RegistrationModel;

import business.OrdersBusinessInterface;
import business.SecurityBusinessService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private OrdersBusinessInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
	}
	
	@GetMapping("/home")
	public String displayHome(Model model) {
		model.addAttribute("title", "Home Page");
        return "home";
	}
	
	@GetMapping("/register")
    public String displayRegistration(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }
	
	@PostMapping("/doRegistration")
	public String doLogin(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("From with Username of %s and Password of %s", registrationModel.getUsername(), registrationModel.getPassword()));
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
	        return "register";
		}
		
		//Create some orders
		//List<OrderModel> orders = service.getOrders();
		model.addAttribute("title", "Home Page");
		//model.addAttribute("orders", orders);
		
		return "home";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("From with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
	        return "login";
		}
		
		//Create some orders
		//List<OrderModel> orders = service.getOrders();
		model.addAttribute("title", "Home Page");
		//model.addAttribute("orders",orders);
		
		return "home";
	}
}