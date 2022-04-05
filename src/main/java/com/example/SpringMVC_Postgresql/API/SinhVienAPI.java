package com.example.SpringMVC_Postgresql.API;

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

import com.example.SpringMVC_Postgresql.Model.SinhVienModel;
import com.example.SpringMVC_Postgresql.Service.SinhVienService;

@RestController
@RequestMapping("/api")
public class SinhVienAPI {
	
	@Autowired
	private SinhVienService sinhVienService;
	
	//	Thong ke sinh vien
	@GetMapping("/statistical")
	public int statistical() {
		return sinhVienService.statistical();
	}
	
	@GetMapping("/listAllStudent")
	public List<SinhVienModel> listAllStudent(){
		return (List<SinhVienModel>) sinhVienService.listAllStudent();
	}
	
	@PostMapping("/saveStudent")
	public void saveStudent(@RequestBody SinhVienModel sinhVienModel) {
		sinhVienService.saveStudent(sinhVienModel);
	}
	
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody SinhVienModel sinhVienModel) {
		sinhVienService.updateStudent(sinhVienModel);
	}
	
	@DeleteMapping("deleteStudent/{idStudent}")
	public void deleteStudent(@PathVariable String idStudent) {
		sinhVienService.deleteStudent(idStudent);
	}
	
	@GetMapping("/checkIdStudent/{idStudent}")
	public int checkIdStudent(@PathVariable String idStudent) {
		return sinhVienService.checkIdStudent(idStudent);
	}
}
