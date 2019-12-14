package swe_2v;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Collaborators {
	    private int name;
	    private int nOfUsersViewedStoresProduct;
	    private int nOfUsersBuyStoresProducts;
	    private int SoldOutProducts;
	    private String []activity = new String[10];
	    private String []history = new String[10];
	    private int size;
		public Collaborators() {
			nOfUsersViewedStoresProduct = 0;
			nOfUsersBuyStoresProducts = 0;
			SoldOutProducts = 0;
			size=0;
	    }
		public String[] getHistory()
		{
			return history;
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
			// updating history with name of the product so the storeowner can search
			//with the name of the product so he can UNDO this action
			history[size++]="Add product/"+ p.getName();
			/*ProductDB obj = new ProductDB();
			obj.AddProduct(p);*/
			}else{
				activity[size++]="Try To Add product";
				System.out.println("Permission denied");
			}
		}
		public void editProduct(String nameOftheProduct,int Price)
		{
			Product p = new Product();
			StoreOwner_P_DB x = new StoreOwner_P_DB();
			//updated price
		    p = x.GetProduct(nameOftheProduct);
		    int tempPrice = p.Price;
		    p.Price = Price;
		    x.editProduct(nameOftheProduct, Price);
		    history[size++] = "Edit product/" + nameOftheProduct +"/"+tempPrice;
		}
		public void deleteProduct(String nameOftheProduct) throws IOException
		{
			Product p = new Product();
			StoreOwner_P_DB x = new StoreOwner_P_DB();
			p = x.GetProduct(nameOftheProduct);
			x.DeleteProduct(nameOftheProduct);
			  String str = Integer.toString(p.getPrice()); 
		      String str1 = Integer.toString(p.getQuantity());
			history[size++]= "Delete product/" +p.getName()+"/"+p.getID()+"/"+str+"/"+p.getCategory()+"/"+p.getBrandName()+"/"+str1;
			
		}
		public void saveHistory() throws IOException
		{
			LoadDB lb = new LoadDB();
			lb.AddtohistoryDB(history);
		}
		public void ShowStatistics() {
			activity[size++]="Show Statistics";
		    System.out.println("number of users viewed the store’s products : "+nOfUsersViewedStoresProduct);
		    System.out.println("number of user buy a store’s produce : "+nOfUsersBuyStoresProducts);
		    System.out.println("current sold out products  : "+SoldOutProducts);
		}	
		
}

