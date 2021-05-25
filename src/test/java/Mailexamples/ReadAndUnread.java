package Mailexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadAndUnread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://mail.google.com/");
		dr.findElementById("identifierId").sendKeys("nnk202020@gmail.com");
		dr.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		dr.findElementByName("password").sendKeys("Nehanayak12!");
		dr.findElement(By.id("passwordNext")).click();
		Thread.sleep(20000);
		int eamc=0; //expected all mail count
		int eurmc=0; //expected unread mail count 
		int ermc=0; //expected read mail count 
		while(true)
		{
			
		
		List<WebElement> rows=dr.findElements(By.xpath("(//table)[7]/tbody/tr"));
		eamc=eamc+rows.size();
		for(WebElement mail:rows)
		{
			
			WebElement e=mail.findElement(By.xpath("child::td[4]/div[1]"));
			String op=(String) dr.executeScript("return(arguments[0].textContent);",e);
			if(op.startsWith("unread"))
				{
				eurmc++;
				}
			else
				{
				ermc++;
				}
		}//end of for loop
			
			//go to next page. 
			try
			{
				if(dr.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
				{
				break;
				}
			else
				{
				  dr.findElement(By.xpath("//div[@aria-label='Older']")).click();
				  Thread.sleep(5000);
				}
			}
			catch(Exception ex)
			{
				dr.findElement(By.xpath("//div[@aria-label='Older']")).click();
				Thread.sleep(5000);
			}
		
		}
		System.out.println("Total count of all mails is "+eamc);
		System.out.println("Total count of unread mails is "+eurmc);
		System.out.println("Total count of read mails is "+ermc);
		//get actual values given by server and validate
		String temp1=dr.findElement(By.xpath("//div[@aria-label='Show more messages']/descendant::span[5]")).getText();
		int aamc=Integer.parseInt(temp1);
		String temp2=dr.findElement(By.xpath("//div[@data-tooltip='Inbox']/descendant::div[4]")).getText();
		int aurmc=Integer.parseInt(temp2);
		if(eamc==aamc)
		{
		System.out.println("All mail count test passed");
		if(eurmc==aurmc)
		{
		System.out.println("unread mail count test passed");
		}
		else
		{
		System.out.println("unread mail count test failed");
		}
		}
		else
		{
		System.out.println("All mail count test failed");
		}
		
	}

}
