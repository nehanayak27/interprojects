package StringClass;

import java.util.Scanner;

public class conditions {
	
	public void evenodd()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int x=sc.nextInt();
		sc.close();
		
		if(x%2==0)
		{
			System.out.println("even number"+x);
		}
		else
		{
			System.out.println("odd number"+x);
		}

	}
	
	public void primenumber()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int x=sc.nextInt();
		sc.close();
		int flag=0;
		for(int i=2;i<x;i++)
		{
			if(x%i==0)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("prime");
		}
		else
		{
			System.out.println("odd number");
		}
	}
	
	public void multiplication()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int x=sc.nextInt();
		sc.close();
		for(int i=1;i<10;i++)
		{
			System.out.println("x"+i+"=");
		}
	}

}
