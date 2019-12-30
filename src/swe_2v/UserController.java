package swe_2v;

import java.io.IOException;
import java.util.Scanner;

public class UserController {

	public UserController() {

	}

	public boolean Login(User u, UserDBController ud) {
		if (ud.SearchUser(u)) {
			return true;
		} else {
			return false;
		}
	}

	public void Register(User u, UserDBController ud) throws IOException {
		ud.AddUser(u);
	}

	public boolean BuyProduct(String s) throws IOException {
		StoreOwnerController pd = new StoreOwnerController();
		pd.set();
		if (pd.SearchProduct(s)) {
			return true;
		}
		return false;
	}

	public boolean BuyProductFormSystem(String s) throws IOException {
		ProductController pd = new ProductController();
		pd.set();
		Product p = new Product();
		p.setName(s);
		if (pd.SearchProduct(p)) {
			return true;
		}
		return false;
	}
}
