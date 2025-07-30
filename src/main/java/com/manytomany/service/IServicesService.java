package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Services;
import com.manytomany.model.ServicesDto;

public interface IServicesService {
	void addServices(ServicesDto servicesDto);
    void  updateServices( ServicesDto servicesDto);
    void deleteServices(int serviceId);
    List<Services> findByCategory(String category);
    Services findByServiceName( String serviceName);
}
