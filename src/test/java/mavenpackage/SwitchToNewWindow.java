package mavenpackage;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToNewWindow {

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
		Thread.sleep(2000);
		
		dr.findElement(By.xpath("//*[@gh='cm']")).click();
		Thread.sleep(5000);
		dr.findElementByName("to").sendKeys("nnayakk1994@yahoo.com");
		dr.findElementByName("subjectbox").sendKeys("testing");
		dr.findElementByXPath("//*[@aria-label='Message Body'][@role='textbox']").sendKeys("testing");
		dr.findElementByXPath("//*[starts-with(@aria-label,'Send')][@role='button']").click();
		Thread.sleep(5000);
		String sr=dr.findElement(By.xpath("//*[text()='Message sent.']")).getText();
		
		System.out.println(sr);
		
		dr.switchTo().newWindow(WindowType.TAB);
		//collect the handle values of all tabs. 
				Set<String> s=dr.getWindowHandles();
				ArrayList<String> a=new ArrayList<String>(s);
				//switch to new window. 
				dr.switchTo().window(a.get(1));
				dr.get("https://login.yahoo.com/");
				dr.findElement(By.name("username")).sendKeys("nnayakk1994");
				dr.findElement(By.name("signin")).click();
				Thread.sleep(2000);
				dr.findElement(By.id("login-passwd")).sendKeys("Donut@2020");
				
				dr.findElement(By.id("login-signin")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='header-mail-button'][@title='Mail']")).click();
				//get address from the latest mail in mail boxx 
				WebElement x=dr.findElement(By.xpath("//*[@data-test-id='senders']/span[1]/span"));
				if(x.equals("neha nayak"))
					{
							System.out.println("the message is sent successful");
						}
					else
					{
						System.out.println("the message isnt sent successful");
					}
				
				//yahoo logout 
				Thread.sleep(2000);
				dr.findElement(By.xpath("//*[@id='ybarAccountMenu']")).click();
				
				dr.findElement(By.xpath("a[class='_yb_d1hyh _yb_1ys20 _yb_1oqc4 _yb_u527l _yb_1mz6y _yb_1k1c3']")).click();
				
				//switch back to gmail. 
				dr.switchTo().window(a.get(0));
				
				//do logout. 
				dr.findElementByXPath("//img[@class='gb_Ha gbii']").click();
				
				dr.findElement(By.xpath("//a[normalize-space()='Sign out of all accounts']")).click();
				dr.quit();
	
	}

}
