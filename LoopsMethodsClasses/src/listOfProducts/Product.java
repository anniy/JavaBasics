package listOfProducts;

public class Product {
	String name;
	float price;
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public String ToStrig() {
		return price + " " + name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
