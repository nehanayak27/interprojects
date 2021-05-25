package Mailexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Attachment {

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
		Thread.sleep(20000);
		int start=0;
		int unstarted=0;
		
		WebElement table=dr.findElement(By.xpath("(//table)[7]/tbody"));
		List<WebElement> rows=table.findElements(By.xpath("child::tr[@role='row']"));
		
		WebElement attachment=dr.findElement(By.xpath("//tr[@jsmodel='nXDxbd']//div[@class='brd']/div"));
		
		for(WebElement c:rows)
		{
			
			if(attachment.getAttribute("data-chipenabled").contains("true"))
			{
				System.out.println("attachment is present");
			}
			else
			{
				table.findElement(By.xpath("//*[@data-tooltip='Select']")).click();
			}
			
		}
	
		
		
		
		
		
		/* started and unstarted logics
		
//WebElement attach=//tr[@jsmodel='nXDxbd']//div[@class='brd']/div
List<WebElement> rows1=dr.findElements(By.xpath("//tr[@jsmodel='nXDxbd']//div[@class='brd']/div"));


for(WebElement e:rows1)
{
System.out.println(e.getText());

}


List<WebElement> started=dr.findElements(By.xpath("//*[@aria-label=\'Starred']"));
System.out.println("The started count"+started.size());
for(int i=0;i<24;i++)
{
 started.get(i).click();
}
List<WebElement> notstarted=dr.findElements(By.xpath("//*[@aria-label='Not starred']"));
System.out.println("The un started count"+notstarted.size());
for(int n=0;n<29;n++)
{
	notstarted.get(n).click();
}
		
		
		
	*/	
		
	}

}
