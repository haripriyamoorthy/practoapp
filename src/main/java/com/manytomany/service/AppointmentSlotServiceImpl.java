package com.manytomany.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.manytomany.model.AppointmentSlot;
import com.manytomany.model.AppointmentSlotDto;
import com.manytomany.repository.IAppointmentSlotRepository;

public class AppointmentSlotServiceImpl implements IAppointmentSlotService{
    private final IAppointmentSlotRepository AppointmentSlotRepository;
    
    @Autowired
	private ModelMapper mapper;

    public AppointmentSlotServiceImpl(IAppointmentSlotRepository AppointmentSlotRepository) {
        this.AppointmentSlotRepository = AppointmentSlotRepository;
        //this.specializationRepository = specializationRepository;
    }

	@Override
	public void addAppointmentSlot(AppointmentSlotDto appointmentSlotDto) {
		AppointmentSlot appointmentSlot = mapper.map(appointmentSlotDto,AppointmentSlot.class);
		AppointmentSlotRepository.save(appointmentSlot);
		
		
	}

	@Override
	public void updateAppointmentSlot(AppointmentSlotDto appointmentSlotDto) {
		
		AppointmentSlot appointmentSlot = mapper.map(appointmentSlotDto,AppointmentSlot.class);
		AppointmentSlotRepository.save(appointmentSlot);
		
	}

	@Override
	public void deleteAppointmentSlot(int slotId) {
		AppointmentSlotRepository.deleteById(slotId);
	}

	@Override
	public List<AppointmentSlot> findByDoctorAndDate(Integer doctorId, LocalDate date) {
		// TODO Auto-generated method stub
		return AppointmentSlotRepository.findByDoctorAndDate(doctorId, date);
	}

	@Override
	public List<AppointmentSlot> findAvailableSlots() {
		// TODO Auto-generated method stub
		return AppointmentSlotRepository.findAvailableSlots();
	}

}
