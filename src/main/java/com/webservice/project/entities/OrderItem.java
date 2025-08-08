package com.webservice.project.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.project.entities.pk.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	
	// atributo identificador, correspondente a chave primária
	// sempre instanciar uma classe auxiliar de chave primária composta
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	
	private Integer quantity;
	private Double price;
	
	
	public OrderItem() {}

	// passando os componente de Order e Product, pelo atributo identificador 'id'
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	// gerando os métodos dos getters e setters do produtct e order de forma manual
	// fazendo isso atravé do identificador 'id' do tipo "OrderItemPk", classe auxiliar
	@JsonIgnore
	public Order getOrder() { // chama o pedido
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
