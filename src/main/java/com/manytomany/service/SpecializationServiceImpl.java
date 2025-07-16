package com.manytomany.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.Exceptions.ResourceNotFoundException;
import com.manytomany.Repository.ISpecializationRepository;

import com.manytomany.model.Specialization;
import com.manytomany.model.SpecializationDto;
@Service
public class SpecializationServiceImpl implements ISpecializationService{
	 @Autowired
		private ModelMapper mapper;

	  private final ISpecializationRepository specializationRepository;

	    public SpecializationServiceImpl(ISpecializationRepository specializationRepository) {
	        this.specializationRepository = specializationRepository;
	    }

	@Override
	public void addSpecialization(SpecializationDto specializationDto) {
		// TODO Auto-generated method stub
		Specialization spec = mapper.map(specializationDto,Specialization.class);
		specializationRepository.save(spec);
	}

	@Override
	public List<SpecializationDto> getAllSpecializations() {
		// TODO Auto-generated method stub
		return specializationRepository.findAll()
				.stream()
				.map(specialization->mapper.map(specialization,SpecializationDto.class))
				.toList();
	}

	@Override
	public SpecializationDto getSpecializationById(Long id) {
		// TODO Auto-generated method stub
		Specialization specializations = specializationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specialization not found with id: " + id));
		return mapper.map(specializations, SpecializationDto.class);
	}

}



