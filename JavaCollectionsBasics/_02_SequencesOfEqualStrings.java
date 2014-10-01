package javaCollections;

import java.util.Scanner;

public class _02_SequencesOfEqualStrings {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] arr = s.nextLine().split("\\s+");
		int counter;
		int i = 0;
		while (i < arr.length) {
			counter = 1;
			System.out.print(arr[i] + " ");
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					System.out.print(arr[j] + " ");
					counter++;
				}
				else {
					break;
				}
			}
			System.out.println();
			i += counter;
		}
		s.close();
	}
	
}
