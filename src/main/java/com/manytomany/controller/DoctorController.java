package com.manytomany.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;
import com.manytomany.service.IDoctorService;

import java.util.List;

@RestController

public class DoctorController {

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody DoctorDto doctordto) {
    	doctorService.addDoctor(doctordto);
		return ResponseEntity.status(201).build();
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
    	List<DoctorDto> doctorDtos =doctorService.getAllDoctors();
		//add headers
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctorDtos);
		
    }

    @PostMapping("/{doctorId}/specializations/{specializationId}")
    public ResponseEntity<DoctorDto> assignSpecialization(
            @PathVariable Long doctorId,
            @PathVariable Long specializationId) {
        return ResponseEntity.ok(doctorService.assignSpecialization(doctorId, specializationId));
    }
}

