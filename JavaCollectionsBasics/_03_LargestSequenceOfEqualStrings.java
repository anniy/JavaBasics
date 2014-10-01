package javaCollections;

import java.util.Scanner;

public class _03_LargestSequenceOfEqualStrings {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] arr = s.nextLine().split("\\s+");
		int counter;
		int i = 0;
		int index = 0;
		String str = "";
		while (i < arr.length - 1) {
			counter = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					counter++;
				}
				else {
					break;
				}
			}
			if (index < counter) {
				str = arr[i];
				index = counter;
			}
			i += counter;
		}
		for (int j = 0; j < index; j++) {
			System.out.print(str + " ");
		}
		s.close();
	}
}
