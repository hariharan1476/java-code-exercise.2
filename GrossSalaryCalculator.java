package testforsem;
import java.util.*;
public class GrossSalaryCalculator {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter ur basic salary");
		double basicsalary=scanner.nextDouble();
		double hra,da;
		if(basicsalary<=10000) {
			hra = 0.2*basicsalary;
			da = 0.8*basicsalary;
		}else if(basicsalary<=20000) {
			hra = 0.25*basicsalary;
			da = 0.9*basicsalary;
		}else {
			hra = 0.3*basicsalary;
			da = 0.95*basicsalary;
			
		}
		
		double GrossSalary=basicsalary + hra+da;
		System.out.println("the basic salary is" + basicsalary);
		System.out.println("the hra is"+hra);
		System.out.println("the da is"+da);
		System.out.println("the grosssalary"+GrossSalary);
		
	}

}
