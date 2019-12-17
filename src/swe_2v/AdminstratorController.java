package swe_2v;

import java.io.IOException;
import java.util.Random;

public class AdminstratorController {
     
	 public AdminstratorController() {
		 
	 } 
	 public void AddProduct(Product p) throws IOException {
		  ProductController obj = new ProductController();
		  obj.AddProduct(p);
	 }
	 public void AddBrand(Brand b) throws IOException {
		  BrandController obj = new BrandController();
		  obj.AddBrand(b);
	 }
	 public boolean PermissionStore(Store s) {
		 if(s.getName().length()>3) {
			 return true;
		 }
		 return false;
	 }
	 public boolean PermissionProduct(Product p) throws IOException {
		 ProductController pd = new ProductController();
		 pd.set();
		 if(pd.SearchProduct(p)) {
			 return true;
		 }else {
		 return false;
		 }
	 }
	public void AddStatistics(StoreOwner so) throws IOException {
		UserDBController ud = new UserDBController();
		ud.set();
		int numberOfusers=ud.Getsize();
		ProductController pd = new ProductController();
		pd.set();
		int numberOfproducts=pd.Getsize();
		Random rand = new Random();
		int soldoutproducts = rand.nextInt(numberOfproducts/4);
		System.out.println(numberOfusers+" "+numberOfproducts+" "+soldoutproducts);
		so.SetStatistics(numberOfusers, numberOfproducts, soldoutproducts);
	} 
}
