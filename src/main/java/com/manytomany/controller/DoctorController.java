package com.manytomany.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;
import com.manytomany.service.IDoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor-api/v1")
public class DoctorController {

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctors")
    ResponseEntity<Doctor> addDoctor(@RequestBody DoctorDto doctordto) {
    	doctorService.addDoctor(doctordto);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/doctors")
    ResponseEntity<List<DoctorDto>> getAllDoctors() {
    	List<DoctorDto> doctorDtos =doctorService.getAllDoctors();
    	HttpHeaders headers =  new HttpHeaders();
		headers.add("info","getting all doctors");
		return ResponseEntity.ok().headers(headers).body(doctorDtos);
		//add headers
		
		
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<DoctorDto>> getDoctorById(@PathVariable Integer id) {
        List<DoctorDto> doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

   
}

