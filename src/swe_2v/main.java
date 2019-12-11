package swe_2v;

import java.io.IOException;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws IOException {
		while(true) {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Please enter 1 to login as customer or storeOwner:");
		System.out.println("Please enter 2 to register as customer or storeOwner:");
		System.out.println("Please enter 3 to addproduct as adminstrator:");
		System.out.println("Please enter 4 to addbrand as adminstrator:");
		System.out.println("Please enter 5 to addproduct as storeOwner:");
		System.out.println("Please enter 6 to addnewstore as storeOwner:");
		System.out.println("Please enter 7 to show statistics as storeOwner:");
		System.out.println("Please enter 8 to name search product :");
		
		x=sc.nextInt();
		switch(x) {
		case 1:
			Scanner sc1 = new Scanner(System.in);
			String s,s1;
			System.out.println("Please enter Username:");
			s=sc1.nextLine();
			System.out.println("Please enter Password:");
			s1=sc1.nextLine();
			User u = new User(s,s1,null);
			UserDB ud =new UserDB();
		    ud.set();
	 	    UserController uc = new UserController();
	 	    if(uc.Login(u, ud)) {
	 	    	System.out.println("Login Successfully");
	 	    }else {
	 	    	System.out.println("invaild Username or Password");
	 	    }
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			String str,str1,str2;
			System.out.println("Please enter Username:");
			str=sc2.nextLine();
			System.out.println("Please enter Password:");
			str1=sc2.nextLine();
			System.out.println("Please enter Usertype:");
			str2=sc2.nextLine();
			User u1 = new User(str,str1,str2);
			UserDB ud1 =new UserDB();
		    ud1.set();
	 	    UserController uc1 = new UserController();
	 	    uc1.Register(u1, ud1);
			break;
		case 3:
			Scanner sc3 = new Scanner(System.in);
			String st,st1,st2;
			int price;
			System.out.println("Please enter Product Name:");
			st=sc3.nextLine();
			System.out.println("Please enter ID:");
			st1=sc3.nextLine();
			System.out.println("Please enter Price:");
			price=sc3.nextInt();
			Scanner sc4 = new Scanner(System.in);
			System.out.println("Please enter Category:");
			st2=sc4.nextLine();
			System.out.println("Please enter BrandName:");
			String st3=sc4.nextLine();
			System.out.println("Please enter Quantity:");
			int st4=sc4.nextInt();
			Product p = new Product(st,st1,price,st2,st3,st4);
			AdminstratorController ac = new AdminstratorController();
			ac.AddProduct(p);
			break;
		case 4:
			Scanner sc5 = new Scanner(System.in);
			String s11,s12;
			System.out.println("Please enter Brand Name:");
			s11=sc5.nextLine();
			System.out.println("Please enter Category:");
			s12=sc5.nextLine();
			Brand b = new Brand(s11,s12);
			AdminstratorController ac1 = new AdminstratorController();
			ac1.AddBrand(b);
			break;
		case 5:
			Scanner sc6 = new Scanner(System.in);
			String s61,s62,s63;
			int price6;
			System.out.println("Please enter Product Name:");
			s61=sc6.nextLine();
			System.out.println("Please enter ID:");
			s62=sc6.nextLine();
			System.out.println("Please enter Price:");
			price6=sc6.nextInt();
			Scanner sc7 = new Scanner(System.in);
			System.out.println("Please enter Category:");
			s63=sc7.nextLine();
			System.out.println("Please enter BrandName:");
			String s6=sc7.nextLine();
			/*System.out.println("Please enter Quantity:");
			int s7=sc7.nextInt();
			*/
			//Product p1 = new Product(s61,s62,price6,s63,s6,s7);
			
			Product p1 = new Product(s61,s62,price6,s63,s6,0);
			
			StoreOwner so1 = new StoreOwner();
			so1.AddProduct(p1);
			break;
		case 6:
			Scanner sc8 = new Scanner(System.in);
			String s71,s72,s73;
			System.out.println("Please enter Store Name:");
			s71=sc8.nextLine();
			System.out.println("Please enter Location:");
			s72=sc8.nextLine();
			System.out.println("Please enter Type:");
			s73=sc8.nextLine();
			Store ss = new Store(s71,s72,s73);
			StoreOwner so2 = new StoreOwner();
			so2.AddStore(ss);
			break;
		case 7:
			StoreOwner so3 = new StoreOwner();
			so3.ShowStatistics();
			break;
		case 8:
			Scanner sc9 = new Scanner(System.in);
			System.out.println("Please enter name to search:");
			String s90=sc9.nextLine();
			UserController ur = new UserController();
			ur.BuyProduct(s90);
			break;
		default:			
		}
		}
	}
}