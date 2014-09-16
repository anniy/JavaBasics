import java.util.Scanner;

public class TriangleArea {
	private static double distanceBetweenTwoPoint(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] token;
		int[] x = new int [3];
		int[] y = new int [3];
		double a; 
		double b; 
		double c;
		double area;
		int iarea;
		double p;
		
		for (int i = 0; i < 3; i++) {
			token = s.nextLine().split("\\s+", 2); 
			x[i] = Integer.parseInt(token[0]);
			y[i] = Integer.parseInt(token[1]);
		}
		
		a = distanceBetweenTwoPoint(x[0], y[0], x[1], y[1]);
		b = distanceBetweenTwoPoint(x[1], y[1], x[2], y[2]);
		c = distanceBetweenTwoPoint(x[2], y[2], x[0], y[0]);
		
		if ((a+b>c) && (a+c>b) && (b+c>a)) {
			p = (a + b + c)/2;
			area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
			iarea = (int)(area + 0.5);
		} 
		else {
			iarea = 0;
		}
		System.out.println(iarea);
		s.close();
	}
}
