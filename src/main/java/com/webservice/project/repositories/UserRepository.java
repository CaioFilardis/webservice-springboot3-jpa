package com.webservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
