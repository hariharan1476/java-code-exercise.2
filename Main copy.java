package testforsem;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your age :");
		int age=scanner.nextInt();
		if (age >=18) {
			System.out.println("u r eligible to vote");
		}else {
			System.out.println("u r not to vote");
		}
		scanner.close();
		

	}

}
