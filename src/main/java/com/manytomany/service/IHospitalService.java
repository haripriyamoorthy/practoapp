package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Hospital;
import com.manytomany.model.HospitalDto;
import com.manytomany.model.Speciality;

public interface IHospitalService {
	 void addHospital(HospitalDto hospitalDto);
	    void  updateHospital( HospitalDto hospitalDto);
	    void deleteHospital(int hospitalId);
	    List<Hospital> findByCategory(String category);
	    List<Hospital> findByLocation(String location);
	    List<Hospital> findHospitalsByDoctorName(String doctorName);

	    List<Hospital> findHospitalsBySpeciality(Speciality speciality);

	  
	    List<Hospital> findHospitalsWithExperiencedDoctors(int years);

	}



