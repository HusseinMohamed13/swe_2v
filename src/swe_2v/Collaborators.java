package swe_2v;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Collaborators {
	private String name;
	private int nOfUsersViewedStoresProduct;
	private int nOfUsersBuyStoresProducts;
	private int SoldOutProducts;
	private String[] activity = new String[10];
	private String[] history = new String[10];
	private int size;

	public Collaborators() {
		nOfUsersViewedStoresProduct = 0;
		nOfUsersBuyStoresProducts = 0;
		SoldOutProducts = 0;
		size = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String[] getHistory() {
		return history;
	}

	public void SetStatistics(int a, int b, int c) {
		int nOfUsersViewedStoresProduct = a;
		int nOfUsersBuyStoresProducts = b;
		int SoldOutProducts = c;
	}

	public void AddOffer(String nameOftheProduct, int offer) throws IOException {
		LoadDB lb = new LoadDB();
		lb.addOffer(nameOftheProduct, offer);
		history[size++] = "Add offer/" + nameOftheProduct + "/" + offer;
	}

	public void editOffer(String nameOftheProduct, int newOffer) throws IOException {
		LoadDB lb = new LoadDB();
		int oldOffer = lb.editOffer(nameOftheProduct, newOffer);
		history[size++] = "Edit offer/" + nameOftheProduct + "/" + oldOffer;
	}

	public void deleteOffer(String nameOftheProduct) throws IOException {
		LoadDB lb = new LoadDB();
		int oldOffer = 0;
		oldOffer = lb.deleteOffer(nameOftheProduct);
		history[size++] = "Delete offer/" + nameOftheProduct + "/" + oldOffer;

	}

	public boolean AddProduct(Product p) throws IOException {
		boolean x = false;
		AdminstratorController ac = new AdminstratorController();
		if (ac.PermissionProduct(p)) {
			x = true;
			StoreOwnerController pd = new StoreOwnerController();
			pd.AddProduct(p);
			activity[size++] = "Add product";
			// updating history with name of the product so the storeowner can search
			// with the name of the product so he can UNDO this action
			history[size++] = "Add product/" + p.getName();
			/*
			 * ProductDB obj = new ProductDB(); obj.AddProduct(p);
			 */
		} else {
			x = false;
			activity[size++] = "Try To Add product";
		}
		return x;
	}

	public void editProduct(String nameOftheProduct, int Price) throws IOException {
		Product p = new Product();
		StoreOwnerController x = new StoreOwnerController();
		// updated price
		p = x.GetProduct(nameOftheProduct);
		int tempPrice = p.Price;
		p.Price = Price;
		x.editProduct(nameOftheProduct, Price);
		history[size++] = "Edit product/" + nameOftheProduct + "/" + tempPrice;
	}

	public void deleteProduct(String nameOftheProduct) throws IOException {
		Product p = new Product();
		StoreOwnerController x = new StoreOwnerController();
		p = x.GetProduct(nameOftheProduct);
		x.DeleteProduct(nameOftheProduct);
		String str = Integer.toString(p.getPrice());
		String str1 = Integer.toString(p.getQuantity());
		history[size++] = "Delete product/" + p.getName() + "/" + p.getID() + "/" + str + "/" + p.getCategory() + "/"
				+ p.getBrandName() + "/" + str1;

	}

	public void saveHistory() throws IOException {
		LoadDB lb = new LoadDB();
		lb.AddtohistoryDB(history);
	}

	public void ShowStatistics() {
		activity[size++] = "Show Statistics";
		System.out.println("number of users viewed the store’s products : " + nOfUsersViewedStoresProduct);
		System.out.println("number of user buy a store’s produce : " + nOfUsersBuyStoresProducts);
		System.out.println("current sold out products  : " + SoldOutProducts);
	}

}
