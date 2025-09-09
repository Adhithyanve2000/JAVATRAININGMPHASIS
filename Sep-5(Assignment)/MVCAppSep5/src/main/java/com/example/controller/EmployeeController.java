package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.enitty.Employee;
import com.example.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService empServ;

	@GetMapping("/addForm")
	public String EmployeeForm(Model model) {

		Employee emp = new Employee();
		model.addAttribute("emp", emp);

		return "add-emp-form";
	}

	
	@PostMapping("/addEmpResp")
	public String addEmployee(Model model, @ModelAttribute Employee emp) {
		
		Employee newEmp = empServ.addEmployee(emp);
		model.addAttribute("employee", newEmp);
        return "redirect:all";
	
	}

	
	@GetMapping("/all")
	public String getAllEmployees(Model model) {
	
		List<Employee> empList = empServ.getAllEmployees();

	
		model.addAttribute("empList", empList);
		System.out.println(empList);
		return "empList";

	};

	@RequestMapping(value = "/deleteEmpById/{id}", method = RequestMethod.GET)
	public String deleteEmpById(@PathVariable("id") int empId) {
		System.out.println("empId: " + empId);

		
		empServ.deleteEmployeeById(empId);

		
		return "redirect:/employee/all";
	}

	
	@RequestMapping("/updateEmpForm/{id}")
	public String updateEmployeeForm(@PathVariable("id") int empId, Model model) {

		Employee employee = empServ.getEmpById(empId);
		System.out.println("employee: " + employee);

	
		model.addAttribute("emp", employee);

		return "update-emp-form";
	}

	
	@PostMapping("/updateEmpResp")
	public String updateEmployee(Model model, @ModelAttribute Employee emp) {
	    Employee updatedEmp = empServ.updateEmployee(emp);
	    model.addAttribute("emp", updatedEmp);
	    return "redirect:all";
	}

}