package mavenpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisibleLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		VisibleLinks vb=new VisibleLinks();
		vb.nestedif(driver);
	
	}
	
	public void nestedif(ChromeDriver driver) throws InterruptedException 
	{
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		List <WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println("Total count of links" +l.size());
		
		int h=0,v=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				v++;
				System.out.println(e.getText());
			}
			else
			{
				h++;
			}
		}
		System.out.println("total count of hidden links" +h);
		System.out.println("total count of visible links" +v);
		
		driver.close();
	}
	
	
	
	
	
	
	public void linko(ChromeDriver driver)throws InterruptedException
	{
		driver.get("https://www.instagram.com/");
		List<WebElement> l=driver.findElements(By.tagName("a"));
		
		System.out.println("total count of links" +l.size());
		int vl=0,hl=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				vl++;
				System.out.println(e.getText());
			}
			else
			{
				hl++;
			}
		}
	
		
	}
	public void inte(ChromeDriver driver1)throws InterruptedException
	{
		driver1.get("http://the-internet.herokuapp.com/");
		List <WebElement> l1= driver1.findElements(By.tagName("a"));
		System.out.println("list of all the links"+l1.size());
		int vl=0, hl=0;
		for(WebElement e:l1)
		{
			if(e.isDisplayed())
			{
				vl++;
				System.out.println(e.getText());
			}
			else
			{
				hl++;
			}
		}
		System.out.println("total count of visible link" +vl);
		System.out.println("total count of hidden link" +hl);
		driver1.close();
	}
	}


