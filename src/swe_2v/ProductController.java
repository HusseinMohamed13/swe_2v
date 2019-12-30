package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductController {
	private int size;
	private Product ListOfProducts[] = new Product[10];

	public ProductController() {
		size = 0;
		for (int x = 0; x < 10; x++) {
			ListOfProducts[x] = new Product();
		}
	}

	public int Getsize() {
		return this.size;
	}

	public void set() throws IOException {
		LoadDB ld = new LoadDB();
		ListOfProducts = ld.setProductDB();
		size = ld.GetSize();
	}

	public void AddProduct(Product p) throws IOException {
		ListOfProducts[size++] = p;
		LoadDB ld = new LoadDB();
		ld.AddToProductDB(p);
	}

	public boolean SearchProduct(Product p) {
		for (int x = 0; x < size; x++) {
			if (ListOfProducts[x].getName().equals(p.getName())) {
				return true;
			}
		}
		return false;
	}

	public Product GetProduct(String s) {
		for (int x = 0; x < size; x++) {
			if (ListOfProducts[x].Name.equals(s)) {
				return ListOfProducts[x];
			}
		}
		return null;
	}
}