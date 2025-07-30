package com.manytomany.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppointmentSlot {
	@Id
    @GeneratedValue(generator = "Practoapp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "practoapp_gen",sequenceName = "practoapp_gen",initialValue = 51)
    private Integer slotId;
    @Column(length=20)
    private LocalDate slotDate;
    @Column(length=20)
    private int totalSlots;

    @ElementCollection
    private List<slotTime> slotTime;
    @ManyToOne
    @JoinColumn(name = "doctor_id") // This should match your DB column name
    private Doctor doctor;
}
