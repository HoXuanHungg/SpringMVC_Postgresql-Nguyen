package com.example.SpringMVC_Postgresql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringMVC_Postgresql.DAO.SinhVienDAO;
import com.example.SpringMVC_Postgresql.Mapper.SinhVienMapper;
import com.example.SpringMVC_Postgresql.Model.SinhVienModel;

@Service
@Transactional
public class SinhVienService {
	
	@Autowired
	private SinhVienDAO sinhVienDAO;
	
	public List<SinhVienModel> listAllStudent(){
		List<SinhVienModel> listStudent = sinhVienDAO.listAllStudent();
		return listStudent; 
	}
	
	public int statistical() {
		int sum = 0;
		sum = sinhVienDAO.statistical();
		return sum;
	}
	
	public void saveStudent(SinhVienModel sinhVienModel) {
		sinhVienDAO.saveStudent(sinhVienModel);
	}
	
	public void updateStudent(SinhVienModel sinhVienModel) {
		sinhVienDAO.updateStudent(sinhVienModel);
	}
	
	public void deleteStudent(String idStudent) {
		sinhVienDAO.deleteStudent(idStudent);
	}
	
	public int checkIdStudent(String idStudent) {
		int number = 0;
		number = sinhVienDAO.CheckIdStudent(idStudent);
		return number;
	}
	
	public SinhVienModel deltailStudent(String idStudent) {
		return sinhVienDAO.findByIdStudent(idStudent);
	}
}
