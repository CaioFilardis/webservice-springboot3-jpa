package com.webservice.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.project.entities.Category;
import com.webservice.project.services.CategoryServices;

@RestController // diz que é um classe de recursos web, com controlador REST
@RequestMapping(value = "/categories") // dá o nome para o recurso para utilizar na url
public class CategoryResource {

	// dependência para o service
	@Autowired
	private CategoryServices service;
	
	// endpoint, buscar todas as categorias
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		// 'ResponseEntity' encapsula a respota http
		// 'ok()', dá a resposta de sucesso, 
		// 'body(Category)', mostrar a resposta no corpo da página
		return ResponseEntity.ok().body(list);
	}
	
	// endpoint para buscar apenas por id
	@GetMapping(value = "/{id}") // indica que a requisição vai aceitar um id na URL
	public ResponseEntity<Category> findById(@PathVariable Long id) { // anotação para aceitar o id e passar como parâmentro na URL
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
