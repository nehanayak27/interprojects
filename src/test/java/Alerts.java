import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public void al1(ChromeDriver driver)
	{
		driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
		driver.findElement(By.xpath("//button[normalize-space()='Autocloseable success message']")).click();
		
		String texting=driver.findElement(By.xpath("//div[@class='alert alert-success alert-autocloseable-success']")).getText();
		System.out.println(texting);
		
	}
	public void alrt(ChromeDriver driver)
	{
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.xpath("//input[@name='alert']")).click();
		String xx=driver.switchTo().alert().getText();
		System.out.println(xx);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@name='prompt']")).click();
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		Alerts xa=new Alerts();
		xa.alrt(driver);
	}

}
