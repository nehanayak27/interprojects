package StringClass;

import java.util.Scanner;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sentence");
		String x=sc.nextLine();
		sc.close();
		int now;
		int noc=0;
		int nos=0;
		
		if(x.charAt(0)==' ')
		{
			now=0;
		}
		else
		{
			now=1;
		}
		
		for(int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			
			if(y==' ')
			{
				nos++;
			}
			else
			{
				noc++;
			}
			
			try {
				if(y==' '&& x.charAt(i+1)!=' ')
					now++;
				
			}
			catch(Exception ex)
			{
				System.out.println("search is completed");
			}
		}
		System.out.println("no of spaces"+nos);
		System.out.println("no of char"+noc);
		System.out.println("no of words"+now);
		
		
	}

}
