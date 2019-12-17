package swe_2v;

import java.io.IOException;

public class StoreOwnerController {
	 private int size;
	 private Product ListOfProducts[]= new Product[10];
     
     public StoreOwnerController() {
    	 size=0;
    	 for(int x=0;x<10;x++) {
    		 ListOfProducts[x]=new Product();
    	 }
     }
     public void set() throws IOException {
    	 LoadDB ld = new LoadDB();
    	 ListOfProducts = ld.setStoreOwner_P_DB();
    	 size = ld.GetSize();
     }
     
     public void AddProduct(Product p) throws IOException  {
    	 LoadDB ld = new LoadDB();
    	 ListOfProducts = ld.setStoreOwner_P_DB();
    	 /*if (p.getPrice() > 100 ) {
    		 return false;
    	 }*/
    	 size = ld.GetSize();    	 
    	 ld.AddProductToStoreOwner_P_DB(p);
    	 ListOfProducts[size++]=p;
     }
     public void editProduct(String nameOftheProduct , int price)
     {
    	 Product x = new Product();
    	x= this.GetProduct(nameOftheProduct);
     }
     public boolean SearchProduct(String s) {
    	 for(int x=0;x<size;x++) {
    		 if(ListOfProducts[x].Name.equals(s)) {
    			 return true;
    		 }
    	 }
    	 return false;
     }
     public Product GetProduct(String s) {
    	 for(int x=0;x<size;x++) {
    		 if(ListOfProducts[x].Name.equals(s)) {
    			 return ListOfProducts[x];
    		 }
    	 }
    	 return null ;
     }
     public void DeleteProduct(String nameOftheProduct) throws IOException
     {
    	 LoadDB ld = new LoadDB();
    	 ld.DeleteTheProduct(nameOftheProduct);
     }
}
