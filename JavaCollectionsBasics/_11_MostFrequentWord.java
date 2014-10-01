package javaCollections;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_MostFrequentWord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] words = s.nextLine().toLowerCase().split("\\W+");
		
		TreeMap<String, Integer> wordsCount = new TreeMap<String, Integer>();
		
		for (String word : words) {
			Integer count = wordsCount.get(word);
			if (count == null) {
				count = 0; 
			}
			wordsCount.put(word, count+1);
		}
		
		int max = Collections.max(wordsCount.values());
		
		for (String key : wordsCount.keySet()) {
			if (wordsCount.get(key) == max) {
				System.out.println("" + key + " -> " + wordsCount.get(key));
			}	  
		}

		s.close();
	}
}
