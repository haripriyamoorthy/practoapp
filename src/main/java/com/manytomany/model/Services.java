package com.manytomany.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Services {
	
	
	@Id
    @GeneratedValue(generator = "Practoapp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "practoapp_gen",sequenceName = "practoapp_gen",initialValue = 51)
	private Integer serviceId;
	@Enumerated(EnumType.STRING) 
	private serviceName serviceName;
	@Enumerated(EnumType.STRING)
	private category category;
	}


