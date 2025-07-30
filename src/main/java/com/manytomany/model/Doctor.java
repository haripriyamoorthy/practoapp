package com.manytomany.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Doctor {
	@Id
    @GeneratedValue(generator = "Practoapp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "practoapp_gen",sequenceName = "practoapp_gen",initialValue = 51)
    private Integer doctorId;
	@Column(length = 20)
    private String name;
	@Column(length = 20)
    private int rating;
	@Column(length = 20)
    private double fees;
	@Column(length = 20)
    private String email;
	@Column(length = 20)
    private int experience;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ElementCollection
    private List<Speciality> Specialities;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hospital> hospital;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AppointmentSlot> appointments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(
    	    name = "doctor_services",
    	    joinColumns = @JoinColumn(name = "doctor_id"),
    	    inverseJoinColumns = @JoinColumn(name = "service_id")
    	)
    private Services services;
}
