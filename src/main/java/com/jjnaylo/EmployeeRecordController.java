package com.jjnaylo;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class EmployeeRecordController {

	@Autowired
	EmployeeRecordRepository employeeRecordRepository;
	
	@GetMapping("/employees")
	public List<EmployeeRecord> getAllEmployees() {
		Sort sortByLastName = new Sort(Sort.Direction.DESC, "lastName");
		return employeeRecordRepository.findAll(sortByLastName);
	}
	
	@PostMapping("/employees")
	public EmployeeRecord createEmployee(@Valid @RequestBody EmployeeRecord employee) {
		employee.setActive(true);
		return employeeRecordRepository.save(employee);
	}
	
	@GetMapping(value="/employees/{id}")
	public ResponseEntity<EmployeeRecord> getEmployeeById(@PathVariable("id") String id){
		EmployeeRecord employee = employeeRecordRepository.findOne(id);
		if(employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/employees/{id}")
	public ResponseEntity<EmployeeRecord> updateEmployeeRecord(@PathVariable("id") String id,
															   @Valid @RequestBody EmployeeRecord employee){
		EmployeeRecord employeeData = employeeRecordRepository.findOne(id);
		if(employeeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		EmployeeRecord updatedEmployee = employeeRecordRepository.save(employeeData);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/employees/{id}")
	public void deleteEmployee(@PathVariable("id") String id) {
		employeeRecordRepository.delete(id);
	}
	
}
