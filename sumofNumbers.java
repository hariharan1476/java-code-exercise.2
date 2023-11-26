package testforsem;
import java.util.Scanner;

public class sumofNumbers {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the N number");
		int n=scanner.nextInt();
		
		System.out.println("entered" + n +"number");
		int sum=0;
		for(int i=0;i<n;sum += scanner.nextInt(),i++);
		System.out.println("sum of N entered numbers is "+sum);
			
		
		
		scanner.close();
	}
}