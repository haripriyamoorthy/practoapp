package com.manytomany.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manytomany.model.Doctor;
import com.manytomany.model.DoctorDto;
import com.manytomany.model.Speciality;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	List<DoctorDto> findByname(String name);
	@Query("SELECT new com.manytomany.model.DoctorDto(d.doctorId, d.name, d.rating, d.fees, d.email) FROM Doctor d WHERE d.doctorId = :id")
	List<DoctorDto> getDoctorById(@Param("id") Integer id);
	@Query("SELECT d FROM Doctor d JOIN d.Specialities s WHERE s IN :Specialities")
	List<Doctor> findDoctorsBySpecializationName(@Param("Specialities") List<Speciality> Specialities);


	@Query("SELECT d FROM Doctor d WHERE d.address.city = :city")
    List<Doctor> findDoctorsByCity(@Param("city") String city);

    // JPQL: Get doctor by name and city
    @Query("SELECT d FROM Doctor d WHERE d.name = :name AND d.address.city = :city")
    Doctor findDoctorByNameAndCity(@Param("name") String name, @Param("city") String city);

    // JPQL: Get doctors whose fee is between a range
    @Query("SELECT d FROM Doctor d WHERE d.fees BETWEEN :min AND :max")
    List<Doctor> findDoctorsByFeesBetween(@Param("min") double min, @Param("max") double max);

	
}
