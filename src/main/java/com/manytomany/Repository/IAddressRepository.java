package com.manytomany.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manytomany.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
	//Derived query
	
	 List<Address> findByCity(String city);
	 List<Address> findByZipCode(String zipCode);
	 
	 //custom query
	 
	 @Query("SELECT a FROM Address a WHERE a.city = :city AND a.state = :state")
	    List<Address> findAddressByCityAndState(@Param("city") String city, @Param("state") String state);

	    // JPQL: Get all addresses used by doctors (inverse navigation)
	    @Query("SELECT d.address FROM Doctor d")
	    List<Address> findAllDoctorAddresses();
	
}

