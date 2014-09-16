package loops;

import java.util.Random;
import java.util.Scanner;

public class RandomHandsOfFiveCards {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int desk = 52;
		int cardsInHand = 5;
		String handStr;
		Random randomGenerator = new Random();
		
		Object[] cardFace = new Object[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'};
		char[] cardSuit = {'\u2663', '\u2666', '\u2665', '\u2660'};
		boolean[] dragedOut = new boolean[desk];
		
		for (int i = 0; i < n; i++) {
			handStr = "";
			for (int j = 0; j < cardsInHand; j++) {
				int randomInt = randomGenerator.nextInt(desk);
				
				while (dragedOut[randomInt]) {
					randomInt = randomGenerator.nextInt(desk);
				}
				dragedOut[randomInt] = true;
				handStr += "" + cardFace[randomInt % cardFace.length] + cardSuit[randomInt / cardFace.length] + " ";
			}				
			System.out.println(handStr);
		}
		s.close();
	}
}
