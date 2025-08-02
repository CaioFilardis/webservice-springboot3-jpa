package com.webservice.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@ManyToOne // anotação do JPA, são "muitos para um", ID do Order, será a chave estrangeira
	@JoinColumn(name = "client_id") // anotação JPA, que renomeia a chave estrangeira
	private User clients; 
	
	public Order() {}

	public Order(Long id, Instant date, User clients) {
		this.id = id;
		this.date = date;
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
