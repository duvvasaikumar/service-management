package com.aibooking.service.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.aibooking.service.response.ServiceResponseWrapper;

@Component
public interface ServiceManagementService {

  List<ServiceResponseWrapper> getServiceList();

}
