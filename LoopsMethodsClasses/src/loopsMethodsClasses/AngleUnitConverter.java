package loopsMethodsClasses;

import java.util.Scanner;

public class AngleUnitConverter {
	private static double deg2rad(double d) {
		return (Math.PI * d) / 180;
	}
	
	private static double rad2deg(double r) {
		return (180 * r) / Math.PI;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			double angle = s.nextDouble();
			String measure = s.next();
			
			if (measure.equals("rad")) {
				System.out.printf("%.6f %s\n", rad2deg(angle), measure);
			}
			
			if (measure.equals("deg")) {
				System.out.printf("%.6f %s\n", deg2rad(angle), measure);
			}
		}
		s.close();
	}
}
