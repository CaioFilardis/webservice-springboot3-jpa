package com.webservice.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.project.entities.Order;
import com.webservice.project.services.OrderServices;

@RestController // diz que é um classe de recursos web, com controlador REST
@RequestMapping(value = "/orders") // dá o nome para o recurso para utilizar na url
public class OrderResource {

	// dependência para o service
	@Autowired
	private OrderServices service;
	
	// endpoint, testa se está funcionando
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		// 'ResponseEntity' encapsula a respota http
		// 'ok()', dá a resposta de sucesso, 
		// 'body(Order)', mostrar a resposta no corpo da página
		return ResponseEntity.ok().body(list);
	}
	
	// adicionar um endpoint
	@GetMapping(value = "/{id}") // indica que a requisição vai aceitar um id na URL
	public ResponseEntity<Order> findById(@PathVariable Long id) { // anotação para aceitar o id e passar como parâmentro na URL
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
