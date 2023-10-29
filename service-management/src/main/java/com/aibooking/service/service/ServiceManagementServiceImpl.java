package com.aibooking.service.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.aibooking.service.domain.Service;
import com.aibooking.service.repository.ServiceManagementRepository;
import com.aibooking.service.response.ServiceResponseWrapper;

@Component
public class ServiceManagementServiceImpl implements ServiceManagementService {


  ServiceManagementRepository serviceManagementRepository;

  ServiceManagementServiceImpl(ServiceManagementRepository serviceManagementRepository) {
    this.serviceManagementRepository = serviceManagementRepository;

  }


  @Override
  public List<ServiceResponseWrapper> getServiceList() {

    List<Service> services = serviceManagementRepository.findAll();

    return services.stream().map(service -> {

      ServiceResponseWrapper vendorResponse = new ServiceResponseWrapper(service.getServiceId(),
          service.getServiceName(), service.getDescription());
      return vendorResponse;
    }).collect(Collectors.toList());


  }

}
