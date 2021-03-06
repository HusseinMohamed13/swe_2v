package swe_2v;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadDB {
	private int size;

	public int GetSize() {
		return this.size;
	}

	public Product[] setProductDB() throws IOException {
		size = 0;
		Product[] ListOfProducts = new Product[10];
		for (int x = 0; x < 10; x++) {
			ListOfProducts[x] = new Product();
		}
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileReader fr = new FileReader(s + "\\" + "ProductDB.txt");
		BufferedReader br = new BufferedReader(fr);
		// FileWriter fw = new FileWriter(, true);
		String s1;
		int x = 0;
		String list[];
		while ((s1 = br.readLine()) != null) { // read a line
			list = s1.split("/");
			int price = Integer.parseInt(list[2]);
			int q = Integer.parseInt(list[5]);
			Product obj = new Product(list[0], list[1], price, list[3], list[4], q);
			ListOfProducts[x++] = obj;
			size++;
		}
		br.close();
		return ListOfProducts;
	}

	public void AddToProductDB(Product p) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "ProductDB.txt", true);
		String str = Integer.toString(p.getPrice());
		String str1 = Integer.toString(p.getQuantity());
		fw.write(p.getName() + "/" + p.getID() + "/" + str + "/" + p.getCategory() + "/" + p.getBrandName() + "/" + str1
				+ "\r\n");
		fw.flush();
		fw.close();
	}

	public Brand[] setBrandDB() throws IOException {
		size = 0;
		Brand[] ListOfBrands = new Brand[10];
		for (int x = 0; x < 10; x++) {
			ListOfBrands[x] = new Brand();
		}
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileReader fr = new FileReader(s + "\\" + "BrandsDB.txt");
		BufferedReader br = new BufferedReader(fr);
		// FileWriter fw = new FileWriter(, true);
		String s1;
		int x = 0;
		String list[];
		while ((s1 = br.readLine()) != null) { // read a line
			list = s1.split("/");
			Brand obj = new Brand(list[0], list[1]);
			ListOfBrands[x++] = obj;
			size++;
		}
		br.close();
		return ListOfBrands;
	}

	public void AddToBrandDB(Brand b) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "BrandDB.txt", true);
		fw.write(b.getName() + "/" + b.getCategory() + "\r\n");
		fw.flush();
		fw.close();
	}

	public Store[] setStoreDB() throws IOException {
		size = 0;
		Store[] ListOfStores = new Store[10];
		for (int x = 0; x < 10; x++) {
			ListOfStores[x] = new Store();
		}
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileReader fr = new FileReader(s + "\\" + "StoresDB.txt");
		BufferedReader br = new BufferedReader(fr);
		// FileWriter fw = new FileWriter(, true);
		String s1;
		int x = 0;
		String list[];
		while ((s1 = br.readLine()) != null) { // read a line
			list = s1.split("/");
			Store obj = new Store(list[0], list[1], list[2], list[3]);
			if (list.length > 4) {
				int x1 = 4;
				while (x1 < list.length) {
					obj.setcollaborators(list[x1]);
					x1++;
				}
			}
			ListOfStores[x++] = obj;
			size++;
		}
		br.close();
		return ListOfStores;
	}

	public void AddToStoreDB(Store s) throws IOException {
		File file = new File("");
		String s1;
		s1 = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s1 + "\\" + "StoresDB.txt", true);
		fw.write(s.getName() + "/" + s.getLocation() + "/" + s.getType() + "/" + s.getStoreOwnerID() + "\r\n");
		fw.flush();
		fw.close();
	}

	public void AddCollabortors(Collaborators c, String s) throws IOException {
		File file = new File("");
		String s1;
		s1 = file.getAbsolutePath();
		FileReader fr = new FileReader(s1 + "\\" + "StoresDB.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(s1 + "\\" + "StoresDB.txt", true);
		String list[], s2;
		while ((s2 = br.readLine()) != null) { // read a line
			list = s2.split("/");
			if (list[0].equals(s)) {
				fw.write("/" + c.getName());
				fw.flush();
				fw.close();
				break;
			}
		}
		br.close();
	}

	public Product[] setStoreOwner_P_DB() throws IOException {
		size = 0;
		Product[] ListOfProducts = new Product[10];
		for (int x = 0; x < 10; x++) {
			ListOfProducts[x] = new Product();
		}
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileReader fr = new FileReader(s + "\\" + "StoreOwner_P_DB.txt");
		BufferedReader br = new BufferedReader(fr);
		// FileWriter fw = new FileWriter(, true);
		String s1;
		int x = 0;
		String list[];
		while ((s1 = br.readLine()) != null) { // read a line
			list = s1.split("/");
			if (list.length > 1) {
				int price = Integer.parseInt(list[2]);
				int Quantity = Integer.parseInt(list[5]);
				Product obj = new Product(list[0], list[1], price, list[3], list[4], Quantity);
				ListOfProducts[x++] = obj;
				size++;
			}
		}
		br.close();
		return ListOfProducts;
	}

	public void AddProductToStoreOwner_P_DB(Product p) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "StoreOwner_P_DB.txt", true);
		String str = Integer.toString(p.getPrice());
		String str1 = Integer.toString(p.getQuantity());
		fw.write(p.getName() + "/" + p.getID() + "/" + str + "/" + p.getCategory() + "/" + p.getBrandName() + "/" + str1
				+ "\r\n");
		fw.flush();
		fw.close();
	}

	public User[] setUserDB() throws IOException {
		User[] Users = new User[10];
		size = 0;
		for (int x = 0; x < 10; x++) {
			Users[x] = new User();
		}
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileReader fr = new FileReader(s + "\\" + "UserDB.txt");
		BufferedReader br = new BufferedReader(fr);
		// FileWriter fw = new FileWriter(, true);
		String s1;
		String list[];
		int x = 0;
		while ((s1 = br.readLine()) != null) { // read a line
			list = s1.split("/");
			User obj = new User(list[0], list[1], list[2], list[3]);
			Users[x] = obj;
			x++;
			size++;
		}
		br.close();
		return Users;
	}

	public void AddUserToUserDB(User u) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "UserDB.txt", true);
		fw.write(u.getUsername() + "/" + u.getPassword() + "/" + u.getUsertype() + "/" + u.getID() + "\r\n");
		fw.flush();
		fw.close();
		System.out.println("Register Successfully");
	}

	public void AddtohistoryDB(String[] history) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "historyDB.txt", false);
		for (int i = 0; i < history.length; i++) {
			fw.write(history[i] + "\r\n");
		}
		fw.flush();
		fw.close();
	}

	public void DeleteTheProduct(String nameOftheProduct) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		File inputFile = new File("StoreOwner_P_DB.txt");
		FileReader fr = new FileReader(s + "\\" + "StoreOwner_P_DB.txt");
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		String list[] = new String[10];
		int x = 0;
		while ((currentLine = br.readLine()) != null) {
			list[x] = currentLine;
			x++;
		}
		fr.close();
		inputFile.delete();

		File tempFile = new File("StoreOwner_P_DB.txt");
		FileWriter fw = new FileWriter(s + "\\" + "StoreOwner_P_DB.txt", true);
		String[] list2 = new String[10];
		for (int i = 0; i < x; i++) {
			System.out.println(list[i]);
			list2 = list[i].split("/");
			if (list2[0].equals(nameOftheProduct)) {
				continue;
			} else {
				fw.write(list[i]);
				fw.write("\r\n");
			}
		}
		fw.flush();
		fw.close();
	}

	public void editProduct(String nameOftheProduct, int Price) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		File inputFile = new File("StoreOwner_P_DB.txt");
		FileReader fr = new FileReader(s + "\\" + "StoreOwner_P_DB.txt");
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		String list[] = new String[10];
		int x = 0;
		while ((currentLine = br.readLine()) != null) {
			list[x] = currentLine;
			x++;
		}
		fr.close();
		inputFile.delete();

		File tempFile = new File("StoreOwner_P_DB.txt");
		FileWriter fw = new FileWriter(s + "\\" + "StoreOwner_P_DB.txt", true);
		String[] list2 = new String[10];
		for (int i = 0; i < x; i++) {
			list2 = list[i].split("/");
			if (list2[0].equals(nameOftheProduct)) {
				String str1 = Integer.toString(Price);
				fw.write(list2[0] + "/" + list2[1] + "/" + str1 + "/" + list2[3] + "/" + list2[4] + "/" + list2[5] + "\r\n");
			} else {
				fw.write(list[i]);
				fw.write("\r\n");
			}
		}
		fw.flush();
		fw.close();
	}

	public void addOffer(String nameOftheProduct, int Offer) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		FileWriter fw = new FileWriter(s + "\\" + "Offer.txt", true);
		fw.write(nameOftheProduct + "/" + Offer);

	}

	public int editOffer(String nameOftheProduct, int Offer) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		File inputFile = new File("Offer.txt");
		FileReader fr = new FileReader(s + "\\" + "Offer.txt");
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		String list[] = new String[10];
		int x = 0;
		while ((currentLine = br.readLine()) != null) {
			list[x] = currentLine;
			x++;
		}
		fr.close();
		inputFile.delete();

		int oldOffer = 0;
		File tempFile = new File("Offer.txt");
		FileWriter fw = new FileWriter(s + "\\" + "Offer.txt", true);
		String[] list2 = new String[10];
		for (int i = 0; i < x; i++) {
			System.out.println(list[i]);
			list2 = list[i].split("/");
			if (list2[0].equals(nameOftheProduct)) {
				oldOffer = Integer.parseInt(list2[1]);
			    oldOffer = Offer;
			    list2[1] = Integer.toString(oldOffer);
				fw.write(list2[0]+"/"+list2[1]);
				fw.write("\r\n");
			} else {
				fw.write(list[i]);
				fw.write("\r\n");
			}
		}
		fw.flush();
		fw.close();
		return oldOffer;
	}

	public int deleteOffer(String nameOftheProduct) throws IOException {
		File file = new File("");
		String s;
		s = file.getAbsolutePath();
		File inputFile = new File("Offer.txt");
		FileReader fr = new FileReader(s + "\\" + "Offer.txt");
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		String list[] = new String[10];
		int x = 0;
		while ((currentLine = br.readLine()) != null) {
			list[x] = currentLine;
			x++;
		}
		fr.close();
		inputFile.delete();

		int oldOffer = 0;
		File tempFile = new File("Offer.txt");
		FileWriter fw = new FileWriter(s + "\\" + "Offer.txt", true);
		String[] list2 = new String[10];
		for (int i = 0; i < x; i++) {
			System.out.println(list[i]);
			list2 = list[i].split("/");
			if (!list2[0].equals(nameOftheProduct)) {
				fw.write(list[i]);
				fw.write("\r\n");
			} else {
				oldOffer = Integer.parseInt(list[1]);
			}
		}
		fw.flush();
		fw.close();
		return oldOffer;

	}

}
