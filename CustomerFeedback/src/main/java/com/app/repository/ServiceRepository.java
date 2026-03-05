package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.Service;
 
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
 
