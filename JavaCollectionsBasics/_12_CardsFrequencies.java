package javaCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _12_CardsFrequencies {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] cards = s.nextLine().toUpperCase().split("\\W+");

		float sumOfCards = (float)cards.length;
		ArrayList<String> faceOrder = new ArrayList<String>();
		
		HashMap<String, Integer> cardCount = new HashMap<String, Integer>();
		
		for (String card : cards) {
			Integer count = cardCount.get(card);
			if (count == null) {
				count = 0;
				faceOrder.add(card);
			}
			cardCount.put(card, count+1);
		}

		for (String face : faceOrder) {
			float frequency = cardCount.get(face)/sumOfCards*100f;
			System.out.printf("%s -> %.2f%%\n", face, frequency);
		}
		
		s.close();
	}
}
