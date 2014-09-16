package loops;

import java.util.Scanner;

public class GenerateThreeLetterWords {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] charSet = s.nextLine().toCharArray();
		for (int i = 0; i < charSet.length; i++) {
			for (int j = 0; j < charSet.length; j++) {
				for (int k = 0; k < charSet.length; k++) {
					System.out.print("" + charSet[i] + charSet[j] + charSet[k] + " ");
				}
			}
		}
		s.close();
	}
}
