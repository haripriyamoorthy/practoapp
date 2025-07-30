package com.manytomany.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;
import com.manytomany.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {
    private final IDoctorRepository doctorRepository;
    
    @Autowired
	private ModelMapper mapper;

    public DoctorServiceImpl(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        
    }

	@Override
	public void addDoctor(DoctorDto doctorDto) {
		// TODO Auto-generated method stub
		Doctor doctor = mapper.map(doctorDto,Doctor.class);
		doctorRepository.save(doctor);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll()
				.stream()
				.map(doctor->mapper.map(doctor,DoctorDto.class))
				.toList();
	}

	

		
	

	@Override
	public List<DoctorDto> findByname(String name) {
		// TODO Auto-generated method stub
		return doctorRepository.findByname(name);
	}

	@Override
	public List<DoctorDto>  getDoctorById(Integer doctorId) {
		// TODO Auto-generated method stub
		return doctorRepository.getDoctorById(doctorId);
	}

	

	

	

   
}

