package com.manytomany.model;



import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "Practoapp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "practoapp_gen",sequenceName = "practoapp_gen",initialValue = 51)
    private Integer Addressid;
    @Column(length = 20)
    private String street;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String state;
    @Column(length = 20)
    private String zipCode;
}
