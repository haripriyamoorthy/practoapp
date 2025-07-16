package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;

public interface IDoctorService {

   
    List<DoctorDto> getAllDoctors();

    DoctorDto assignSpecialization(Long doctorId, Long specializationId);

	void addDoctor(DoctorDto doctorDto);
}
