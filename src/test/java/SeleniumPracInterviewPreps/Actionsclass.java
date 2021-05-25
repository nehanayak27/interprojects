package SeleniumPracInterviewPreps;

import java.util.Scanner;

public class Actionsclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the time");
		int time=sc.nextInt();
		
		if(time>0&&time<=12)
		{
			System.out.println("good morning");
		}
		else if(time>12&&time<=16)
		{
			System.out.println("good noons");
		}
		else if(time>16&&time<=20)
		{
			System.out.println("good evening");
		}
		else if(time>20&&time<=24)
		{
			System.out.println("good night");
		}
		else
		{
			System.out.println("enter the correct time");
		}
		
		
	}

}
