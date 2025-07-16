package com.manytomany.model;



import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {
    private Long id;
    private String name;
    private Set<SpecializationDto> specializations;

    // Constructors
    
}
