package javaCollections;

import java.util.ArrayList;
import java.util.Scanner;

public class _09_CombineListsOfLetters {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] line1 = s.nextLine().split("\\s+");
		String[] line2 = s.nextLine().split("\\s+");
		
		ArrayList<Character> l1 = new ArrayList<Character>();
		ArrayList<Character> l2 = new ArrayList<Character>();
		ArrayList<Character> combineLists = new ArrayList<Character>();
		
		for (int i = 0; i < line1.length; i++) {
			l1.add(line1[i].toCharArray()[0]);
		}
		
		combineLists.addAll(l1);
		
		for (int i = 0; i < line2.length; i++) {
			l2.add(line2[i].toCharArray()[0]);
		}
		
		for (Character character : l2) {
			if (!l1.contains(character)) {
				combineLists.add(character);
			}
		}

		for (Character character : combineLists) {
			System.out.print(character + " ");
		}
		
		s.close();
	}
}
