package com.example.RestApiDemo10.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApiDemo10.model.EmployeeModel;
import com.example.RestApiDemo10.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//http://localhost:9090/api/v1/inserted
	
	@PostMapping("/inserted")
	public String insertedData(@RequestBody EmployeeModel employeeModel) {
		employeeRepository.save(employeeModel);
		return "Data Inserted Successfuly";
	}
	
	//http://localhost:9090/api/v1/employees
	@GetMapping("/employees")
	public Collection<EmployeeModel> getAllEmployees(){
		
		return employeeRepository.findAll();
		
	}
	//http://localhost:9090/api/v1/employee/2
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id")Long studentid)
	throws ResourseNotFoundException{
		EmployeeModel employeeModel=employeeRepository.findById(studentid).orElseThrow(()->new ResourseNotFoundException("Resourse Not Found For This Id "+studentid));
		return ResponseEntity.ok().body(employeeModel);
		
	}
	
	//http://localhost:9090/api/v1/employee/1
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeModel> updateData(@PathVariable(value="id")Long studentid,@RequestBody EmployeeModel em)throws ResourseNotFoundException{
		EmployeeModel employeeModel=employeeRepository.findById(studentid).orElseThrow(()->new ResourseNotFoundException("Resourse Not Found For this Id "+studentid));
		employeeModel.setId(em.getId());
		employeeModel.setName(em.getName());
		employeeModel.setSalary(em.getSalary());
		EmployeeModel employee=employeeRepository.save(employeeModel);
		return ResponseEntity.ok().body(employee);
		
		
	}
			//http://localhost:9090/api/v1/update/5
		@PatchMapping("update/{id}")
		public ResponseEntity<EmployeeModel> updateDataByOneColumn(@RequestParam ("id") Long id , @RequestBody EmployeeModel emp  )
		throws ResourseNotFoundException{
			EmployeeModel employeeModel = employeeRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Resourse Not FOund For this id "+id));
			if(emp.getId()!=0 && emp.getName()!=null && emp.getSalary()!=0.0) {
				employeeModel.setId(emp.getId());
				employeeModel.setName(emp.getName());
				employeeModel.setSalary(emp.getSalary());
			}
			EmployeeModel employee=employeeRepository.save(employeeModel);
			
			return ResponseEntity.status(HttpStatus.OK).body(employee);
			
	}
	//http://localhost:9090/api/v1/employee/4
	
	@DeleteMapping("/employee/{id}")
	public Map<String,Boolean> deleteData(@PathVariable(value="id")Long studentid)throws ResourseNotFoundException{
		EmployeeModel employeeModel=employeeRepository.findById(studentid).orElseThrow(()->new ResourseNotFoundException("Resourse Not Found For this Id "+studentid));
		employeeRepository.delete(employeeModel);
		Map<String ,Boolean> message=new HashMap<>();
		message.put("Data Deleted successfully", true);
		return message;
		
	}
}
