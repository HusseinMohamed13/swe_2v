package swe_2v;

public class Brand {
	String Name;
    String Category;
    //default constructor
    public Brand() {
   	  Name="";
   	  Category="";
    }
	//constructor to to brand
    public Brand(String name,String category) {
   	  Name=name;
   	  Category=category;
    }
	//set function
    public void setName(String name) {
		Name = name;
	 }
	//get nam function
	 public String getName() {
		return Name;
	 }
	//set category function
	 public void setCategory(String category) {
		Category = category;
	 }
	//get category function
	 public String getCategory() {
		return Category;
	 }
	 
}
