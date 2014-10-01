package javaCollections;

import java.util.Scanner;
import java.util.regex.*;

public class _06_CountSpecifiedWord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine().toLowerCase();
		String word = s.nextLine().toLowerCase();

	    Matcher m = Pattern.compile("\\b" + word + "\\b").matcher(text);
	    int count = 0;

	    while(m.find()) {
	    	count++;
	    }
	    
		System.out.println(count);
		s.close();
	}
}
