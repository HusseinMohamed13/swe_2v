package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BrandDB {

	private int size;
	 private Brand ListOfBrands[]= new Brand[10];
    
    public BrandDB() {
   	 size=0;
   	 for(int x=0;x<10;x++) {
   		 ListOfBrands[x]=new Brand();
   	 }
    }
    public void set() throws IOException {
   	 File file=new File("");
        String s ;
        s = file.getAbsolutePath();
   	 FileReader fr = new FileReader(s+"\\"+"BrandsDB.txt");
        BufferedReader br = new BufferedReader(fr);
        //FileWriter fw = new FileWriter(, true);
        String s1;
        int x=0;
        String list[];
        while ((s1 = br.readLine()) != null) { // read a line
       	list = s1.split("/");
       	Brand obj = new Brand(list[0],list[1]);
       	ListOfBrands[x++]=obj;
       	size++;
        }
        br.close();
    }
    
    public void AddBrand(Brand b) throws IOException  {
   	 ListOfBrands[size++]=b;
   	 File file=new File("");
        String s ;
        s = file.getAbsolutePath();
        FileWriter fw = new FileWriter(s+"\\"+"BrandDB.txt", true);
        fw.write(b.getName()+"/"+b.getCategory()+"\r\n");
        fw.flush();
        fw.close();
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
