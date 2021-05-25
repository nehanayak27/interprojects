package mavenpackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		List <WebElement> l=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		System.out.println("total number of images" +l.size());
		
		List <WebElement> l1=new ArrayList<WebElement>();
				List <WebElement> l2=new ArrayList<WebElement>(); 
		int vi=0, hi=0;
		for (WebElement e:l)
		{
			if(e.isDisplayed())
			{
				l1.add(e);	
				
			}
			else
			{
				l2.add(e);
				
			}
		}
		System.out.println("visible image count is" +l1.size());
		System.out.println("hidden image count is" +l2.size());
	}

}
