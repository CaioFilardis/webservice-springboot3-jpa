package com.webservice.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservice.project.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // diz ao JPA que é uma tabela(entidade) do banco de dados
@Table(name = "tb_order") // renomear a tabela(entidade) para evitar confusão
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date; // classe instant para utilizar data como texto
	
	// gravando no banco de dados o código do enum como inteiro, apenas de forma interna
	private Integer orderStatus;  // tratando a enumeração internamente como inteiro
	
	
	
	@ManyToOne // anotação do JPA, são "muitos para um", ID do Order, será a chave estrangeira
	@JoinColumn(name = "client_id") // anotação JPA, que renomeia a chave estrangeira
	private User clients; 
	
	public Order() {}

	public Order(Long id, Instant date, OrderStatus orderStatus, User clients) {
		this.id = id;
		this.date = date;
		setOrderStatus(orderStatus);
		this.clients = clients;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); // é criado sem ser instanciado e convertido para enum
	}

	public void setOrderStatus(OrderStatus orderStatus) { // passa como enum
		if (orderStatus != null)
			this.orderStatus = orderStatus.getCode(); // converte para inteiro
	}
	
	
	public User getClients() {
		return clients;
	}

	public void setClients(User clients) {
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
