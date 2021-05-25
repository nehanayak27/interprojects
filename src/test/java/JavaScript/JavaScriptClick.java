package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptClick {
	public void click(ChromeDriver driver) throws Exception
	{
		driver.get("http://the-internet.herokuapp.com/");
		//java script -click, by locating by swd
		WebElement clicking=driver.findElement(By.xpath("//*[text()='A/B Testing']"));
				driver.executeScript("arguments[0].click();",clicking);
				driver.navigate().back();
				//javascript only
	driver.findElement(By.xpath("//a[normalize-space()='Inputs']")).click();
		//java script -enter text, by locating by swd	
				Thread.sleep(1000);
				WebElement enterdata=driver.findElement(By.xpath("//input[@type='number']"));
				Thread.sleep(1000);
				driver.executeScript("arguments[0].value='neha nayak';",enterdata);
				
				
		//javascript color the box
				WebElement colorbar=driver.findElement(By.xpath("//input[@type='number']"));
				driver.executeScript("arguments[0].style.border='2px blue dotted';",colorbar);
				
			//javascript remove the box
				WebElement removedd=driver.findElement(By.xpath("//input[@type='number']"));
				driver.executeScript("arguments[0].remove();",removedd);
//js - change the password to text 
				
				
	}
	
	public void alrets(ChromeDriver driver, String Url, String texting) throws Exception
	{
		driver.get(Url);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys(texting);
		Thread.sleep(1000);
		String result=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		if(texting.contains("result"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		JavaScriptClick c=new JavaScriptClick();
		c.alrets(driver, "http://the-internet.herokuapp.com/javascript_alerts", "hello booo boooo");

	}

}
