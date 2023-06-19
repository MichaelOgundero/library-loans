package com.example.libraryloans.service.entity.Material;

import com.example.libraryloans.service.enums.MaterialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Magazine extends Material{
	private String series;
	private String volume;

	private Magazine(String title){
		super(MaterialType.MAGAZINE, title);
	}
}
