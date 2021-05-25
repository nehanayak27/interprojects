package StringClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StringArray {
	private RemoteWebDriver driver;
	
	public int a;
	public float b;
	public long c;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] x= {"abudul", "kalam", "neha", "nayak", "vicky", "Nikki", "shreyu"};
	System.out.println("Length of string"+x.length);
	
	for(int i=0;i<x.length;i++)
	{
		int p=x[i].length();
		System.out.println(x[i]+"\t length is \t"+p);
	}
	
	
		
	}
	public StringArray(int x,float y,long z)
	{
		this.a=x;
		this.b=y;
		this.c=z;
	}
	
	public void meth1(String vv)
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(vv);
		
	}
	
	public void meth2(String v,String vv)
	{
	
		
	
	}
	
	public String tit()
	{
		
		String  tit=driver.getTitle();
		return tit;

	}
	

	public int methint2(String v,String vv)
	{
		
		
		
		
		return 2;

	}
	
	

}
