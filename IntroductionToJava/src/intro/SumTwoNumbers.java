package intro;
import java.util.Scanner;

public class SumTwoNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(s.nextInt() + s.nextInt());
		s.close();
	}
}