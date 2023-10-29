package com.aibooking.service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Service {

  @Id
  String serviceId;


  String serviceName;

  String description;

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }



}
