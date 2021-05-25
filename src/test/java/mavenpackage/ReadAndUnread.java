package mavenpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadAndUnread {

	public static void main(String[] args) throws Exception
	{
	//open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://mail.google.com/");
		driver.findElementById("identifierId").sendKeys("nnk202020@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElementByName("password").sendKeys("Nehanayak12!");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(20000);
		
	
	
	//mailbox testing via pagination
	int eamc=0;  //expected all mail count=0
	int eurmc=0; //expected unread mail count=0
	int ermc=0;  //expected read mail count=0
	//while(true)
	while(2>1)
	{
	WebElement mailbox=driver.findElement(By.xpath("(//table)[7]/tbody"));
	List<WebElement> mails=mailbox.findElements(By.xpath("child::tr"));
	eamc=eamc+mails.size();
	for(WebElement mail:mails)
	{
	WebElement e=mail.findElement(By.xpath("child::td[4]/div[1]"));
	String op=(String) driver.executeScript("return(arguments[0].textContent);",e);
	if(op.startsWith("unread"))
	{
	eurmc++;
	}
	else
	{
	ermc++;
	}
	}
	//go to next page
	try
	{
	if(driver.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
	{
	break;
	}
	else
	{
	  driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
	  Thread.sleep(5000);
	}
	}
	catch(NullPointerException ex)
	{
	driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
	Thread.sleep(5000);
	}
	}
	System.out.println("Total count of all mails is "+eamc);
	System.out.println("Total count of unread mails is "+eurmc);
	System.out.println("Total count of read mails is "+ermc);
	//get actual values given by server and validate
	String temp1=driver.findElement(By.xpath("//div[@aria-label='Show more messages']/descendant::span[5]")).getText();
	int aamc=Integer.parseInt(temp1);
	String temp2=driver.findElement(By.xpath("//div[@data-tooltip='Inbox']/descendant::div[4]")).getText();
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
	//do logout
	driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.linkText("Sign out")).click();
	        Thread.sleep(5000);
	        //close site
	        driver.close();

	}
			}

