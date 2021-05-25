package mavenpackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yahoo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		Yahoo y=new Yahoo();
		y.screenshot(driver);

	}
	public void screenshot(ChromeDriver driver) throws IOException
	{
		driver.get("https://www.globalsqa.com/demo-site/");
		WebElement p=driver.findElement(By.className("header_contacts"));
		File dest=new File("savin.png");
		File src=p.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		if(dest.delete())
		{
			System.out.println("test pass");
		}
		else
		{
			System.out.println("test fail");
		}
	}
	public void display(ChromeDriver driver) throws InterruptedException
	{
		driver.get("https://www.globalsqa.com/demo-site/");
		Thread.sleep(1000);
		//get text of visible element
		WebElement x=driver.findElement(By.id("menu-item-1513"));
		if(x.isDisplayed())
		{
			System.out.println("element is visible");
			if(x.isEnabled())
			{
				System.out.println("the element is enabled");
			}
			else
			{
				System.out.println("the elemnet is not enabled");
			}
			if(x.isSelected())
			{
				System.out.println("the elemnet is selected");
			}
			
			else
			{
				System.out.println("the elemnet is not selected");
			}
			
			
		}
		else
			
		{
			System.out.println("element isnt visble");
		}
	}
	public void yahoo(ChromeDriver driver) throws InterruptedException
	{
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.name("username")).sendKeys("nnayakk1994");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-passwd")).sendKeys("Donut@2020");
		
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='header-mail-button'][@title='Mail']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Compose']")).click();
		Thread.sleep(5000);
//		try
//		{
//			driver.findElement(By.xpath("//*[@id='message-to-field'][@type='text']")).click();
//		}
//		catch(Exception ex)
//		{
//			
//		}
		driver.findElement(By.xpath("//*[@id='message-to-field'][@type='text']")).sendKeys("nehanayak32@gmail.com");
		
		
		
	}

}
