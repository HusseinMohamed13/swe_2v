package swe_2v;

public class User {
     private String Username;
     private String Password;
     private String Usertype;
     private String ID;
     
     
     public User() {
    	  Username="";
    	  Password="";
    	  Usertype="";
    	  ID="";
     }
     public User(String username,String password,String usertype,String id) {
   	  Username=username;
   	  Password=password;
      Usertype=usertype;
      ID=id;
     }
     public void setUsername(String username) {
 		Username = username;
 	 }
	 public String getUsername() {
		return Username;
	 }
	 public void setPassword(String password) {
			Password = password;
	 }
	 public String getPassword() {
		return Password;
	 }
	 public void setUsertype(String usertype) {
		Usertype = usertype;
	 } 
	 public String getUsertype() {
		return Usertype;
	 }
	 public void setID(String id) {
			ID = id;
   	 } 
	 public String getID() {
			return ID;
	 }
	     
}