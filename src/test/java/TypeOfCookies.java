import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypeOfCookies {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://www.instagram.com");
		dr.manage().window().maximize();
		dr.findElement(By.name("username")).sendKeys("_nehanayak_");
		Thread.sleep(2000);
		dr.findElement(By.name("password")).sendKeys("Cookie@12!");
		dr.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("//*[@type='button']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[text()='Not Now']")).click();
		//comman code
		//collection of all loaded cookies
		Set<Cookie> s=dr.manage().getCookies();
		System.out.println("count of all cookies"+s.size());
		for(Cookie c:s)
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
		//dr.close();
	}

}
