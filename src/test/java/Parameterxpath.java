import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterxpath {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		/*
		// click on 1,2,3.... way 1 - with fixed loop. 
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("kalam", Keys.ENTER);
		for(int i=2;i<10;i++)
		{
			driver.findElement(By.xpath("//*[@aria-label='Page "+i+"']")).click();
		}
		*/
		//click on 1,2,3.... way 2 - with while loop.
		
		driver.get("http://yahoo.com");
		driver.findElement(By.id("header-search-input")).sendKeys("kalam", Keys.ENTER);
		Thread.sleep(1000);
		int j=1;
		while(true)
			
		{
			driver.findElement(By.xpath("//*[@aria-label='Page "+j+"']")).click();
			j++;
		}

	}

}
