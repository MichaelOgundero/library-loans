package com.example.libraryloans.service.enums;

public enum MaterialLateFee {
	BOOK(2.99),
	MAGAZINE(3.99),
	DVD(4.50);

	private Double value;

	private MaterialLateFee(Double value){
		this.value = value;
	}

	public Double getValue(){
		return this.value;
	}
}
