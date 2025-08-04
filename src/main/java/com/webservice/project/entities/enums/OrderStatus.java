package com.webservice.project.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPEND(3),
	DELIVERED(4),
	CANCELED(5);
	
	// 1. declarar um código do tipo enumerado
	private int code; 
	
	// 2. declarar o construtor(no Enum, será privado)
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// 3. criando método para que seja evocado por outra classe
	public int getCode() {
		return code;
	}
	
	// 4. criando método estático(sem necessidade de ser instaciando
	// para converter um valor numerico para um tipo Enumerado 
	public static OrderStatus valueOf(int code) {
		// percorrer a enumeração
		for (OrderStatus value : OrderStatus.values()) {
			// verificar se é um dos códigos existe
			if (value.getCode() == code) {
				return value;
			}
		}
		// lançando uma exceção personalizada
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
