package swe_2v;

import java.io.IOException;
import java.util.Scanner;

public class UserController {
     
	 public UserController() {
		 
	 }
	 public boolean Login(User u,UserDB ud) {
		 if(ud.SearchUser(u)) {
			 return true;
		 }else {
		 return false;
		 }
	 }
	 public void Register(User u,UserDB ud) throws IOException {
		 ud.AddUser(u);
	 }
	 public void BuyProduct(String s) throws IOException {
		 StoreOwner_P_DB pd = new StoreOwner_P_DB();
		 Product p;
		 pd.set();
		 if(pd.SearchProduct(s)) {
			 p = pd.GetProduct(s);
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Please Enter Quantity");
			 int q = sc.nextInt();
			 if(q<=p.getQuantity()) {
			  Scanner sc1 = new Scanner(System.in);	 
			  System.out.println("Please Enter ShippingAddress");
			  String ShippingAddress;
			  ShippingAddress = sc1.nextLine();
			  System.out.println("Product will ship to you within 7 days");
			 }else {System.out.println("Out Of Stock");}
		 }else {
			 System.out.println("Not Found");
		 }
	 }
}
