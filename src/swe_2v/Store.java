package swe_2v;

import java.io.IOException;

public class Store {
     private String Name;
     private String Location;
     private String Type;
     private String StoreOwnerID;
     private String []collaborators;  
     private int size;     
     public Store() {
       	  Name="";
       	  Location="";
       	  Type="";
       	  StoreOwnerID="";
       	  collaborators = new String[10];
       	  size=0;
     }
     public Store(String name,String loc,String type,String storeownerid) {
    	 Name=name;
    	 Location=loc;
    	 Type=type;
    	 StoreOwnerID=storeownerid;
    	 size=0;
     }
     public void AddCollaborator(Collaborators c,Store s) throws IOException {
 		 StoreDB sd  =new StoreDB();
 		 sd.set();
 		 sd.AddCollabortors(c,s.getName());
 	 }
     public void setName(String name) {
  		Name = name;
  	 }
     public String getName() {
    	 return Name;
     }
     public void setLocation(String loc) {
  		Location = loc;
  	 }
     public String getLocation() {
    	 return Location;
     }
     public void setType(String type) {
   		Type = type;
   	 }
     public String getType() {
     	 return Type;
     }
     public void setStoreOwnerID(String storeownerid) {
    	 StoreOwnerID = storeownerid;
   	 }
     public String getStoreOwnerID() {
      	 return StoreOwnerID;
     }
     public void setcollaborators(String collaborators) {
    	 this.collaborators[size++] = collaborators;
   	 }
     public String getcollaborators() {
      	 return collaborators[size];
     }
}