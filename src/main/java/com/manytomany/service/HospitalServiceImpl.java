package com.manytomany.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.manytomany.model.Hospital;
import com.manytomany.model.HospitalDto;
import com.manytomany.model.Speciality;
import com.manytomany.repository.IHospitalRepository;

public class HospitalServiceImpl implements IHospitalService{

	private  IHospitalRepository hospitalRepository;
    public HospitalServiceImpl(IHospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    
    @Autowired
	private ModelMapper mapper;
	
	@Override
	public void addHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		hospitalRepository.save(hospital);
		
	}

	@Override
	public void updateHospital(HospitalDto hospitalDto) {
		Hospital hospital = mapper.map(hospitalDto, Hospital.class);
		hospitalRepository.save(hospital);
		
		
		
	}

	@Override
	public void deleteHospital(int hospitalId) {
		
		hospitalRepository.deleteById(hospitalId);
		
	}

	@Override
	public List<Hospital> findByCategory(String category) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByCategory(category);
	}

	@Override
	public List<Hospital> findByLocation(String location) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByLocation(location);
	}

	@Override
	public List<Hospital> findHospitalsByDoctorName(String doctorName) {
		// TODO Auto-generated method stub
		return hospitalRepository.findHospitalsByDoctorName(doctorName);
	}

	@Override
	public List<Hospital> findHospitalsBySpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return hospitalRepository.findHospitalsBySpeciality(speciality);
	}

	@Override
	public List<Hospital> findHospitalsWithExperiencedDoctors(int years) {
		// TODO Auto-generated method stub
		return hospitalRepository.findHospitalsWithExperiencedDoctors(years);
	}

}
