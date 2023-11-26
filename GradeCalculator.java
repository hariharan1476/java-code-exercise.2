package testforsem;
import java.util.*;
public class GradeCalculator {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter ur marks in physics");
		int physics=scanner.nextInt();
		System.out.println("enter u r marks in chemistry");
		int chemistry=scanner.nextInt();
		System.out.println("enter ur marks in biology");
		int biology=scanner.nextInt();
		System.out.println("enter ur marks in maths");
		int maths=scanner.nextInt();
		System.out.println("enter ur marks in computer");
		int computer=scanner.nextInt();
		
		int totalmarks= physics+chemistry+biology+maths+computer;
		double percentage=(totalmarks*100.0)/500;
		
		char Grade;
		if(percentage>=90) {
			Grade='A';
		}else if(percentage>=80) {
			Grade='B';
		}else if(percentage>=70) {
			Grade='C';
		}else if(percentage>=60) {
			Grade='D';
		}else if(percentage>=40) {
			Grade='E';
			
		}else {
			Grade='F';
		}
		
		System.out.println("u r total marks is " + totalmarks);
		System.out.println("u r percentage is " + percentage);
		System.out.println("u r final grade is " + Grade);
		
		scanner.close();
	}

}
