package com.manytomany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manytomany.model.DoctorDto;
import com.manytomany.model.SpecializationDto;
import com.manytomany.model.field;
import com.manytomany.service.IDoctorService;
import com.manytomany.service.ISpecializationService;

@SpringBootApplication
public class SpringManytomanyPractoJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringManytomanyPractoJpaApplication.class, args);
	}
	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private ISpecializationService SpecializationService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SpecializationDto Specializations= new SpecializationDto(null,field.CARDIOLOGIST);
		SpecializationDto Specializations2= new SpecializationDto(null,field.DERMATOLOGIST);
		SpecializationDto Specializations3= new SpecializationDto(null,field.NEUROLOGIST);
		
		Set<SpecializationDto> Specialization1 = new HashSet<>(Arrays.asList(Specializations,Specializations2,Specializations3));
		
		DoctorDto doctors= new DoctorDto(null,"Simran",Specialization1);
		doctorService.addDoctor(doctors);
	}

}
