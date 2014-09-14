import java.util.Scanner;

public class PointsInsideFigure {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] token = s.nextLine().split("\\s+", 2);
		float x = Float.parseFloat(token[0]);
		float y = Float.parseFloat(token[1]);
		String output = "Outside";
		
		if((x >= 12.5 && x <= 22.5 && y >= 6 && y <= 13.5) && !(x > 17.5 && x < 20 && y > 8.5)){
			output = "Inside";
		}
		
		System.out.println(output);
		s.close();
	}
}
