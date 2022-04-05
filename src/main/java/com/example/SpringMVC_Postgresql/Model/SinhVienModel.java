package com.example.SpringMVC_Postgresql.Model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SinhVienModel {
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Student may not be null")
	private String idStudent;
	
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Name may not be null")
	private String fullName;
	
	public SinhVienModel() {
		super();
	}

	public SinhVienModel(String idStudent, String fullName) {
		super();
		this.idStudent = idStudent;
		this.fullName = fullName;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
