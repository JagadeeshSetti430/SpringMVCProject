package com.ccp.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccp.entity.Employee;
import com.ccp.service.ISerivceRepo;

@Controller
public class EmpController {
	@Autowired
	private ISerivceRepo empService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
		
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map){
		Iterable<Employee> itEmps=empService.getAllEmployees();
		 map.put("empList", itEmps);
		 
		 return "show_employee_report";
	}
	
	@GetMapping("/emp_add")
	public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp) {
		return "register_employee";
	}
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,
			Map<String, Object> map) {
		String msg=empService.addEmployee(emp);	
		Iterable<Employee> itEmps=empService.getAllEmployees();
		map.put("resultMsg", msg);
		map.put("empList", itEmps);		
		return "show_employee_report";
		
	}
	@GetMapping("/emp_edit")
	public String showEditEmployee(@RequestParam("no")int no, @ModelAttribute("emp") Employee emp) {
		 Employee emp1=empService.getEmployeeByNo(no);		 
		 BeanUtils.copyProperties(emp1, emp);
		  return "update_employee";
	}
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		String msg=empService.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:emp_report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no) {
		String msg=empService.deleteEmlpoyeeById(no);
		attrs.addFlashAttribute("result",msg);
		return "redirect:emp_report";
}}
