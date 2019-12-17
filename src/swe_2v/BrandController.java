package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BrandController {

	private int size;
	 private Brand ListOfBrands[]= new Brand[10];
    
    public BrandController() {
   	 size=0;
   	 for(int x=0;x<10;x++) {
   		 ListOfBrands[x]=new Brand();
   	 }
    }
    public void set() throws IOException {
        LoadDB ld = new LoadDB();
        ListOfBrands = ld.setBrandDB();
        size = ld.GetSize();
    }
    
    public void AddBrand(Brand b) throws IOException  {
   	    LoadDB ld = new LoadDB();
   	    ListOfBrands = ld.setBrandDB();
        size = ld.GetSize();
        ld.AddToBrandDB(b);
   	    ListOfBrands[size++]=b;
    }
   /* public boolean SearchBrand(Brand b) {
   	 for(int x=0;x<size;x++) {
   		 if(ListOfBrands[x]==b) {
   			 return true;
   		 }
   	 }
   	 return false;
    }*/
    
}