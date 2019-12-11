package swe_2v;

import java.io.IOException;
import java.util.Random;

public class AdminstratorController {
     
	 public AdminstratorController() {
		 
	 } 
	 public void AddProduct(Product p) throws IOException {
		  ProductDB obj = new ProductDB();
		  obj.AddProduct(p);
	 }
	 public void AddBrand(Brand b) throws IOException {
		  BrandDB obj = new BrandDB();
		  obj.AddBrand(b);
	 }
	 public boolean PermissionStore(Store s) {
		 if(s.getName().length()>3) {
			 return true;
		 }
		 return false;
	 }
	 public boolean PermissionProduct(Product p) throws IOException {
		 ProductDB pd = new ProductDB();
		 pd.set();
		 if(pd.SearchProduct(p)) {
			 return true;
		 }else {
		 return false;
		 }
	 }
	public void AddStatistics() throws IOException {
		UserDB ud = new UserDB();
		ud.set();
		int numberOfusers=ud.Getsize();
		ProductDB pd = new ProductDB();
		ud.set();
		int numberOfproducts=pd.Getsize();
	
		Random rand = new Random();
		int []ArrayofOffers = null;
		for(int x=0;x<numberOfproducts/2;x++) {
			ArrayofOffers[x]=rand.nextInt(100);
		}
		
	} 
}
