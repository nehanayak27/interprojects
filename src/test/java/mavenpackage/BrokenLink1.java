package mavenpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://mail.google.com/");
		//login to google account with username and password. 
		driver.findElement(By.id("identifierId")).sendKeys("nnk202020@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='button'][@jsname='LgbsSe']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='password'][@name='password']")).sendKeys("Nehanayak12!");
		driver.findElement(By.xpath("//*[@type='button'][@jsname='LgbsSe']")).click();
		//collect all the elements of the inbox page.
		List<WebElement> l1=driver.findElements(By.xpath("(//a)|(//link)|(//href)|(//base)|(//area)|(//div)|(//img)|(//script)"));
		
		System.out.println("total count of elements in the list" +l1.size());
		
		//collect all hyper links only. 
		
		List<WebElement> l2=new ArrayList<WebElement>();
		
		for(WebElement e:l1)
		{
			
			try
			{
			if(e.getAttribute("href")!= null)
			{
				String x=e.getAttribute("href");
				if(x.startsWith("https")|x.startsWith("http"))
				{
					l2.add(e);
					
				}
			}
			}
			catch(StaleElementReferenceException ex)
			{
				l1=driver.findElements(By.xpath("(//a)|(//link)|(//href)|(//base)|(//area)|(//div)|(//img)|(//script)"));
			}
			
		}
		
		int clc=0, blc=0;
		for(WebElement e:l2)
		{
			try
			{
			String x=e.getAttribute("href");
			URL u=new URL(x);
			HttpURLConnection con=(HttpURLConnection) u.openConnection();
			con.connect();
			String y=con.getResponseMessage();
			int z=con.getResponseCode();
			if(y.equalsIgnoreCase("OK"))
			{
				clc++;
				
			}
			else
			{
				blc++;
				System.out.println(x+"with response"+y+"with code "+z);
			}
			con.disconnect();
		}
			catch(StaleElementReferenceException ex)
			{
				System.out.println("An exceptiion happened");
			}
		}
		System.out.println("total count of correct links" +clc);
		System.out.println("total count of broken links" +blc);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class=\'gb_Vf gb_Wa gb_Ig gb_i\']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		
		driver.close();
		
		
		
	}

}
