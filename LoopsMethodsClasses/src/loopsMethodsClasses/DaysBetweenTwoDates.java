package loopsMethodsClasses;

import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class DaysBetweenTwoDates {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] fLine = s.nextLine().split("-", 3);
		String[] sLine = s.nextLine().split("-", 3);
		
		DateTime  startDate = new DateTime(Integer.parseInt(fLine[2]), Integer.parseInt(fLine[1]), Integer.parseInt(fLine[0]), 0, 0);
		DateTime  endDate = new DateTime(Integer.parseInt(sLine[2]), Integer.parseInt(sLine[1]), Integer.parseInt(sLine[0]), 0, 0);
		
		System.out.print(Days.daysBetween(startDate, endDate).getDays());
		
		s.close();
	}
}
