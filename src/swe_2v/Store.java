package swe_2v;

public class Store {
     String Name;
     String Location;
     String Type;
     
     public Store() {
       	  Name="";
       	  Location="";
       	  Type="";
     }
     public Store(String name,String loc,String type) {
    	 Name=name;
    	 Location=loc;
    	 Type=type;
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
}
