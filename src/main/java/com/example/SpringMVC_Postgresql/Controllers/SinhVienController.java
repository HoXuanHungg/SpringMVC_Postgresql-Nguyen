package com.example.SpringMVC_Postgresql.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringMVC_Postgresql.Model.SinhVienModel;
import com.example.SpringMVC_Postgresql.Service.SinhVienService;

@Controller
public class SinhVienController {
	@Autowired	
	private SinhVienService sinhVienService;
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		model.addAttribute("student_save", new SinhVienModel());
		model.addAttribute("listStudents", sinhVienService.listAllStudent());
		// thong ke sinh vien		
		model.addAttribute("statistical", sinhVienService.statistical());
		return "index";
	}
	
	@RequestMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student_save") @Validated SinhVienModel sinhVienModel, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("listStudents", sinhVienService.listAllStudent());
			// thong ke sinh vien		
			model.addAttribute("statistical", sinhVienService.statistical());
			return "index";
		}
		
		sinhVienService.saveStudent(sinhVienModel);
		model.addAttribute("listStudents", sinhVienService.listAllStudent());
		return "redirect:/";
	}
	
	@RequestMapping("/deleteStudent/{idStudent}")
	public String deleteStudent(@PathVariable String idStudent, Model model) {
		sinhVienService.deleteStudent(idStudent);
		model.addAttribute("listStudents", sinhVienService.listAllStudent());
		return "redirect:/";
	}
	
	@RequestMapping("/updateStudent/{idStudent}")
	public String showUpdate(@PathVariable String idStudent, Model model) {
		SinhVienModel detailStudent = sinhVienService.deltailStudent(idStudent);
		model.addAttribute("student_update", new SinhVienModel());
		model.addAttribute("detailStudent", detailStudent);
		return "updateStudent";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student_update") @Valid SinhVienModel sinhVienModel, Model model) {
		sinhVienService.updateStudent(sinhVienModel);
		return "redirect:/";
	}
}
