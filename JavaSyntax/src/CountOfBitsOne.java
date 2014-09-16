import java.util.Scanner;

public class CountOfBitsOne {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 0;
		
		while (n!=0) {
			count += n % 2;
			n = n >> 1;
		}
		System.out.println(count);
		s.close();
	}
}
