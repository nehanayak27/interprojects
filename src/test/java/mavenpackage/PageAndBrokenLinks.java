package mavenpackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageAndBrokenLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//take a word from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("enter a word");
				String m=sc.nextLine();
				sc.close();
				//launch browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://www.google.co.in/");
				driver.findElement(By.name("q")).sendKeys(m,Keys.ENTER);
				Thread.sleep(1000);
				//pagination 
				int clc=0;//corect link count 
				int blc=0;//broken link count 
				while(true)
				{
					
					try
					{
						//collect all the links. 
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
					}
					catch(Exception ex)
					{
						
					}
					System.out.println("correct link"+clc);
					System.out.println("broken link"+blc);
					
					
				}
		
		
	}

}
