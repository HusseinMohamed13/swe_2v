package swe_2v;

import java.io.IOException;

import java.util.Scanner;

public class main {
	static UserDBController ud =new UserDBController();   
    static UserController uc = new UserController();
	static AdminstratorController ac = new AdminstratorController();
	static StoreOwner so = new StoreOwner();
	static Collaborators c = new Collaborators();
	static User u ;
	public static void main(String[] args) throws IOException {
		while(true) {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Please enter 1 to login as customer or storeOwner or collaborator:");
		System.out.println("Please enter 2 to register as customer or storeOwner:");
		System.out.println("Please enter 3 to addproduct as adminstrator:");
		System.out.println("Please enter 4 to addbrand as adminstrator:");
		System.out.println("Please enter 5 to add statistics as adminstrator:");
		
		x=sc.nextInt();
		switch(x) {
		case 1:
			Scanner sc1 = new Scanner(System.in);
			String s,s1,s2,s3;
			System.out.println("Please enter Username:");
			s=sc1.nextLine();
			System.out.println("Please enter Password:");
			s1=sc1.nextLine();
			System.out.println("Please enter UserType:");
			s2=sc1.nextLine();
			System.out.println("Please enter ID:");
			s3=sc1.nextLine();
		    u = new User(s,s1,s2,s3);
			ud.set();
	 	    if(uc.Login(u, ud)) {
	 	    	System.out.println("Login Successfully");
	 	    	if(u.getUsertype().equals("customer")) {
	 	    	    while(true) {	
	 	    		System.out.println("Please enter 1 to search product:");
	 	    		System.out.println("Please enter 2 to search product in System:");
	 	    		Scanner sc9 = new Scanner(System.in);
		 			int x1;
		 			x1 = sc9.nextInt();
		 			Scanner sc93 = new Scanner(System.in);
		 			switch(x1) {
		 			case 1:
	 				System.out.println("Please enter name to search:");
	 				String s90=sc93.nextLine();
	 				if(uc.BuyProduct(s90)) {
	 				    StoreOwnerController pd = new StoreOwnerController();
	 				    Product p2;
	 				    pd.set();
	 			     	p2 = pd.GetProduct(s90);
	 					Scanner sc10 = new Scanner(System.in);
	 				    System.out.println("Please Enter Quantity");
	 				    int q = sc.nextInt();
	 				    if(q<=p2.getQuantity()) {
	 				    u.setNumberOfbuyProducts(q);	
	 				 	Scanner sc121 = new Scanner(System.in);	 
	 			        System.out.println("Please Enter ShippingAddress");
	 			        String ShippingAddress;
	 		    	    ShippingAddress = sc121.nextLine();
	 		    	    int totalprice = p2.getPrice()*q;
	 		    	    if(q>=2) {
	 		    	      totalprice-=totalprice*0.1;	
	 		    	    }
	 		    	    if(u.getNumberOfbuyProducts()==0) {
	 		    	      totalprice-=totalprice*0.05; 	
	 		    	    }
	 		    	    System.out.println("Total Price :"+totalprice);
	 			        System.out.println("Product will ship to you within 7 days");
	 				    }else {System.out.println("Out Of Stock");}	
	 				}else {
	 				 System.out.println("Not Found");
	 			    }
	 				    break;
		 			case 2:
		 				System.out.println("Please enter name to search:");
		 				String s91=sc93.nextLine();
		 				ProductController pd1 = new ProductController();
		 				pd1.set();
		 				if(uc.BuyProductFormSystem(s91)) {
		 				    Product p2;
		 			     	p2 = pd1.GetProduct(s91);
		 					Scanner sc10 = new Scanner(System.in);
		 				    System.out.println("Please Enter Quantity");
		 				    int q = sc.nextInt();
		 				    if(q<=p2.getQuantity()) {
		 				    u.setNumberOfbuyProducts(q); 	
		 				 	Scanner sc121 = new Scanner(System.in);	 
		 			        System.out.println("Please Enter ShippingAddress");
		 			        String ShippingAddress;
		 		    	    ShippingAddress = sc121.nextLine();
		 		    	    int totalprice = p2.getPrice()*q;
		 		    	    if(q>=2) {
			 		    	      totalprice-=totalprice*0.1;	
			 		        }
			 		    	if(u.getNumberOfbuyProducts()==0) {
			 		    	      totalprice-=totalprice*0.05; 	
			 		    	}
		 		    	    System.out.println("Total Price :"+totalprice);
		 			        System.out.println("Product will ship to you within 7 days");
		 				    }else {System.out.println("Out Of Stock");}	
		 				}else {
		 				 System.out.println("Not Found");
		 			    }
		 				break;
		 			}
	 	    		}
	 	    	}
	 	    	else if(u.getUsertype().equals("storeowner")) {
	 	    		boolean exit = false;
	 	    		while(!exit) {
	 	    			
	 	    		System.out.println("Please enter 1 to addproduct :");
			 		System.out.println("Please enter 2 to addnewstore :");
			 		System.out.println("Please enter 3 to show statistics :");	
			 		System.out.println("Please enter 4 to add Collabrator :");
			 		System.out.println("Please enter 5 to search product in System :");
			 		System.out.println("Please enter 6 to undo collaborator product action :");
			 		System.out.println("Please enter 7 to undo collaborator offer action :");
			 		System.out.println("Please enter 8 to Exit:");
			 		Scanner sc91 = new Scanner(System.in);
		 			int x2;
		 			x2 = sc91.nextInt();
		 			switch(x2) {
		 			case 1:
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
		 				Product p1 = new Product(s61,s62,price6,s63,s6,0);
		 				if(so.AddProduct(p1)) {
		 				System.out.println("Please Enter Quantity");
		 				int q = sc.nextInt(); 
		 				p1.setQuantity(q);
		 				StoreOwnerController pd = new StoreOwnerController();
		 				pd.AddProduct(p1);
		 				System.out.println("Product Added");	
		 				}else {
		 					System.out.println("Permission denied");
		 				}
		 				break;
		 			case 2:
		 				Scanner sc8 = new Scanner(System.in);
		 				String s71,s72,s73;
		 				System.out.println("Please enter Store Name:");
		 				s71=sc8.nextLine();
		 				System.out.println("Please enter Location:");
		 				s72=sc8.nextLine();
		 				System.out.println("Please enter Type:");
		 				s73=sc8.nextLine();
		 				Store ss = new Store(s71,s72,s73,u.getID());
		 				if(so.AddStore(ss)) {
		 					StoreController obj = new StoreController();
		 					obj.AddStore(ss); 
		 					System.out.println("Store added");
		 					}else {
		 						System.out.println("Permission denied");
		 					}
		 				break;
		 			case 3:
		 				so.ShowStatistics();
		 				break;
		 			case 4:
		 				System.out.println("Enter Collaborator Id");
		 				Scanner sc87 = new Scanner(System.in);
		 				String s23 = sc87.next();
		 				Collaborators c1 = new Collaborators();
		 				c1.setName(s23);
		 				System.out.println("Enter Store Name");
		 				s23 = sc87.next();
		 				Store s31 = new Store();
		 				s31.setName(s23);
		 				so.AddCollaborator(c1, s31);
		 				break;
		 			case 5:
		 				System.out.println("Please enter name to search:");
		 				Scanner sc93 = new Scanner(System.in);
						String s90=sc93.nextLine();
		 				if(uc.BuyProduct(s90)) {
		 				    ProductController pd = new ProductController();
		 				    Product p2;
		 				    pd.set();
		 			     	p2 = pd.GetProduct(s90);
		 					Scanner sc10 = new Scanner(System.in);
		 				    System.out.println("Please Enter Quantity");
		 				    int q = sc.nextInt();
		 				    if(q<=p2.getQuantity()) {
		 				    u.setNumberOfbuyProducts(q);	
		 				 	Scanner sc121 = new Scanner(System.in);	 
		 			        System.out.println("Please Enter ShippingAddress");
		 			        String ShippingAddress;
		 		    	    ShippingAddress = sc121.nextLine();
		 		    	    int totalprice = p2.getPrice()*q;
		 		    	    if(q>=2) {
			 		    	      totalprice-=totalprice*0.1;	
			 		        }
			 		    	if(u.getNumberOfbuyProducts()==0) {
			 		    	      totalprice-=totalprice*0.05; 	
			 		    	}
			 		    	totalprice-=totalprice*0.3;
		 		    	    System.out.println("Total Price :"+totalprice);
		 			        System.out.println("Product will ship to you within 7 days");
		 				    }else {System.out.println("Out Of Stock");}	
		 				}else {
		 				 System.out.println("Not Found");
		 			    }
		 				break;
		 			case 6:
		 				String history[] = new String[10];
		 				history = c.getHistory();
		 				for(int i =0 ;i<history.length ; i++) {
		 					System.out.println(i+" : "+history[i]);
		 				}
		 				System.out.println("Please index to undo this action:");
		 				Scanner sc94 = new Scanner(System.in);
						int indx = sc94.nextInt();
		 				so.UndoCollaboratorPrductAction(c, indx);
		 				exit = true;
		 			case 7:
		 				String history1[] = new String[10];
		 				history1 = c.getHistory();
		 				for(int i =0 ;i<history1.length ; i++) {
		 					System.out.println(i+" : "+history1[i]);
		 				}
		 				System.out.println("Please index to undo this action:");
		 				Scanner sc95 = new Scanner(System.in);
						int indx1 = sc95.nextInt();
		 				so.UndoCollaboratorOfferAction(c, indx1);
		 				exit = true;
		 			case 8:
		 				exit = true;	
		 				break;
		 			default:	
		 			}
	 	    	}
	 	      }
	 	    else if(u.getUsertype().equals("collaborator")) {
	 	    	boolean exit = false;
 	    		while(!exit) {
 	    		System.out.println("Please enter 1 to add product :");
		 		System.out.println("Please enter 2 to edit product :");
		 		System.out.println("Please enter 3 to delete product :");
		 		System.out.println("Please enter 4 to add offer :");
		 		System.out.println("Please enter 5 to edit offer :");
		 		System.out.println("Please enter 6 to delete offer :");
		 		System.out.println("Please enter 7 to Exit:");
		 		Scanner sc91 = new Scanner(System.in);
	 			int x2;
	 			x2 = sc91.nextInt();
	 			switch(x2) {
	 			case 1:
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
	 				System.out.println("Please Enter Quantity");
	 				int q = sc.nextInt(); 
	 				Product p1 = new Product(s61,s62,price6,s63,s6,q);
	 				if(c.AddProduct(p1)) {
	 				System.out.println("Product Added");	
	 				}else {
	 					System.out.println("Permission denied");
	 				}
	 				break;
	 			case 2:
	 				Scanner sc73 = new Scanner(System.in);
	 				System.out.println("Please enter Product name:");
	 				String nameOftheProduct=sc73.nextLine();
	 				System.out.println("Please enter Price:");
	 				int price = sc73.nextInt();
	 				c.editProduct(nameOftheProduct, price);
	 				break;
	 			case 3:
	 				Scanner sc74 = new Scanner(System.in);
	 				System.out.println("Please enter Product name:");
	 			    nameOftheProduct = sc74.nextLine();
	 			    c.deleteProduct(nameOftheProduct);
	 				break;
	 			case 4:
	 				Scanner sc75 = new Scanner(System.in);
	 				System.out.println("Please enter Product name:");
	 				nameOftheProduct=sc75.nextLine();
	 				System.out.println("Please enter offer:");
	 				int offer = sc75.nextInt();
	 				c.AddOffer(nameOftheProduct, offer);
	 				break;
	 			case 5:
	 				Scanner sc76 = new Scanner(System.in);
	 				System.out.println("Please enter Product name:");
	 				nameOftheProduct=sc76.nextLine();
	 				System.out.println("Please enter offer:");
	 				int newoffer = sc76.nextInt();
	 				c.editOffer(nameOftheProduct, newoffer);
	 				break;
	 			case 6:
	 				Scanner sc77 = new Scanner(System.in);
	 				System.out.println("Please enter Product name:");
	 				nameOftheProduct=sc77.nextLine();
	 				c.deleteOffer(nameOftheProduct);
	 				break;
	 			case 7:
	 				exit = true;
	 				break;
	 			default:
	 				break;
	 			}
	 	       } 
	 	        }
	 	    }else {
	 	    	System.out.println("invaild Username or Password");
	 	    }
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			String str,str1,str2,str3;
			System.out.println("Please enter Username:");
			str=sc2.nextLine();
			System.out.println("Please enter Password:");
			str1=sc2.nextLine();
			System.out.println("Please enter Usertype:");
			str2=sc2.nextLine();
			System.out.println("Please enter ID:");
			str3=sc2.nextLine();
			u = new User(str,str1,str2,str3);
		    ud.set();
	 	    uc.Register(u, ud);
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
			ac.AddProduct(p);
			System.out.println("Product Added");
			break;
		case 4:
			Scanner sc5 = new Scanner(System.in);
			String s11,s12;
			System.out.println("Please enter Brand Name:");
			s11=sc5.nextLine();
			System.out.println("Please enter Category:");
			s12=sc5.nextLine();
			Brand b = new Brand(s11,s12);
			ac.AddBrand(b);
			break;
		case 5:
			ac.AddStatistics(so);
			break;	
		default:			
		}
		}
	}
}
