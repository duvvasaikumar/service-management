package com.aibooking.service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aibooking.service.error.InvalidRequestArgumentException;
import com.aibooking.service.request.ServiceRequestWrapper;
import com.aibooking.service.response.ServiceResponseWrapper;
import com.aibooking.service.service.ServiceManagementService;

@RestController
@RequestMapping("/servicemanagement")
public class ServiceManagementController {


  private static final Logger logger = LoggerFactory.getLogger(ServiceManagementController.class);

  ServiceManagementService serviceManagementService;



  ServiceManagementController(ServiceManagementService serviceManagementService) {
    this.serviceManagementService = serviceManagementService;

  }

  @GetMapping("/serviceList")
  ResponseEntity<List<ServiceResponseWrapper>> getServices() {

    logger.info("Get all Service ");

    List<ServiceResponseWrapper> responseList = serviceManagementService.getServiceList();

    return new ResponseEntity<List<ServiceResponseWrapper>>(responseList, HttpStatus.OK);

  }

  @PostMapping("/service")
  ResponseEntity<ServiceResponseWrapper> createService(
      @RequestBody @Validated ServiceRequestWrapper serviceRequestWrapper,
      BindingResult bindingResult) {

    logger.info("Create Service request for vendor {} ", serviceRequestWrapper.serviceName());

    if (bindingResult.hasErrors()) {
      throw new InvalidRequestArgumentException();
    }

    ServiceResponseWrapper response = new ServiceResponseWrapper("123", "service", "desc");

    return new ResponseEntity<ServiceResponseWrapper>(response, HttpStatus.CREATED);

  }

}
