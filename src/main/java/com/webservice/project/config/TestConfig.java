package com.webservice.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import com.webservice.project.entities.enums.OrderStatus;
import com.webservice.project.repositories.OrderRepository;
import com.webservice.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // manda o spring 'resolver'a dependência
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception { // instanciar, salvar e popular com objetos o banco
		
		// id gerado no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		// passando o id, o instante de criação e passando o usuário(User),
		// a associação entre os objetos User + Order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 

		// mandar salvar
		userRepository.saveAll(Arrays.asList(u1, u2)); // passar todos os objetos em forma de lista
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
