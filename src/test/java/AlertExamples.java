import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExamples {

	@Test
	public void meth(){
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://demoqa.com/alerts");
		dr.findElement(By.id("confirmButton")).click();
		String x=dr.switchTo().alert().getText();
		System.out.println(x);
		dr.switchTo().alert().accept();
		
		String data=dr.findElement(By.id("confirmResult")).getText();
		if(data.contains("Ok"))
		{
			System.out.println("test pass");
		}
	
		else
		{
			System.out.println("test fail");
		}
		dr.findElement(By.id("promtButton")).click();
		dr.switchTo().alert().sendKeys("nnk");
		
		
	}

}
