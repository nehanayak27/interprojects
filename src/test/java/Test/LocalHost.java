package Test;

import java.util.Scanner;

import Classes.Resuable;

public class LocalHost {
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser name");
		String bn=sc.nextLine();
		System.out.println("Enter the url");
		String u=sc.nextLine();
		System.out.println("Enter the userid");
		String uid=sc.nextLine();
		System.out.println("Enter the userid criteria");
		String uidc=sc.nextLine();
		String pwd=null;
		String pwdc=null;
		
		if(uidc.equalsIgnoreCase("valid"))
		{
			System.out.println("Enter the password");
			pwd=sc.nextLine();
			System.out.println("Enter the password criteria");
			pwdc=sc.nextLine();
		}
		
		
		//create object to resuablemethodclass
		
		Resuable obj=new Resuable(bn);
		obj.launchsite(u);
		
		obj.fillandvalidationlogin1(uid, uidc, pwd, pwdc);
		
		
		obj.close();
	}
	
	
	
	
}
