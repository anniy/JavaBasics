package javaCollections;

import java.util.Arrays;
import java.util.Scanner;

public class _01_SortArrayOfNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arrOfInt = new int [n];
		for (int i = 0; i < n; i++) {
			arrOfInt[i] = Integer.parseInt(s.next());
		}
		
		Arrays.sort(arrOfInt);
		
		for (Integer integer : arrOfInt) {
			System.out.print(integer + " ");
		}
		s.close();
	}
}
