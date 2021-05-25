package Test;

import java.util.Scanner;

import Classes.Resuable;

public class Cloud {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter enviroment name(cloud/local)");
		String env=sc.nextLine();
		
		System.out.println("Enter browser name");
		String bn=sc.nextLine();
		
		String v=null;
		String os=null;
		if(env.equalsIgnoreCase("cloud"))
		{
			System.out.println("enter the browser version");
			v=sc.nextLine();
			System.out.println("enter the os(windows/mac/linux)");
			os=sc.nextLine();
			
		}
		System.out.println("enter the URL");
		String u=sc.nextLine();
		
		System.out.println("enter the Userid");
		String uid=sc.nextLine();
		
		System.out.println("enter the Userid criteria");
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
		sc.close();
		
		Resuable obj;
		if(env.equalsIgnoreCase("local"))
		{
			obj=new Resuable(bn);
			
		}
		else
		{
			obj=new Resuable(bn,v,os);
		}
		
		obj.launchsite(u);
		obj.fillandvalidationlogin1(uid, uidc, pwd, pwdc);
		obj.close();
		
		
	}

}
