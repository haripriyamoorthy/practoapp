package com.manytomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manytomany.model.Hospital;
import com.manytomany.model.Speciality;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {
	// 1. Find hospital by category (e.g., "multispeciality", "ent")
    @Query("SELECT h FROM Hospital h WHERE h.category = :category")
    List<Hospital> findByCategory(@Param("category") String category);

    // 2. Find hospital by location
    @Query("SELECT h FROM Hospital h WHERE h.location = :location")
    List<Hospital> findByLocation(@Param("location") String location);

    // 3. Find hospitals that have a doctor with a given name
    @Query("SELECT h FROM Hospital h JOIN h.doctors d WHERE d.name = :name")
    List<Hospital> findHospitalsByDoctorName(@Param("name") String name);

    // 4. Find hospitals that have doctors with a specific specialization
    @Query("SELECT DISTINCT h FROM Hospital h JOIN h.doctors d JOIN d.Specialities s WHERE s = :Speciality")
    List<Hospital> findHospitalsBySpeciality(@Param("Speciality") Speciality Speciality);

    // 5. Find hospitals with doctors having more than a given experience
    @Query("SELECT DISTINCT h FROM Hospital h JOIN h.doctors d WHERE d.experience > :years")
    List<Hospital> findHospitalsWithExperiencedDoctors(@Param("years") int years);

}
