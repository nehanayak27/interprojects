package mavenpackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrizeMinMax {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//input[contains(@name, 'originStation1')])")).sendKeys("Bengaluru (BLR)");
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//input[contains(@name, 'destinationStation1')])")).sendKeys("Mumbai (BOM)");
		Thread.sleep(5000);
		dr.findElement(By.linkText("12")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//*[@value='Search'])[1]")).click();
		
		//collect all flights information 
		List<WebElement> flight=dr.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr[not(contains(@class, 'heading'))]"));
		
		//collect fares of flights
		List<WebElement> fares=new ArrayList<WebElement>();
		for(WebElement e:flight)
		{
			String temp=e.findElement(By.xpath("")).getText();
		}
		dr.close();
		
		
	}

}
