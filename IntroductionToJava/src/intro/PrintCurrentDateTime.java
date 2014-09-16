package intro;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintCurrentDateTime {
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
	}
}
