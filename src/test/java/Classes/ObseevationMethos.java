package Classes;

import java.sql.Driver;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObseevationMethos {
	
	RemoteWebDriver driver;
	public ObseevationMethos()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	
	}
		
	
	//operational methods
	public String validateusername(RemoteWebDriver driver2)
	{
		
		WebElement e=driver2.findElement(By.xpath("//input[@id='userName']"));
		
		if(e.isDisplayed())
		{
			e.sendKeys("admin");
		}
		else
		{
			System.out.println("element isnt displayed");
		}

		return null;
	
		
		
	}

	@Test
	public void running()
	{
		driver.get("https://twhyderabad.github.io/demo_site");
		ObseevationMethos ob=new ObseevationMethos();
		
		ob.validateusername(null);
		
		
		
	}

}
