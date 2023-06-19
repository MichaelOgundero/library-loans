package com.example.libraryloans.service.enums;

public enum MaterialType {
	BOOK("Book"),
	MAGAZINE("MAGAZINE"),
	DVD("DVD;");

	private String value;

	private MaterialType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
