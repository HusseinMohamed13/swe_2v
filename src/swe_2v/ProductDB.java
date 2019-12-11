package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductDB {
	 private int size;
	 private Product ListOfProducts[]= new Product[10];
     
     public ProductDB() {
    	 size=0;
    	 for(int x=0;x<10;x++) {
    		 ListOfProducts[x]=new Product();
    	 }
     }
     public int Getsize() {
    	 return size;
     }
     public void set() throws IOException {
    	 File file=new File("");
         String s ;
         s = file.getAbsolutePath();
    	 FileReader fr = new FileReader(s+"\\"+"ProductDB.txt");
         BufferedReader br = new BufferedReader(fr);
         //FileWriter fw = new FileWriter(, true);
         String s1;
         int x=0;
         String list[];
         while ((s1 = br.readLine()) != null) { // read a line
        	list = s1.split("/");
        	int price = Integer.parseInt(list[2]);
        	int q = Integer.parseInt(list[5]);
        	Product obj = new Product(list[0],list[1],price,list[3],list[4],q);
        	ListOfProducts[x++]=obj;
        	size++;
         }
         br.close();
     }
     
     public void AddProduct(Product p) throws IOException  {
    	 ListOfProducts[size++]=p;
    	 File file=new File("");
         String s ;
         s = file.getAbsolutePath();
         FileWriter fw = new FileWriter(s+"\\"+"ProductDB.txt", true);
         String str = Integer.toString(p.getPrice()); 
         String str1 = Integer.toString(p.getQuantity());
         fw.write(p.getName()+"/"+p.getID()+"/"+str+"/"+p.getCategory()+"/"+p.getBrandName()+"/"+str1+"\r\n");
         fw.flush();
         fw.close();
     }
     public boolean SearchProduct(Product p) {
    	 for(int x=0;x<size;x++) {
    		 if(ListOfProducts[x].getName().equals(p.getName())) {
    			 return true;
    		 }
    	 }
    	 return false;
     }     
}
