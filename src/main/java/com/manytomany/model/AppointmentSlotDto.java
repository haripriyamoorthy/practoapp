package com.manytomany.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentSlotDto {
	
    private Integer slotId;
   
    private LocalDate slotDate;
   
    private int totalSlots;

   
    private List<slotTime> slotTime;
}
