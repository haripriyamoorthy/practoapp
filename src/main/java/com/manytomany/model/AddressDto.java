package com.manytomany.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressDto {

   
    private Integer Addressid;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
