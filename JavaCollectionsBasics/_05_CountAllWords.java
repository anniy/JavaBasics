package javaCollections;

import java.util.Scanner;
import java.util.regex.Pattern;


public class _05_CountAllWords {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String str = s.nextLine();
		
		System.out.println(Pattern.compile("\\W+").split(str).length);
		//System.out.println(str.split("\\W+").length);
		
		s.close();
	}
}
