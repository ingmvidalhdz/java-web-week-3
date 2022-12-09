package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Products;
import com.luv2code.springdemo.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

	// need to inject our customer service
	@Autowired
	private ProductsService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Products> theProducts = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("products", theProducts);
		
		return "list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Products theProducts = new Products();
		
		theModel.addAttribute("products", theProducts);
		
		return "products-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("products") Products theProduct) {
		
		// save the customer using our service
		customerService.saveCustomer(theProduct);	
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productsId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Products theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("products", theCustomer);
		
		// send over to our form		
		return "products-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("productsId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/products/list";
	}
}










