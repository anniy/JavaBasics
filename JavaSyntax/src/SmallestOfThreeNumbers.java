import java.util.Scanner;

public class SmallestOfThreeNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] token = s.nextLine().split("\\s+", 3);
		float a = Float.parseFloat(token[0]);
		float b = Float.parseFloat(token[1]);
		float c = Float.parseFloat(token[2]);
		
		float result = Math.min(Math.min(a, b),c);
		if ((int)result == result) {
			System.out.println((int)result);
		}
		else {
			System.out.println(result);
		}
		
		s.close();
	}
}
