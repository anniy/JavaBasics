package javaCollections;

import java.util.Scanner;

public class _04_LongestIncreasingSequence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] strArr = s.nextLine().split("\\s+");
		int [] intArr = new int [strArr.length];
		int index = 0;
		int maxLenght = 0;
		int i;
		int count;
		
		for (i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		
		i = 0;
		count = 0;
		while (i < intArr.length - 1) {
			System.out.print(intArr[i] + " ");
			count = 1;
			int j = i;
			while (j < intArr.length - 1 && intArr[j] < intArr[j+1] ) {
				System.out.print(intArr[j + 1] + " ");
				count++;
				j++;
			}
			
			if (count > maxLenght) {
				maxLenght = count;
				index = i;
			}
			
			System.out.println();
			i += count;
		}
		
		maxLenght += index;
		
		System.out.print("Longest: ");
		for (i = index ; i < maxLenght; i++) {
			System.out.print(intArr[i] + " ");
		}
		
		s.close();
	}
}
