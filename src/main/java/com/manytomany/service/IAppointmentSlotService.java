package com.manytomany.service;

import java.time.LocalDate;
import java.util.List;

import com.manytomany.model.AppointmentSlot;
import com.manytomany.model.AppointmentSlotDto;

public interface IAppointmentSlotService {
	void addAppointmentSlot(AppointmentSlotDto appointmentSlotDto);
    void  updateAppointmentSlot( AppointmentSlotDto appointmentSlotDto);
    void deleteAppointmentSlot(int slotId);
    List<AppointmentSlot> findByDoctorAndDate( Integer doctorId, LocalDate date);

  
    List<AppointmentSlot> findAvailableSlots();
    
}
