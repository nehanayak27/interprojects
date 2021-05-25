package StringClass;

import java.util.ArrayList;

public class CountOfAll {
	public void meth()
	{
		String x="kjhedla qjkwqbdkjbf21GFJHGFH90809*)(*)*788hjabdjhg674^%#%$@#$%";
		ArrayList<Character> a=new ArrayList<Character>();
		ArrayList<Character> b=new ArrayList<Character>();
		ArrayList<Character> c=new ArrayList<Character>();
		ArrayList<Character> d=new ArrayList<Character>();
		
		for(int i=0;i<x.length();i++)
		{
			Character mn=x.charAt(i);
			if(mn>=65 && mn<=95)
			{
				a.add(mn);
			}
			else if(mn>=97 && mn<=122)
			{
				b.add(mn);
			}
			else if(mn>=48 && mn<=57)
			{
				c.add(mn);
			}
			else if(mn!=' ')
			{
				d.add(mn);
			}
			
			
		}
		
		System.out.println("no of upper case"+a.size());
		System.out.println("no of lower case"+b.size());
		System.out.println("no of digits case"+a.size());
		System.out.println("no of spcl case"+a.size());
	}
	
	

}
