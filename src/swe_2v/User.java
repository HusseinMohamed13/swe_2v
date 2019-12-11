package swe_2v;

public class User {
     private String Username;
     private String Password;
     private String Usertype;
     
     public User() {
    	  Username="";
    	  Password="";
    	  Usertype="";
     }
     public User(String username,String password,String usertype) {
   	  Username=username;
   	  Password=password;
      Usertype=usertype;
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
	
     
}