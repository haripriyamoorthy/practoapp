package com.manytomany.model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DoctorDto {
	
    private Integer doctorId;

    private String name;

    private int rating;

    private double fees;
	
    private String email;
	
    private int experience;

  
    private AddressDto address;

   
    private List<Speciality> Specialities;

   
    private List<HospitalDto> hospital;

   
    private List<AppointmentSlotDto> appointments;

   
    private ServicesDto services;
    public DoctorDto(Integer doctorId, String name, int rating, Double fees, String email) {
        this.doctorId = doctorId;
        this.name = name;
        this.rating = rating;
        this.fees = fees;
        this.email = email;
    }
}
