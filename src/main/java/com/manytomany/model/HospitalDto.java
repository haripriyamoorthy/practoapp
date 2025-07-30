package com.manytomany.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HospitalDto {
	
	 private Integer hospitalId;
	
	 private String hospitalName;
	
	 private String location;
	
	 private String category;

	
	 private List<Doctor> doctors;
	
	   
	}
	


