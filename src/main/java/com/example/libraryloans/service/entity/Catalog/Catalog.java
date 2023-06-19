package com.example.libraryloans.service.entity.Catalog;

import com.example.libraryloans.service.entity.Material.Material;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Catalog {
	private Material material;
	private Integer  copies;


}
