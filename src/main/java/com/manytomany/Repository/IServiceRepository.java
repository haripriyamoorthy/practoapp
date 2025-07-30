package com.manytomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manytomany.model.Services;

public interface IServiceRepository extends JpaRepository<Services, Integer>{
	 @Query("SELECT s FROM Services s WHERE s.category = :category")
	    List<Services> findByCategory(@Param("category") String category);

	    // Find service by name
	    @Query("SELECT s FROM Services s WHERE s.serviceName = :name")
	    Services findByServiceName(@Param("name") String name);
}
