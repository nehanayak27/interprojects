package Dropdown;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownbySelect {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();	
		driver.get("https://www.google.com");
		WebElement x=driver.findElement(By.linkText("Gmail"));
		File dest=new File("C:\\elementw.png");
		File src=x.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		
		
		
		
		
		
	}

	public void dropdown(ChromeDriver driver)
	{
		driver.get("https://www.amazon.in/");
		WebElement e=driver.findElement(By.id("searchDropdownBox"));
		Select s=new Select(e);
		List<WebElement> items=s.getOptions();
		ArrayList<String> l1=new ArrayList<String>();
		ArrayList<String> l2=new ArrayList<String>();
		
		for(int i=2;i<items.size();i++ )
		{
			l1.add(items.get(i).getText());
			l2.add(items.get(i).getText());
			
		}
		//sort 2nd array
		Collections.sort(l2);
		//compare both array
		if(l1.equals(l2))
		{
			System.out.println("its sorted");
		}
		else
		{
			System.out.println("its not sorted");
		}
	}
}
