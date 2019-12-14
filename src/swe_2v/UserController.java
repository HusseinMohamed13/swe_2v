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
	 public boolean BuyProduct(String s) throws IOException {
		 StoreOwner_P_DB pd = new StoreOwner_P_DB();
		 pd.set();
		 if(pd.SearchProduct(s)) {
			 return true;
	     }
		 return false;
	 }
}
