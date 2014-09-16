package listOfProducts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderOfProducts {
	public static void main(String[] args) {
		float totalPrice = 0f;
		try {
	        Scanner productsScan = new Scanner(new File("./src/listOfProducts/Products.txt"));
	        Scanner orderScan = new Scanner(new File("./src/listOfProducts/Order.txt"));
	        
	        PrintWriter p = new PrintWriter(new File("./src/listOfProducts/Output.txt"));
	        ArrayList<Product> products = new ArrayList<Product>();

	        while (productsScan.hasNextLine()) {
	            String[] token = productsScan.nextLine().split("\\s+", 2);
	            products.add(new Product(token[0], Float.parseFloat(token[1])));
	        }
	        
	        while (orderScan.hasNextLine()) {
	            String[] token = orderScan.nextLine().split("\\s+", 2);
	            for(Product product : products) {
	            	if (product.getName().equals(token[1])) {
	            		totalPrice += product.getPrice() * Float.parseFloat(token[0]);
	            	}
	            }
	        }
	        
	        p.write(String.format("%.1f", totalPrice));
	        
	        productsScan.close();
	        orderScan.close();
	        p.close();
	    } 
	    catch (FileNotFoundException e) {
	       System.out.println("Error");
	    }
	}
}
