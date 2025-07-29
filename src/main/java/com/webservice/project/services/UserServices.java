package com.webservice.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.project.entities.User;
import com.webservice.project.repositories.UserRepository;


@Service // 3. registrar um serviço na camada de serviço
public class UserServices {

	// 1. declarar dependência para 
	@Autowired // fazer o spring realizar a injeção de dependência
	private UserRepository repository;
	
	// 2. método para retornar todos os usuários do banco de dados
	public List<User> findAll() {
		return repository.findAll();
	}
	
	// 4. método para buscar o usuário por id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); // classe optional
		return obj.get(); // retornar o objeto instanciado no Optional
	}
}
