import java.util.Scanner;

public class FormattingNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] token = s.nextLine().split("\\s+", 3);
		int a = Integer.parseInt(token[0]);
		float b = Float.parseFloat(token[1]);
		float c = Float.parseFloat(token[2]);
		
		System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", a, Integer.parseInt(Integer.toBinaryString(a)), b, c);
		
		s.close();
	}
}
