import java.util.Scanner;

public class CountOfEqualBitPairs {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mask = 3; // ((1 << 2) - 1)
		int count = 0;
		int bits;
		
		while (n != 0) {
			bits = n & mask;
			if (bits == 3 || bits == 0) {
				count++;
			}
			n >>= 1;
		}
		System.out.println(count);
		s.close();
	}
}
