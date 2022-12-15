package com.springboot.moridosSAdeCV.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.moridosSAdeCV.entity.Morido;
import com.springboot.moridosSAdeCV.service.MoridoService;

@RestController
@RequestMapping("/rest")
public class MoridoRestController {

	private MoridoService employeeService;
	
	@Autowired
	public MoridoRestController(MoridoService theMoridoService) {
		employeeService = theMoridoService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/moridos")
	public List<Morido> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/moridos/{moridoId}")
	public Morido getMorido(@PathVariable int moridoId) throws Exception {
		
		Morido theEmployee = employeeService.findById(moridoId);
		
		if (theEmployee == null) {
			throw new Exception("Employee id not found - " + moridoId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/moridos")
	public Morido addMorido(@RequestBody Morido theMorido) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		employeeService.save(theMorido);
		
		return theMorido;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/moridos")
	public Morido updateMorido(@RequestBody Morido theMorido) {
		
		employeeService.save(theMorido);
		
		return theMorido;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/moridos/{moridoId}")
	public String deleteMorido(@PathVariable int moridoId) {
		
		Morido tempEmployee = employeeService.findById(moridoId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + moridoId);
		}
		
		employeeService.deleteById(moridoId);
		
		return "Deleted employee id - " + moridoId;
	}
	
}










