package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StoreDB {
	private int size;
	 private Store ListOfStores[]= new Store[10];
    
    public StoreDB() {
   	 size=0;
   	 for(int x=0;x<10;x++) {
   		 ListOfStores[x]=new Store();
   	 }
    }
    public void set() throws IOException {
   	 File file=new File("");
        String s ;
        s = file.getAbsolutePath();
   	 FileReader fr = new FileReader(s+"\\"+"StoresDB.txt");
        BufferedReader br = new BufferedReader(fr);
        //FileWriter fw = new FileWriter(, true);
        String s1;
        int x=0;
        String list[];
        while ((s1 = br.readLine()) != null) { // read a line
       	list = s1.split("/");
       	Store obj = new Store();
       	ListOfStores[x++]=obj;
       	size++;
        }
        br.close();
    }
    
    public void AddStore(Store s) throws IOException  {
   	 ListOfStores[size++]=s;
   	 File file=new File("");
        String s1 ;
        s1 = file.getAbsolutePath();
        FileWriter fw = new FileWriter(s1+"\\"+"StoresDB.txt", true);
        fw.write(s.getName()+"/"+s.getLocation()+"/"+s.getType()+"\r\n");
        fw.flush();
        fw.close();
    }
}
