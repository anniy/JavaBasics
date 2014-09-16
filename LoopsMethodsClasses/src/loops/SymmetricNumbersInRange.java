package loops;

import java.util.Scanner;

public class SymmetricNumbersInRange {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int end = s.nextInt();
		String result = "";
		
		for (int i = start; i <= end; i++) {
			int d0 = i % 10;
			int d1 = (i / 10) % 10;
			int d2 = (i / 100) % 10;
			if ((i < 10)  
					|| ((i > 10) && (d0 == d1) && (i < 100)) 
					|| ((i > 100) && (d0 == d2))){
				result += i + " ";
			}
		}
		System.out.println(result);
		s.close();
	}
}
