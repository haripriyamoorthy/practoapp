package com.manytomany.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private field field;//orthopedician

    @ManyToMany(mappedBy = "specializations", fetch = FetchType.LAZY)
    private Set<Doctor> doctors = new HashSet<>();

    // Getters and setters
}
