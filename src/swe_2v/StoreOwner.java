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
	    nOfUsersViewedStoresProduct = a;
	    nOfUsersBuyStoresProducts = b;
	    SoldOutProducts = c;
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
	    System.out.println("number of users viewed the store products : "+nOfUsersViewedStoresProduct);
	    System.out.println("number of user buy a store produce : "+nOfUsersBuyStoresProducts);
	    System.out.println("current sold out products  : "+SoldOutProducts);
	}
	public void AddCollaborator(Collaborators c,Store s) throws IOException {
		s.AddCollaborator(c,s);
	}
	
	public void UndoCollaboratorPrductAction(Collaborators c,int i) throws IOException
	{

		String[] history = new String[10];
		String[] parsedData = new String[10];
		history = c.getHistory();

			parsedData = history[i].split("/");
			if(parsedData[0]=="Add product")
			{
				//so we will the delete the product he added to the database
				StoreOwnerController x = new StoreOwnerController();
				x.DeleteProduct(parsedData[1]);
			}
			if(parsedData[0]=="Edit product")
			{
				StoreOwnerController x = new StoreOwnerController();
				int price = Integer.parseInt(parsedData[2]);
				x.editProduct(parsedData[1], price);
			}
			if(parsedData[0]=="Delete product")
			{
				StoreOwnerController x = new StoreOwnerController();
			   int price = Integer.parseInt(parsedData[3]);
			   int quantity = Integer.parseInt(parsedData[6]);
			   Product p = new Product(parsedData[1],parsedData[2],price,parsedData[4],parsedData[5],quantity);
			   x.AddProduct(p);		
			}
	}
	public void UndoCollaboratorOfferAction(Collaborators c,int i) throws IOException
	{
		String[] history = new String[10];
		String[] parsedData = new String[10];
		history = c.getHistory();
		
		    parsedData = history[i].split("/");
			if(parsedData[0]=="Add offer")
			{
				
				LoadDB lb = new LoadDB();
				lb.deleteOffer(parsedData[1]);
			}
			if(parsedData[0]=="Edit offer")
			{
				LoadDB lb = new LoadDB();
				int oldOffer = Integer.parseInt(parsedData[2]);
				int newOFfer=lb.editOffer(parsedData[1],oldOffer);
			}
			if(parsedData[0]=="Delete offer")
			{
				LoadDB lb = new LoadDB();
				int oldOffer = Integer.parseInt(parsedData[2]);
				lb.addOffer(parsedData[1], oldOffer);

			}
	}
	
}
