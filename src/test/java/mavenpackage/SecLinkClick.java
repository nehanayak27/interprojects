package mavenpackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecLinkClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		SecLinkClick sc=new SecLinkClick();
		
		
		sc.sec2(driver);
		
	}
	
	public void sec(ChromeDriver driver)
	{
		driver.get("");
		List<WebElement> l=driver.findElements(By.tagName("a"));
		int v=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				v++;
				System.out.println(e.getText());
				if(v==2) 
				{
					e.click();
					break;
				}
			}
		}
	}
	
	public void sec2(ChromeDriver driver)
	{
		driver.get("https://httpstatuses.com/");
		List <WebElement> i=driver.findElements(By.tagName("a"));
		
		List <WebElement> j= new ArrayList<WebElement>();
		
		for(WebElement e:i)
		{
			if(e.isDisplayed())
			{
				System.out.println(j.add(e));
			}
		}
		j.get(0).click();
		
	}
	public void sec4(ChromeDriver driver)
	{
		driver.get("http://the-internet.herokuapp.com/");
		List <WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println("Total count of links"+l.size());
		int vl=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				vl++;
				
				if(vl==7)
				{
					System.out.println(e.getText());
					e.click();
					break;
				}
			}
		}
		driver.close();
	}

}
