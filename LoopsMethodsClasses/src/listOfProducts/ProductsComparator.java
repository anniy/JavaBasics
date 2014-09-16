package listOfProducts;

import java.util.Comparator;

public class ProductsComparator implements Comparator<Product>{

	public int compare(Product p1, Product p2)
	{
		if (p1.getPrice() == p2.getPrice()) {
			
			return p1.getName().compareTo(p2.getName());
		}
		else if (p1.getPrice() > p2.getPrice()) {
			return -1;
		}
		else {
			return 1;
		} 
	}
}
