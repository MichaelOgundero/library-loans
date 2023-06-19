package com.example.libraryloans.service.entity.Material;

import com.example.libraryloans.service.enums.MaterialBorrowDays;
import com.example.libraryloans.service.enums.MaterialLateFee;
import com.example.libraryloans.service.enums.MaterialType;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Material {

	private MaterialType type;
	private MaterialBorrowDays borrowDays;
	private MaterialLateFee lateFee;
	private String title;

	private Material(){}

	Material(MaterialType type, String title){
		this.title = title;
		setMaterialFields(type);
	}

	private void setMaterialFields(MaterialType type) {
		if(type.equals(MaterialType.BOOK)){
			this.borrowDays = MaterialBorrowDays.BOOK;
			this.lateFee = MaterialLateFee.BOOK;
		}else if(type.equals(MaterialType.MAGAZINE)){
			this.borrowDays = MaterialBorrowDays.MAGAZINE;
			this.lateFee  = MaterialLateFee.MAGAZINE;
		}else if(type.equals(MaterialType.DVD)){
			this.borrowDays = MaterialBorrowDays.DVD;
			this.lateFee = MaterialLateFee.DVD;
		}
	}
}
