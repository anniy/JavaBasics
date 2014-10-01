package javaCollections;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _10_ExtractAllUniqueWords {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Set<String> set = new TreeSet<String>(Arrays.asList(s.nextLine().toLowerCase().split("\\W+")));

		for (String string : set) {
			System.out.print(string + " ");
		}
		
		s.close();
	}
}
