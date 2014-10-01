package javaCollections;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_ExtractEmails {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		
	    Matcher m = Pattern.compile("[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]+").matcher(text);

	    while(m.find()) {
	    	System.out.println(m.group());
	    }

		s.close();
	}
}
