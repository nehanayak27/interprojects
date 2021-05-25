package StringClass;

import java.util.LinkedList;
import java.util.Scanner;

public class StringArrayRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String name="neha nayak konchady";
		Scanner sc=new Scanner(System.in);
		System.out.println("tellme one char");
		String x=sc.nextLine();
		char z=x.charAt(0);
		int c=0;
		sc.close();
		
		
		
		for(int i=0;i<name.length();i++)
		{
			char  a=name.charAt(i);
			if(z==a)
			{
				c=c+1;
				System.out.println("found at index "+i);
				switch(i)
				{
					case 0:
						System.out.println("found at "+(i+1)+"st place");
						break;
					case 1:
						System.out.println("found at "+(i+1)+"nd place");
						break;
					case 2:
						System.out.println("found at "+(i+1)+"rd place");
						break;
					default:
						System.out.println("found at "+(i+1)+"th place");
						break; //Option
				}
				
			}
		}
		System.out.println("no of times "+z+" available in the given string is "+c);
		
		
	}

}
