package swe_2v;

public class Product {
     String Name;
     String ID;
     int Price;
     String Category;
     String BrandName;
     int Quantity;
     
     public Product() {
    	  Name="";
    	  ID="";
    	  Price=0;
    	  Category="";
    	  BrandName="";
    	  Quantity=0;
     }
     public Product(String name,String id,int price,String category,String brandname,int quantity) {
    	  Name=name;
    	  ID=id;
    	  Price=price;
    	  Category=category;
    	  BrandName=brandname;
    	  Quantity=quantity;
     }
     public void setName(String name) {
 		Name = name;
 	 }
	 public String getName() {
		return Name;
	 }
	 public void setID(String id) {
			ID = id;
     }
	 public String getID() {
		return ID;
	 }
	 public void setPrice(int price) {
			Price = price;
	 }
	 public int getPrice() {
		return Price;
	 }
	 public void setCategory(String category) {
		Category = category;
	 }
	 public String getCategory() {
		return Category;
	 }
	 public void setBrandName(String brandname) {
			BrandName = brandname;
	 }
	 public String getBrandName() {
			return BrandName;
	 }
	 public void setQuantity(int quantity) {
			Quantity = quantity;
	 }
	 public int getQuantity() {
		return Quantity;
	 }
	 
}