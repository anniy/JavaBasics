package loops;

import java.util.ArrayList;

public class FullHouseWithJokers {
	private static Object[] card = new Object[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'};
	private static char[] cardSuit = {'\u2663', '\u2666', '\u2665', '\u2660'};
	private static int suits = cardSuit.length;
	private static ArrayList<String> fullHouses = new ArrayList<String>();
	private static int[] combinations = new int [suits];
	private static int threeCard = 3;
	private static int twoCard = 2;
	
	private static void twoCardSuitComb(int i, int after, Object jCard, String threeCards) {
		String triple;
		if (i > twoCard) {
			return;
		}
		for (int j = after + 1; j <= suits; j++) {
			combinations[i-1] = j;
			if (i == twoCard) {
				triple = threeCards;
				for (int j2 = 0; j2 < twoCard; j2++) {
					triple += "" + jCard + cardSuit[combinations[j2] - 1] + " ";
				}
				fullHouses.add(triple);
			}
			twoCardSuitComb(i + 1, j, jCard, threeCards);
		}
	}
	
	private static void threeCardSuitComb(int i, int after, Object iCard, Object jCard) {
		String threeCards;
		if (i > threeCard) {
			return;
		}
		
		for (int j = after + 1; j <= suits; j++) {
			combinations[i-1] = j;
			if (i == threeCard) {
				threeCards = "";
				for (int j2 = 0; j2 < threeCard; j2++) {
					threeCards += "" + iCard + cardSuit[combinations[j2] - 1] + " ";
				}
				twoCardSuitComb(1, 0, jCard, threeCards);
			}
			threeCardSuitComb(i + 1, j, iCard, jCard);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card.length; j++) {
				if (i != j) {
					threeCardSuitComb(1, 0, card[i], card[j]);
				}
			}
		}
		
		int count = 0;
		for (String string : fullHouses) {
			for (int i = 0; i < (1 << 5); i++) {
				int jokers = i;
				String[] cards = string.split("\\s+");
				for (int j = cards.length - 1; j >= 0; j--) {
					if (jokers % 2 ==  1) {
						cards[j] = "*";
					}
					jokers >>= 1;
				}
				for (String string2 : cards) {
					System.out.print(string2 + " ");
				}
				System.out.println();
				count++;
			}
		}
		
		System.out.println(count);
	}
}

