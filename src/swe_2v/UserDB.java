package swe_2v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDB {
  
	private int size;
	private User Users[]= new User[10];
     
     public UserDB() {
    	 size=0;
    	 for(int x=0;x<10;x++) {
    		 Users[x]=new User();
    	 }
     } 
     public int Getsize() {
    	 return size;
     }
     public void set() throws IOException {
    	 File file=new File("");
         String s ;
         s = file.getAbsolutePath();
    	 FileReader fr = new FileReader(s+"\\"+"UserDB.txt");
         BufferedReader br = new BufferedReader(fr);
         //FileWriter fw = new FileWriter(, true);
         String s1;
         String list[];
         int x=0;
         while ((s1 = br.readLine()) != null) { // read a line
        	list = s1.split("/");
        	User obj = new User(list[0],list[1],list[2]);
           	Users[x]=obj;
        	x++;
        	size++;
         }
         br.close();
     }
     public void AddUser(User u) throws IOException {
    	 Users[size++]=u;
    	 File file=new File("");
         String s ;
         s = file.getAbsolutePath();
         FileWriter fw = new FileWriter(s+"\\"+"UserDB.txt", true);
         fw.write(u.getUsername()+"/"+u.getPassword()+"/"+u.getUsertype()+"\r\n");
         fw.flush();
         fw.close();
         System.out.println("Register Successfully");
     }
     public boolean SearchUser(User u) {
    	 for(int x=0;x<size;x++) {
    		 if(Users[x].getUsername().equals(u.getUsername())&&Users[x].getPassword().equals(u.getPassword())) {    			 
    			 return true;
    		 }
    	 }
    	 return false;
     }
}