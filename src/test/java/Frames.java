import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public void examples(ChromeDriver dr) throws InterruptedException
	{

		dr.get("https://demoqa.com/frames");
		dr.switchTo().frame("frame1");
		System.out.println(dr.findElement(By.id("sampleHeading")).getText());
		dr.switchTo().defaultContent();
		System.out.println(dr.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText());
		dr.switchTo().frame("frame2");
		System.out.println(dr.findElement(By.id("sampleHeading")).getText());
		dr.switchTo().defaultContent();
		
		//new site 
		dr.get("http://the-internet.herokuapp.com/frames");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/a")).click();
		
		
		
		
		dr.switchTo().frame("frame-bottom");
		System.out.println(dr.findElement(By.xpath("/html/body")).getText());
		dr.navigate().back();
		dr.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		System.out.println(dr.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
		WebElement top=dr.findElement(By.xpath("//*[@class='tox-toolbar__primary']/div"));
		List<WebElement> data=top.findElements(By.xpath("child::button"));
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
			
		}
		Thread.sleep(20000);
		dr.navigate().back();
		Thread.sleep(20000);
		dr.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		dr.manage().window().maximize();
		dr.findElement(By.id("iFrame")).click();
		WebElement e=dr.findElement(By.xpath("(//iframe)[3]"));
		dr.switchTo().frame(e);
		System.out.println(dr.findElement(By.className("header_contacts")).getText());
		
		
		
	
		
		
		
		
		
		
		
	}

}
