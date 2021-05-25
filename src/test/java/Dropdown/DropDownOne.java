package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		dr.manage().window().maximize();
		WebElement divdropdown=dr.findElement(By.xpath("//div[@class='simple example']/div[@class='ui dropdown']"));
		List<WebElement> totalList=divdropdown.findElements(By.xpath("//div[@class='simple example']/div[@class='ui dropdown']"));
		for(WebElement list:totalList)
		{
			String x=(String) dr.executeScript("return(arguments[0].textContent);", list);
			System.out.println(x);
			if(x.contains("Rename"))
			{
				System.out.println("the value is present");
				
			}
			else
			{
				System.out.println("the value isnt present");
			}
		}
		DropDownOne dp=new DropDownOne();
		dp.Multiiselect(dr);
		
		
		
		
	}
	public void Compare(ChromeDriver dr) throws InterruptedException
	{
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		WebElement outter=dr.findElement(By.xpath("//h4[text()='Selection']/following-sibling::div[2]"));
		if(outter.isDisplayed())
		{
			outter.click();
			
			System.out.println(outter.getText());
			
		}
		else
		{
			System.out.println("the dropdown isnt selected");
		}
		
		dr.navigate().refresh();
		
		List<WebElement> dropdownlist=dr.findElements(By.xpath("//h4[text()='Selection']/following-sibling::div[2]"));
		for(WebElement ds:dropdownlist )
		{
			outter.click();
			Thread.sleep(2000);
			if(ds.isDisplayed())
				try
			{
			{
				String expected=ds.getText();
				//get the item name
				ds.click();
				Thread.sleep(10000);
				String actual=ds.findElement(By.xpath("child::div[1]")).getText();
				if(expected.equals(actual))
				{
					System.out.println("expected is pass"+expected);
				}
				else
				{
					System.out.println("expected is fail"+expected);
				}
				
			}
			}
			catch(Exception ex)
			{
				String x=(String) dr.executeScript("return(arguments[0].textContent);", dropdownlist);
				System.out.println(x);
			}
			else
			{
				String x=(String) dr.executeScript("return(arguments[0].textContent);", dropdownlist);
				System.out.println(x);
			}
			
		}
		
		
		
	}
	public void Multiiselect(ChromeDriver dr)
	{
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		WebElement neighbor=dr.findElement(By.xpath("//h4[text()='Multiple Selection']"));
		
		//locate dropdown
		WebElement outter=dr.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div"));
		List<WebElement> cont=dr.findElements(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div"));
		for(WebElement i:cont)
		{
			String x=(String) dr.executeScript("return(arguments[0].textContent);", i);
			System.out.println(x);
		}
		
		
		
	}

}
