package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.model.Morido;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/moridos")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Morido> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("moridos", theCustomers);
		
		return "list-moridos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Morido theCustomer = new Morido();
		
		theModel.addAttribute("moridos", theCustomer);
		
		return "moridos-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("moridos") Morido theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return "redirect:/moridos/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("moridosId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Morido theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("moridos", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("moridosId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/moridos/list";
	}
}










