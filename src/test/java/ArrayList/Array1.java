package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Array1 {
	public static void main(String[] args) throws Exception {
		Array1 x=new Array1();
		x.webpushnotification();
	}
	
	public void webpushnotification() throws Exception
	{
		//helps for webpush (allow/block)
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver,chrome.silentOutput", "true");
		ChromeOptions co=new ChromeOptions();
		//String[] s=new String[] {"enable-automation"};
		//co.setExperimentalOption("excludeSwitches", s);
		co.addArguments("--disable-notifications");
		co.addArguments("--start-maximized");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("https://economictimes.indiatimes.com/industry/transportation/airlines-/-aviation/two-indian-vaccine-shots-arent-yet-enough-for-a-vaccine-passport/articleshow/82397974.cms");
		driver.manage().window().maximize();
		//Screen sc=new Screen();
		//sc.click("src\\test\\resources\\allow.PNG");
		
	}
	
public void meth2()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("how many numbers you wish to add into the array");
	int size=sc.nextInt();
	System.out.println("enter the"+size+"number");
	ArrayList<Integer> a=new ArrayList<Integer>();
	for(int i=0;i<size;i++)
	{
		a.add(sc.nextInt());
	}
	HashMap<String, String> capitalCities = new HashMap<String, String>();
	
	
}

public void reverse()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a digit");
	String size=sc.nextLine();
	String t="";
	for(int i=size.length()-1;i>=0;i--)
	{
		char c=size.charAt(i);
		t=t+c;
	}
	System.out.println(t);
}
	
	
	public void meth()
	{
		ArrayList<String> aa=new ArrayList<String>();
		aa.add("neha");
		aa.add("nayak");
		aa.add("pendrive");
		aa.add("software");
		aa.add("makeup");
		aa.add("lipstick");
		aa.add("pen");
		aa.add("book");
		for(int i=1;i<aa.size();i++)
		{
			System.out.println(aa.get(i).toString());
		}
		
		for(String a:aa)
		{
			System.out.println(a);
		}
	
		
	}
	
	
	
	
}
