package com.example.libraryloans.service.entity;

import com.example.libraryloans.service.entity.Material.Material;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
public class UserBorrowDetails {

	private Material material;
	private Integer daysBorrowed;
	private Boolean lateFee;
	private Double owing;

	public UserBorrowDetails(Material material, Integer daysBorrowed){
		this.material = material;
		this.daysBorrowed = daysBorrowed;
		if(daysBorrowed > material.getBorrowDays().getValue()){
			this.lateFee = true;
			this.owing = material.getLateFee().getValue();
		}
	}

}
