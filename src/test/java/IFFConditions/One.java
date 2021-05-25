package IFFConditions;

import java.util.Scanner;

public class One {
	public void meth()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value");
		String zz=sc.nextLine();
		sc.close();
		int flag=0;
		
		for(int i=0;i<zz.length();i++)
		{
			char cs=zz.charAt(i);
			if(zz.contains("a"))
			{
				flag=1;
				break;
			}
			
		}
		
		
	
	}

}
