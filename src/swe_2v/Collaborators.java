package swe_2v;

import java.io.IOException;
import java.util.Scanner;

public class Collaborators {
	    private String ID;
	    private int nOfUsersViewedStoresProduct;
	    private int nOfUsersBuyStoresProducts;
	    private int SoldOutProducts;
	    private String []activity = new String[10];
	    private int size;
		public Collaborators(String id) {
			ID = id;
			nOfUsersViewedStoresProduct = 0;
			nOfUsersBuyStoresProducts = 0;
			SoldOutProducts = 0;
			size=0;
	    }
		public String GetID() {
			return ID;
		}
		public void SetStatistics(int a,int b,int c) {
			int nOfUsersViewedStoresProduct = a;
		    int nOfUsersBuyStoresProducts = b;
		    int SoldOutProducts = c;
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
			activity[size++]="Add product";
			}else {
				activity[size++]="Try To Add product";
				System.out.println("Permission denied");
			}
		}
		public void ShowStatistics() {
			activity[size++]="Show Statistics";
		    System.out.println("number of users viewed the store’s products : "+nOfUsersViewedStoresProduct);
		    System.out.println("number of user buy a store’s produce : "+nOfUsersBuyStoresProducts);
		    System.out.println("current sold out products  : "+SoldOutProducts);
		}	
}

