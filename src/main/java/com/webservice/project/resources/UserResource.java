package com.webservice.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.project.entities.User;

@RestController // diz que é um classe de recursos web, com controlador REST
@RequestMapping(value = "/users") // dá o nome para o recurso para utilizar na url
public class UserResource {

	// endpoint, testa se está funcionando
	@GetMapping
	public ResponseEntity<User> findAll() { // método para retornar todos os usuários
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		// 'ResponseEntity' encapsula a respota http
		// 'ok()', dá a resposta de sucesso, 
		// 'body()', mostrar a resposta no corpo da página
		return ResponseEntity.ok().body(u); // 
	}
}
