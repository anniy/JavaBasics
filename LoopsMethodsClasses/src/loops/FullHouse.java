package loops;

public class FullHouse {
	public static void main(String[] args) {
		Object[] card = new Object[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'};
		char[] cardSuit = {'\u2663', '\u2666', '\u2665', '\u2660'};
		String fullHouse = "";
		int count = 0;

		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card.length; j++) {
				if (i != j) {
					for (int k1 = 0; k1 < cardSuit.length-2; k1++) {
						for (int k2 = k1+1; k2 < cardSuit.length-1; k2++) {
							for (int k3 = k2+1; k3 < cardSuit.length; k3++) {
								fullHouse = "" 	+ card[i] + cardSuit[k1] + " " 
												+ card[i] + cardSuit[k2] + " "
												+ card[i] + cardSuit[k3] + " ";
								for (int l1 = 0; l1 < cardSuit.length-1; l1++) {
									for (int l2 = l1+1; l2 < cardSuit.length; l2++) {
										System.out.println(fullHouse + card[j] + cardSuit[l1] + " " + card[j] + cardSuit[l2]);
										count++;
									}
								}
								fullHouse = "";
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
