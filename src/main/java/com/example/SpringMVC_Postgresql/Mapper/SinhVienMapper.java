package com.example.SpringMVC_Postgresql.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.SpringMVC_Postgresql.Model.SinhVienModel;

public class SinhVienMapper implements RowMapper<SinhVienModel>{

	@Override
	public SinhVienModel mapRow(ResultSet result, int rowNum) throws SQLException {
		SinhVienModel sinhVienModel = new SinhVienModel();
		
		sinhVienModel.setIdStudent(result.getString("idstudent"));
		sinhVienModel.setFullName(result.getString("fullname"));
		
		return sinhVienModel;
	}

}
