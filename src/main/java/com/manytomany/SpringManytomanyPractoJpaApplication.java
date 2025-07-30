package com.manytomany;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manytomany.model.AddressDto;
import com.manytomany.model.AppointmentSlotDto;
import com.manytomany.model.DoctorDto;
import com.manytomany.model.HospitalDto;
import com.manytomany.model.ServicesDto;
import com.manytomany.model.Speciality;
import com.manytomany.model.category;
import com.manytomany.model.serviceName;
import com.manytomany.model.slotTime;
import com.manytomany.service.IDoctorService;

@SpringBootApplication
public class SpringManytomanyPractoJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringManytomanyPractoJpaApplication.class, args);
    }

    @Autowired
    private IDoctorService doctorService;

    @Override
    public void run(String... args) throws Exception {

        // Address
    	  AddressDto address1 = new AddressDto(null, "KKNAGAR", "CHENNAI", "Tamilnadu", "609110");
          AddressDto address2 = new AddressDto(null, "BTM Layout", "Bangalore", "Karnataka", "560076");

          // Services
          ServicesDto cornService = new ServicesDto(null, serviceName.CORN_REMOVAL, category.NON_SURGICAL);
          ServicesDto HairService = new ServicesDto(null, serviceName.Hair_Transplantation, category.SURGICAL);

          // Appointment Slots
          AppointmentSlotDto slot1 = new AppointmentSlotDto(null, LocalDate.now().plusDays(1), 5,
                  List.of(slotTime.SLOT_10_30_AM,slotTime.SLOT_10_45_AM ,slotTime.SLOT_11_00_AM));
          AppointmentSlotDto slot2 = new AppointmentSlotDto(null, LocalDate.now().plusDays(2), 4,
                  List.of(slotTime.SLOT_10_30_AM,slotTime.SLOT_10_45_AM ,slotTime.SLOT_11_00_AM));

      
  		List<AppointmentSlotDto> slots=List.of(slot1,slot2);
  		// Hospital with doctors assigned later
  		 HospitalDto hospital1 = new HospitalDto(null, "Apollo", "Bangalore", "Multispeciality", null);
  	        HospitalDto hospital2 = new HospitalDto(null, "Fortis", "Chennai", "General", null);
  	        List<HospitalDto> hospitalses = List.of(hospital1,hospital2);
  		
  		
  		// Doctor list (initialize with empty hospital, to avoid circular dependency first)
          DoctorDto doctor1 = new DoctorDto(null, "Dr. Sneha", 5, 900.0, "sneha@example.com", 7,
                  address1,List.of(Speciality.ORTHOPEDICIAN, Speciality.DERMATOLOGIST) ,hospitalses
                  , slots, cornService);

          DoctorDto doctor2 = new DoctorDto(null, "Dr. Rahul", 4, 1200.0, "rahul@example.com", 10,
                  address2,List.of(Speciality.CARDIOLOGIST, Speciality.NEUROLOGIST) ,
                  hospitalses, slots, HairService);
         

          
         

         
          
          
          doctorService.addDoctor(doctor1);
          doctorService.addDoctor(doctor2);
        
        
    }
}
