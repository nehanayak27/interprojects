import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramsOnGmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://mail.google.com/");
		dr.findElementById("identifierId").sendKeys("nnk202020@gmail.com");
		dr.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		dr.findElementByName("password").sendKeys("Nehanayak12!");
		dr.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		
		
		WebElement mails=dr.findElement(By.xpath("(//table)[7]/tbody/tr"));
		for(int i=0;i<8;i++)
		{
			List<WebElement> rows=dr.findElementsByXPath("//tr[@jsmodel='nXDxbd']");
			for(WebElement e:rows)
			{
				WebElement text=dr.findElement(By.xpath("//*[@class=\'y6\']"));
				System.out.println(text.getText());
			}
			
		}
		
		
		
		
		
	
		
	
	}

}
