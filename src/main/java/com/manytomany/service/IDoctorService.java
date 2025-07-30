package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;

public interface IDoctorService {

   
    List<DoctorDto> getAllDoctors();

   
	void addDoctor(DoctorDto doctorDto);
	


	List<DoctorDto> findByname(String name);


	List<DoctorDto> getDoctorById(Integer doctorId);
	

	
}
