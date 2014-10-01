package javaCollections;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_CountSubstringOccurrences {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine().toLowerCase();
		String word = s.nextLine().toLowerCase();
		int lenght = text.length();
		
	    Matcher m = Pattern.compile(word + "+?").matcher(text);
	    int count = 0;
	    
	    while(m.find()) {
	    	count++;
	    	m.region(m.start() + 1, lenght);
	    }
	    
		System.out.println(count);
		s.close();
	}
}
