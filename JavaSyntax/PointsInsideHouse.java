<<<<<<< HEAD
import java.util.Scanner;

public class PointsInsideHouse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String[] token = s.nextLine().split("\\s+", 2);
		float x = Float.parseFloat(token[0]);
		float y = Float.parseFloat(token[1]);
		String result =  "Outside";
		
		if(
				(((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5)) && (y >= 8.5 && y <= 13.5))
				||
				((x >= 12.5 && x <= 22.5 && y >= 3.5 && y <= 8.5) && (Math.abs(y-3.5) >= Math.abs(x-17.5)))
			){
			result = "Inside";
		}
		
		System.out.println(result);
		s.close();
	}
}
=======
import java.util.Scanner;

public class PointsInsideHouse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String[] token = s.nextLine().split("\\s+", 2);
		float x = Float.parseFloat(token[0]);
		float y = Float.parseFloat(token[1]);
		String result =  "Outside";
		
		if(
				(((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5)) && (y >= 8.5 && y <= 13.5))
				||
				((x >= 12.5 && x <= 22.5 && y >= 3.5 && y <= 8.5) && (Math.abs(y-3.5) >= Math.abs(x-17.5)))
			){
			result = "Inside";
		}
		
		System.out.println(result);
		s.close();
	}
}
>>>>>>> origin/master
