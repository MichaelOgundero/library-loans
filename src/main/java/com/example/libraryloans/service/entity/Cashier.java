package com.example.libraryloans.service.entity;

import com.example.libraryloans.service.entity.Material.Material;
import com.example.libraryloans.service.entity.User.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Cashier {

	public static Double handlePayment(User user, Material material){
		return user.getCashOnHand() - material.getLateFee().getValue();
	}

}
