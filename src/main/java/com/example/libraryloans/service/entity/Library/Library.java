package com.example.libraryloans.service.entity.Library;

import com.example.libraryloans.service.entity.Cashier;
import com.example.libraryloans.service.entity.Catalog.Catalog;
import com.example.libraryloans.service.entity.Material.Material;
import com.example.libraryloans.service.entity.User.User;
import com.example.libraryloans.service.entity.UserBorrowDetails;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class Library {
	private List<Catalog> catalog = new ArrayList<>();
	private Map<User, List<UserBorrowDetails> > borrows = new HashMap<>();

	public void addToCatalog(Material material, Integer copies){
		catalog.add(new Catalog()
				.setMaterial(material)
				.setCopies(copies));

	}

	public void borrowUser(User user, Material material, Integer daysBorrowed){
		if(checkIfMaterialAvailable(material)){
			if(borrows.get(user)==null){
				List<UserBorrowDetails>  userBorrowDetails = new ArrayList<>();
				userBorrowDetails.add(new UserBorrowDetails(material, daysBorrowed));
				borrows.put(user, userBorrowDetails);
			}else{
				if(checkIfUserHasOverdueMaterial(user)){
					user.setCashOnHand(Cashier.handlePayment(user, material));
				}
				if(!checkIfUserBorrowedAlready(user, material)){
					List<UserBorrowDetails> userBorrows = this.borrows.get(user);
					userBorrows.add(new UserBorrowDetails(material, daysBorrowed));
				}
			}
		}
	}

	public void returnMaterial(User user, Material material){
		if(!checkIfUserHasOverdueMaterial(user)){
			Integer copies = getAvailableCatalog(material).getCopies()+1;
			updateCatalog(material, copies);
			updateBorrows(user, material);
		}else{
			user.setCashOnHand(Cashier.handlePayment(user, material));
		}
	}

	private Catalog getAvailableCatalog(Material material){
		return catalog.stream().filter(existingCatalog -> existingCatalog.getMaterial().getTitle().equals(material.getTitle()))
				.findAny().get();
	}

	private void updateCatalog(Material material, Integer copies){
		catalog.stream().map(existingCatalog -> {
			if(existingCatalog.getMaterial().getTitle().equals(material.getTitle())){
				existingCatalog.setCopies(copies);
			}
			return null;
		});
	}

	private void updateBorrows(User user, Material material){
		List<UserBorrowDetails> userBorrows = this.borrows.get(user);
		userBorrows.removeIf(userBorrowDetails -> userBorrowDetails.getMaterial().getTitle().equals(material.getTitle()));
	}

	private boolean checkIfUserBorrowedAlready(User user, Material materialToBorrow){
		List<UserBorrowDetails> userBorrows = this.borrows.get(user);
		return userBorrows.stream().anyMatch(material->material.getMaterial().getTitle().equals(materialToBorrow.getTitle()));
	}

	private boolean checkIfMaterialAvailable(Material materialToBorrow){
		Catalog foundCatalog = catalog.stream()
				.filter(existingCatalog->existingCatalog.getMaterial().getTitle().equals(materialToBorrow.getTitle()))
				.findAny().get();
		return foundCatalog.getCopies() > 0;
	}

	private boolean checkIfUserHasOverdueMaterial(User user){
		List<UserBorrowDetails> userBorrows = this.borrows.get(user);
		return userBorrows.stream().anyMatch(UserBorrowDetails::getLateFee);
	}

}
