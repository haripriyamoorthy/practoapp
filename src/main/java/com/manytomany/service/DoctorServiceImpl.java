package com.manytomany.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.manytomany.Exceptions.ResourceNotFoundException;
import com.manytomany.Repository.IDoctorRepository;
import com.manytomany.Repository.ISpecializationRepository;
import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;
import com.manytomany.model.Specialization;
import com.manytomany.model.SpecializationDto;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {
    private final IDoctorRepository doctorRepository;
    private final ISpecializationRepository specializationRepository;
    @Autowired
	private ModelMapper mapper;

    public DoctorServiceImpl(IDoctorRepository doctorRepository, ISpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
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
	public DoctorDto assignSpecialization(Long doctorId, Long specializationId) {
		// TODO Auto-generated method stub
		 Doctor doctor = doctorRepository.findById(doctorId)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));

	        
			 return mapper.map(doctor, DoctorDto.class);
			// return mapper.map(specialization, SpecializationDto.class);
			 

		
	}

   
}

