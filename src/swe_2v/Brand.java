package swe_2v;

public class Brand {
	String Name;
    String Category;
    
    public Brand() {
   	  Name="";
   	  Category="";
    }
    public Brand(String name,String category) {
   	  Name=name;
   	  Category=category;
    }
    public void setName(String name) {
		Name = name;
	 }
	 public String getName() {
		return Name;
	 }
	 public void setCategory(String category) {
		Category = category;
	 }
	 public String getCategory() {
		return Category;
	 }
	 
}