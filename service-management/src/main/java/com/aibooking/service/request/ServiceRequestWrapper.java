package com.aibooking.service.request;

import jakarta.validation.constraints.NotEmpty;

public record ServiceRequestWrapper(Long vendorId,
    @NotEmpty(message = "name can not be null") String serviceName, String description) {

}
