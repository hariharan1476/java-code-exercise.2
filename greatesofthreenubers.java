package testforsem;
import java.util.*;
public class greatesofthreenubers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter u r 1st num :");
		int num1=scanner.nextInt();
		System.out.println("enter ur 2 nd num:");
		int num2=scanner.nextInt();
		System.out.println("enter u r 3rd num");
		int num3=scanner.nextInt();
		if (num1>num2 && num1>num3) {
			System.out.println("the greates number is" + num1);
			
		}else if (num2>num1 && num2>num3) {
			System.out.println("the greayes number is " + num2);
			
		}else {
			System.out.println("the greatest number is "+ num3);
		}
	}

}
