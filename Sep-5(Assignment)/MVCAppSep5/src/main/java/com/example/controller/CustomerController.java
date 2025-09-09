package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.enitty.Customer;
import com.example.enitty.Employee;
import com.example.service.CustomerServiceImpl;
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl cusServ;
	
	@GetMapping("/all")
	public String getAllEmployees(Model model) {
	
		List<Customer> cusList = cusServ.getAllCustomers();

	
		model.addAttribute("cusList", cusList);
		System.out.println(cusList);
		return "cusList";

	}
	
	@GetMapping("/addForm1")
	public String cusForm(Model model) {

		Customer cus = new Customer();
		model.addAttribute("cus", cus);

		return "add-cus-form";
	}
	
	@PostMapping("/addcusResp")
	public String addEmployee(Model model, @ModelAttribute Customer cus) {
		
		Customer ncus = cusServ.addCustomer(cus);
		model.addAttribute("customer", ncus);
        return "redirect:all";
	
	}
	@RequestMapping(value = "/deleteCusById/{id}", method = RequestMethod.GET)
	public String deletecusById(@PathVariable("id") int cusId) {
		System.out.println("cusId: " + cusId);

		
		cusServ.deleteCustomerById(cusId);

		
		return "redirect:/customer/all";
	}

	
	@RequestMapping("/updateCusForm/{id}")
	public String updateCustomerForm(@PathVariable("id") int cusId, Model model) {

	Customer cus = cusServ.getCusById(cusId);
		System.out.println("Customer: " + cus);

	
		model.addAttribute("cus", cus);

		return "update-cus-form";
	}
	
	@PostMapping("/updateCusResp")
	public String updateEmployee(Model model, @ModelAttribute Customer cus) {
	   Customer updcus= cusServ.updateCustomer(cus);
	    model.addAttribute("cus", updcus);
	    return "redirect:all";
	}



}
