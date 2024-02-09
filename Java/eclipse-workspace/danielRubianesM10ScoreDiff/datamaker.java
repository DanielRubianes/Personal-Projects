import java.util.*;
public class datamaker {
	public static void main(String[] args) {
		for (int index = 1; index <= 40; index++) {
			Random rand = new Random();
			System.out.println((rand.nextInt(200)+ 100) + " " + (rand.nextInt(100)+ 200));
		}
	}
}
