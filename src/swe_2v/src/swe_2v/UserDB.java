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
    	 LoadDB ld = new LoadDB();
    	 Users = ld.setUserDB();
    	 size = ld.GetSize();
     }
     public void AddUser(User u) throws IOException {
    	 LoadDB ld = new LoadDB();
    	 Users = ld.setUserDB();
    	 size = ld.GetSize();
    	 ld.AddUserToUserDB(u);
    	 Users[size++]=u;
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