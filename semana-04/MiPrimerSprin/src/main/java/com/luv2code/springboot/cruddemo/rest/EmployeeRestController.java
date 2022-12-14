package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Morido;
import com.luv2code.springboot.cruddemo.service.MoridoService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	private MoridoService moridoService;
	
	@Autowired
	public EmployeeRestController(MoridoService theMoridoService) {
		moridoService = theMoridoService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/moridos")
	public List<Morido> findAll() {
		return moridoService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/moridos/{moridoId}")
	public Morido getEmployee(@PathVariable int moridoId) throws Exception {
		
		Morido theMorido = moridoService.findById(moridoId);
		
		if (theMorido == null) {
			throw new Exception("Morido id not found - " + moridoId);
		}
		
		return theMorido;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/moridos")
	public Morido addEmployee(@RequestBody Morido theMorido) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theMorido.setId(0);
		
		moridoService.save(theMorido);
		
		return theMorido;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/moridos")
	public Morido updateEmployee(@RequestBody Morido theMorido) {
		
		moridoService.save(theMorido);
		
		return theMorido;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/moridos/{moridoId}")
	public String deleteEmployee(@PathVariable int moridoId) {
		
		Morido tempMorido = moridoService.findById(moridoId);
		
		// throw exception if null
		
		if (tempMorido == null) {
			throw new RuntimeException("Morido id not found - " + moridoId);
		}
		
		moridoService.deleteById(moridoId);
		
		return "Deleted morido id - " + moridoId;
	}
	
}










