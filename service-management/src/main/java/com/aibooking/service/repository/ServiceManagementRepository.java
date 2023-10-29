package com.aibooking.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aibooking.service.domain.Service;

@Repository
public interface ServiceManagementRepository extends JpaRepository<Service, Long> {

}
