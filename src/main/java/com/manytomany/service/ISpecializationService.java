package com.manytomany.service;



import com.manytomany.model.SpecializationDto;

import java.util.List;

public interface ISpecializationService {

    

    List<SpecializationDto> getAllSpecializations();

    SpecializationDto getSpecializationById(Long id);

	void addSpecialization(SpecializationDto specializationDto);
}
