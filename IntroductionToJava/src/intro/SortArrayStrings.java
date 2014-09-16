package intro;
import java.util.*;

public class SortArrayStrings {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> listString = new ArrayList<String>();
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			listString.add(s.next());
		}
		Collections.sort(listString);
		for (String string : listString) {
			System.out.println(string);
		}
		s.close();
	}
}
