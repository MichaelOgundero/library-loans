package com.example.libraryloans.service.entity.Material;

import com.example.libraryloans.service.enums.MaterialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Book extends Material{
	private String author;
	private String genre;

	private Book(String title){
		super(MaterialType.BOOK, title);
	}
}
