package com.manytomany.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
	
}
