package com.example.SpringMVC_Postgresql.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringMVC_Postgresql.Mapper.SinhVienMapper;
import com.example.SpringMVC_Postgresql.Model.SinhVienModel;

@Repository
@Transactional
public class SinhVienDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<SinhVienModel> listAllStudent(){
		String sql = "SELECT * FROM thongtinsinhvien";
	    return jdbcTemplate.query(sql, new SinhVienMapper());
	}
	
	public void saveStudent(SinhVienModel sinhVienModel) {
		if(CheckIdStudent(sinhVienModel.getIdStudent()) == 0) {
			String sql = "insert into thongtinsinhvien (idstudent, fullname) values (?, ?)";
			jdbcTemplate.update(sql, sinhVienModel.getIdStudent(), sinhVienModel.getFullName());
		}
	}
	
	public void deleteStudent(String idStudent) {
		String sql = "delete from thongtinsinhvien where idstudent = ?";
		jdbcTemplate.update(sql, idStudent);		
	}
	
	public void updateStudent(SinhVienModel sinhVienModel) {
		String sql = "update thongtinsinhvien set fullname = ? where idstudent = ?";
		jdbcTemplate.update(sql, sinhVienModel.getFullName(), sinhVienModel.getIdStudent());
	}
	
	public List<SinhVienModel> findAll(String search){
		String sql = "select * from thongtinsinhvien where idstudent like '%" + search +"%' or fullname like '%" + search +"%'";
		return jdbcTemplate.query(sql, new SinhVienMapper());
	}
	
	public SinhVienModel findByIdStudent(String idStudent) {
		String sql = "select * from thongtinsinhvien where idstudent = ?";
		return jdbcTemplate.queryForObject(sql, new SinhVienMapper(), idStudent);
	}
	
	public int CheckIdStudent(String idStudent) {
		int number = 0;
		
		String sql = "select count(*) as sum from thongtinsinhvien where idstudent = '" + idStudent + "'";
		number = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return number;
	}
	
	//	Thong ke so luong sinh vien
	public int statistical() {
		int sum = 0;
		
		String sql = "select count(idstudent) as sum from thongtinsinhvien";
		sum = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return sum;
	}
}
