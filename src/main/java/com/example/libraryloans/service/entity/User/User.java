package com.example.libraryloans.service.entity.User;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
	private String name;
	private Double cashOnHand;
}
