package loopsMethodsClasses;

public class FullHouse {
	public static void main(String[] args) {
		Object[] card = new Object[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 'Q', 'J', 'K', 'A'};
		char[] cardSuit = {'\u2663', '\u2666', '\u2665', '\u2660'};
		String fullHouse = "";
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card.length; j++) {
				if (i != j) {
					for (int k1 = 0; k1 < cardSuit.length; k1++) {
						for (int k2 = 0; k2 < cardSuit.length; k2++) {
							for (int k3 = 0; k3 < cardSuit.length; k3++) {
								/*if (condition) {
									
								}*/
								System.out.print(card[i] + " " + card[i] + " " + card[i] );
							}
						}
					}
					fullHouse = card[i] + " " + card[i] + " " + card[i] + " " + card[j] + " " + card[j];
				}
			}
		}
		System.out.println(fullHouse);
	}
}
