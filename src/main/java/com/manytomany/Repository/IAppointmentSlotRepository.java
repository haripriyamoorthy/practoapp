package com.manytomany.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manytomany.model.AppointmentSlot;

public interface IAppointmentSlotRepository extends JpaRepository<AppointmentSlot, Integer>{
	 @Query("SELECT a FROM AppointmentSlot a WHERE a.doctor.doctorId = :doctorId AND a.slotDate = :date")
	    List<AppointmentSlot> findByDoctorAndDate(@Param("doctorId") Integer doctorId, @Param("date") LocalDate date);

	    // Find slots having available capacity
	    @Query("SELECT a FROM AppointmentSlot a WHERE a.totalSlots > 0")
	    List<AppointmentSlot> findAvailableSlots();
}
