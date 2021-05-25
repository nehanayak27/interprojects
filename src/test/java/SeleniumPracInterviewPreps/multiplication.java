package SeleniumPracInterviewPreps;

import java.util.Scanner;

public class multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt();
		sc.close();
		
		for(int i=1;i<=10;i++)
		{
			
			System.out.printf("%d X %d=%d%n",x,i,x*i);
		}
		System.out.println();
		
		

	}

}
