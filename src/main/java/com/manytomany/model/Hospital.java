package com.manytomany.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {
	@Id
    @GeneratedValue(generator = "Practoapp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "practoapp_gen",sequenceName = "practoapp_gen",initialValue = 51)
	 private Integer hospitalId;
	@Column(length = 20)
	 private String hospitalName;
	@Column(length = 20)
	 private String location;
	
	 private String category;

	 @ManyToMany(mappedBy = "hospital")
	 private List<Doctor> doctors;
	
	   
	}
	


