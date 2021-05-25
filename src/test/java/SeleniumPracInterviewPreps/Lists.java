package SeleniumPracInterviewPreps;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lists {

	public void jquerylist(ChromeDriver dr) throws Exception
	{
		dr.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
		dr.manage().window().maximize();
		WebElement list=dr.findElement(By.xpath("//option[normalize-space()='Manuela']"));
		System.out.println(list.getSize());
		
		for(int i=2;i<10;i++)
		{
			Thread.sleep(1000);
			dr.findElement(By.xpath("//option[@data-id='"+i+"']")).click();
			dr.findElement((By.xpath("//button[normalize-space()='Add']"))).click();;
		}
		dr.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Lists ll=new Lists();
		ChromeDriver dr = null;
		ll.datepicker(dr);
		
		
	}
	
	public void datepicker(ChromeDriver dr) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the day");
		int ed=Integer.parseInt(sc.nextLine()) ;
		System.out.println("enter the month");
		String em=sc.nextLine();
		
		System.out.println("enter the year");
		int ey=sc.nextInt();
		sc.close();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr1=new ChromeDriver();
		dr1.get("https://jqueryui.com/datepicker/");
		dr1.manage().window().maximize();
		// scroll to the element using js -->> dr.executeScript("arguments[0].scrollIntoView();",webelements);
		//WebElement frameing=dr.findElement(By.xpath("//*[@class='demo-frame']"));
		Thread.sleep(10000);
		dr1.switchTo().frame(0);
		Thread.sleep(1000);
		
		dr1.findElement(By.xpath("//*[@id='datepicker']")).click();
		
		//year testing
		while(true)
		{	Thread.sleep(1000);
			String temp=dr1.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
			int ay=Integer.parseInt(temp);
			if(ey<ay)
			{
				dr1.findElement(By.xpath("//a[@data-handler='prev']")).click();
				Thread.sleep(1000);
			}
			else if(ey>ay)
			{
				dr1.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
			else
				{
				//month matching 
				//month (by defulat from jan)
				while(true)
					{
						String temp2=dr1.findElement(By.xpath("//*[@class='ui-datepicker-month'")).getText();
						String am=temp2.toLowerCase();
						
						if(!am.equalsIgnoreCase("January"))
						{
							dr1.findElement(By.id("//*[text()='Prev']")).click();
							Thread.sleep(1000);
						}
						else
						{
							break;
						}
					}
				
				}
			
		}
		
	}

}
