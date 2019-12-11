package swe_2v;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StoreOwner {
	public StoreOwner() {
		 
	 }
	public void AddProduct(Product p) throws IOException {
		AdminstratorController ac = new AdminstratorController();
		if(ac.PermissionProduct(p)) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Quantity");
		int q = sc.nextInt(); 
		p.setQuantity(q);
		StoreOwner_P_DB pd = new StoreOwner_P_DB();
		pd.AddProduct(p);
		System.out.println("Product Added");	
		/*ProductDB obj = new ProductDB();
		obj.AddProduct(p);*/
		}else {
			System.out.println("Permission denied");
		}
	}
	public void AddStore(Store s) throws IOException {
		AdminstratorController ac = new AdminstratorController();
		if(ac.PermissionStore(s)) {
		StoreDB obj = new StoreDB();
		obj.AddStore(s); 
		}else {
			System.out.println("Permission denied");
		}
	}
	public void ShowStatistics() {
	    Random rand = new Random();
	    int nOfUsersViewedStoresProduct = rand.nextInt(5000);
	    int nOfUsersBuyStoresProducts = rand.nextInt(3000);
	    int SoldOutProducts = rand.nextInt(4000);
	    System.out.println("number of users viewed the store’s products : "+nOfUsersViewedStoresProduct);
	    System.out.println("number of user buy a store’s produce : "+nOfUsersBuyStoresProducts);
	    System.out.println("current sold out products  : "+SoldOutProducts);
	}
}
