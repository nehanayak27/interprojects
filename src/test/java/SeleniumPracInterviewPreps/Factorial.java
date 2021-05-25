package SeleniumPracInterviewPreps;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int c=sc.nextInt();
		sc.close();
		//calculate factorial 
		long f=1; 
		for(int i=c;i>1;i--)
		{
			f=f*i;
			
			
		}
		
		System.out.println(f);
		

	}

}
