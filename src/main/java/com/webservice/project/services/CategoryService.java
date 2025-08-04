package com.webservice.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.project.entities.Category;
import com.webservice.project.repositories.CategoryRepository;


@Service // 3. registrar um serviço na camada de serviço
public class CategoryService {

	// 1. declarar dependência para 
	@Autowired // fazer o spring realizar a injeção de dependência
	private CategoryRepository repository;
	
	// 2. método para retornar todos os usuários do banco de dados
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	// 4. método para buscar o usuário por id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); // classe optional
		return obj.get(); // retornar o objeto instanciado no Optional
	}
}
