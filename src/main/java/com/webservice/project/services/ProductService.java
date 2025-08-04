package com.webservice.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.project.entities.Product;
import com.webservice.project.repositories.ProductRepository;


@Service // 3. registrar um serviço na camada de serviço
public class ProductService {

	// 1. declarar dependência para 
	@Autowired // fazer o spring realizar a injeção de dependência
	private ProductRepository repository;
	
	// 2. método para retornar todos os usuários do banco de dados
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	// 4. método para buscar o usuário por id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); // classe optional
		return obj.get(); // retornar o objeto instanciado no Optional
	}
}
