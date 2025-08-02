package com.webservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
