package com.example.libraryloans.service.entity.Material;

import com.example.libraryloans.service.enums.MaterialType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class DVD extends Material{
private String director;
private String genre;

	private DVD(String title){
		super(MaterialType.DVD, title);
	}
}
