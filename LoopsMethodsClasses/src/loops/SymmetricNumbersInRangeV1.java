package loops;

import java.util.Scanner;

public class SymmetricNumbersInRangeV1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int end = s.nextInt();
		String result = "";
		char[] currentNum;
		
		for (int i = start; i <= end; i++) {
			currentNum = Integer.toString(i).toCharArray();
			int f = 0;
			int l = currentNum.length - 1;
			
			/*while (f <= l) {
				if (currentNum[f] != currentNum[l]) {
					break;
				}
				f++;
				l--;
			}*/
			
			while (f <= l && currentNum[f] == currentNum[l]) {
				f++;
				l--;
			}
			
			if (f > l){
				result += i + " ";
			}
		}
		System.out.println(result);
		s.close();
	}
}
