package com.manytomany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Specialization;

public interface ISpecializationRepository extends JpaRepository<Specialization, Long> {}
