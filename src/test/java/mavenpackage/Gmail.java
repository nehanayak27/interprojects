package mavenpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail {

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
		
		dr.findElement(By.id("link_enable_notifications")).click();
		Thread.sleep(1000);
	
		for(int i=0;i<10;i++)
		{
		
		dr.findElement(By.xpath("//*[@role='button'][@gh='cm']")).click();
		
		
		
		
		dr.findElementByName("to").sendKeys("nnk@gmail.com");
		dr.findElementByName("subjectbox").sendKeys("testing");
		dr.findElementByXPath("//*[@aria-label='Message Body'][@role='textbox']").sendKeys("testing");
		dr.findElementByXPath("//*[starts-with(@aria-label,'Send')][@role='button']").click();
		Thread.sleep(5000);
		}
		String sr=dr.findElement(By.xpath("//*[text()='Message sent.']")).getText();
		
		System.out.println(sr);
		
		dr.close();
		
		
	}

}
