import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableMailsTest1 {

	public void Add(ChromeDriver driver)
	{
		for(int i=0;i<15;i++)
		{
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys("testfirstname");
		driver.findElement(By.id("lastName")).sendKeys("testlastname");
		driver.findElement(By.id("userEmail")).sendKeys("testusername@nm.vom");
		driver.findElement(By.id("age")).sendKeys("12");
		driver.findElement(By.id("salary")).sendKeys("120000");
		driver.findElement(By.id("department")).sendKeys("testdep");
		driver.findElement(By.id("submit")).click();
		}
		for(int i=0;i<5;i++)
		{
			driver.findElement(By.xpath("//*[contains(@id, 'delete-record')]")).click();
		}
	}
	public void Display(ChromeDriver driver)
	{
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@class='rt-tbody']/div/div[@role]"));
		for(WebElement e:rows)
		{
			WebElement x=driver.findElement(By.xpath("//*[@class='rt-tbody']/div/div[@role]/div[@class]"));
			List<WebElement> data=x.findElements(By.xpath("child::preceding-sibling::*"));
			for(WebElement vv:data)
			{
				String output=x.findElement(By.xpath("//*[@class='rt-td'][3]")).getText();
				System.out.println(x);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables"); 
		driver.manage().window().maximize();
		WebTableMailsTest1 web=new WebTableMailsTest1();
		web.Add(driver);
		web.Display(driver);
		
		/*  WebElement outter=driver.findElement(By.className("//*[@class='rt-tbody']/div"));
		List<WebElement>rows=outter.findElements(By.xpath("child::div"));
		
		for(int i=0;i<rows.size();i++)
		{
		System.out.println(rows.get(i).getText());
		}
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frame);
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		for(int i=0;i<2;i++)
		{
			
	a.moveToElement(driver.findElement(By.xpath("//*[@role='tab'][@aria-selected='false']"))).doubleClick().build().perform();
		}
		*/
		
		/*
		driver.findElement(By.id("ui-id-1")).click();
		Thread.sleep(1000);
		for(int i=0;i<4;i++)
		{
			driver.findElement(By.xpath("//*[contains(@id, 'delete-record')]")).click();
			//System.out.println(driver.findElement(By.xpath("//*[contains(@class, 'ui-accordion-content ')]")).getText());
			Thread.sleep(2000);
		
		}
		*/
		
		
	}

}
