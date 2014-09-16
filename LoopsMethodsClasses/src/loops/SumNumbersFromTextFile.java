package loops;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumNumbersFromTextFile {
	public static void main(String[] args) {
	    try {
	        Scanner s = new Scanner(new File("./src/loops/Input.txt"));
	        int sum = 0;
	        while (s.hasNextLine()) {
	            int n = s.nextInt();
	            sum += n;
	        }
	        System.out.println(sum);
	        s.close();
	    } 
	    catch (FileNotFoundException e) {
	       System.out.println("Error");
	    }
	}
}
