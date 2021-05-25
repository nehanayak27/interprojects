package SeleniumPracInterviewPreps;

import org.apache.commons.cli.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodLearn {
	RemoteWebDriver driver;
	public void meth(String url)
	{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
	}
	
	public String titletest()
	{
		String  tit=driver.getTitle();
		return tit;
		
		
		
	}
	
	public Rectangle methboolean()
	{
		Rectangle c=driver.findElement(By.id("")).getRect();
		System.out.println(c);
		return c;
		
	}
	
	
	public int methint()
	{
		return 0;
		
	}

}
