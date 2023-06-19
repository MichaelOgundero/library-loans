package com.example.libraryloans.service.enums;

public enum MaterialBorrowDays {
	BOOK(14),
	MAGAZINE(9),
	DVD(9);

	private Integer value;

	private MaterialBorrowDays(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
