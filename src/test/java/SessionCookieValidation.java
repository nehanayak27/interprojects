import java.awt.Window;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SessionCookieValidation {

	public static void main(String[] args) throws Exception {
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
		dr.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s=dr.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		dr.switchTo().window(a.get(1));
		dr.get("https://mail.google.com/");
		Thread.sleep(1000);
		Set<Cookie> ss=dr.manage().getCookies();
		System.out.println("count of all cookies"+s.size());
		for(Cookie c:ss)
		{
			if(c.isHttpOnly())
			{
				System.out.println(c.getName()+"is http only cookie");
			}
			else if(c.isSecure())
			{
				//when url is https
				if(c.getName().equalsIgnoreCase("session-id")||c.getName().contains("SESSID"))
				{
					System.out.println(c.getName()+"is session cookie");
				}
				else if(c.getName().equalsIgnoreCase("session-id-time"))
				{
					System.out.println(c.getName()+" is persistance cookie");
					System.out.println("it can expire on"+c.getExpiry());
				}
				else
				{
					System.out.println(c.getName()+"is secure cookie only");
				}			
			}
			else if(c.getName().equalsIgnoreCase("session-id")||c.getName().contains("SESSID"))
			{
				System.out.println(c.getName()+"is session cookie");
			}
			else if(c.getName().equalsIgnoreCase("session-id-time"))
			{
				System.out.println(c.getName()+" is persistance cookie");
				System.out.println("it can expire on"+c.getExpiry());
			}
			else if(c.getDomain().contains("amazon.com"))
			{
				System.out.println(c.getName()+"is super cookie");
			}
			else if(c.getDomain().contains("amazon.in"))
			{
				System.out.println(c.getName()+"is same-site cookie");
			}
			else
			{
				System.out.println(c.getName()+"is third party cookie");
			}
			
		}
		
		try
		{
			if(dr.findElement(By.xpath("//div[contains(text(),'Compose')]")).isDisplayed())
			{
				System.out.println("test passed, compose button is visible");
			}
			else
			{
				System.out.println("test failed, compose button isnt visible");
			}
		}
		catch(Exception ex)
		{
			System.out.println("test failed, compose button isnt visible");
		}
		dr.close();
	}

}
