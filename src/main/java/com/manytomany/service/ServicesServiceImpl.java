package com.manytomany.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.manytomany.model.Services;
import com.manytomany.model.ServicesDto;
import com.manytomany.repository.IServiceRepository;

public class ServicesServiceImpl implements IServicesService{
	private  IServiceRepository ServiceRepository;
    public ServicesServiceImpl(IServiceRepository serviceRepository) {
        this.ServiceRepository = serviceRepository;
    }
    
    @Autowired
	private ModelMapper mapper;

	@Override
	public void addServices(ServicesDto servicesDto) {
		Services services = mapper.map(servicesDto,Services.class);
		ServiceRepository.save(services);
	}

	@Override
	public void updateServices(ServicesDto servicesDto) {
		Services services = mapper.map(servicesDto,Services.class);
		ServiceRepository.save(services);
		
	}

	@Override
	public void deleteServices(int serviceId) {
		ServiceRepository.deleteById(serviceId);
		
	}

	@Override
	public List<Services> findByCategory(String category) {
		// TODO Auto-generated method stub
		return ServiceRepository.findByCategory(category);
	}

	@Override
	public Services findByServiceName(String serviceName) {
		// TODO Auto-generated method stub
		return ServiceRepository.findByServiceName(serviceName);
	}
	

}
