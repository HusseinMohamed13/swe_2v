package swe_2v;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StoreOwner {
    private int nOfUsersViewedStoresProduct;
    private int nOfUsersBuyStoresProducts;
    private int SoldOutProducts;
	public StoreOwner() {
		nOfUsersViewedStoresProduct = 0;
		nOfUsersBuyStoresProducts = 0;
		SoldOutProducts = 0;
    }
	public void SetStatistics(int a,int b,int c) {
		int nOfUsersViewedStoresProduct = a;
	    int nOfUsersBuyStoresProducts = b;
	    int SoldOutProducts = c;
	}
	public boolean AddProduct(Product p) throws IOException {
		AdminstratorController ac = new AdminstratorController();
		if(ac.PermissionProduct(p)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean AddStore(Store s) throws IOException {
		AdminstratorController ac = new AdminstratorController();
		if(ac.PermissionStore(s)) {
		    return true;
		}else {
			return false;
		}
	}
	public void ShowStatistics() {
	    System.out.println("number of users viewed the store’s products : "+nOfUsersViewedStoresProduct);
	    System.out.println("number of user buy a store’s produce : "+nOfUsersBuyStoresProducts);
	    System.out.println("current sold out products  : "+SoldOutProducts);
	}
	public void AddCollaborator(Collaborators c,Store s) throws IOException {
		s.AddCollaborator(c,s);
	}
}