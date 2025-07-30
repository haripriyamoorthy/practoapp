package com.manytomany.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.manytomany.model.Address;
import com.manytomany.model.AddressDto;
import com.manytomany.repository.IAddressRepository;

public class AddressServiceImpl implements IAddressService{
	 private  IAddressRepository addressRepository;
	    public AddressServiceImpl(IAddressRepository addressRepository) {
	        this.addressRepository = addressRepository;
	    }

	    @Autowired
		private ModelMapper mapper;
		

	@Override
	public void addAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		Address address = mapper.map(addressDto, Address.class);
		addressRepository.save(address);
	}

	@Override
	public void updateAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		Address address = mapper.map(addressDto, Address.class);
		addressRepository.save(address);
		
	}

	@Override
	public void deleteAddress(int Addressid) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(Addressid);
		
	}

	@Override
	public List<AddressDto> findByCity(String city) {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepository.findByCity(city);
		return addresses.stream()
			     .map(addresseses->mapper.map(addresseses,AddressDto.class))
			     .toList();
	}

	@Override
	public List<AddressDto> findByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepository.findByZipCode(zipCode);
		return addresses.stream()
			     .map(addresseses->mapper.map(addresseses,AddressDto.class))
			     .toList();
	}

	@Override
	public List<AddressDto> findAddressByCityAndState(String city, String state) {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepository.findAddressByCityAndState(city, state);
		return addresses.stream()
			     .map(addresseses->mapper.map(addresseses,AddressDto.class))
			     .toList();
	}

	@Override
	public List<AddressDto> findAllDoctorAddresses() {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepository.findAllDoctorAddresses();
		return addresses.stream()
			     .map(addresseses->mapper.map(addresseses,AddressDto.class))
			     .toList();
	}

}
