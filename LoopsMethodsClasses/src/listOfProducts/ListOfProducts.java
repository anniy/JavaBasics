package listOfProducts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListOfProducts {
	public static void main(String[] args) {
		try {
	        Scanner s = new Scanner(new File("./src/listOfProducts/Input.txt"));
	        PrintWriter p = new PrintWriter(new File("./src/listOfProducts/Output.txt"));
	        ArrayList<Product> products = new ArrayList<Product>();

	        while (s.hasNextLine()) {
	            String[] token = s.nextLine().split("\\s+", 2);
	            products.add(new Product(token[0], Float.parseFloat(token[1])));
	        }
	        Collections.sort(products, new ProductsComparator());
	        
	        for (Product product : products) {
	        	//System.out.println(product.ToStrig());
				p.write(product.ToStrig() + "\n");
			}
	        
	        s.close();
	        p.close();
	    } 
	    catch (FileNotFoundException e) {
	       System.out.println("Error");
	    }

	}
}