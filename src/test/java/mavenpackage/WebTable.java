package mavenpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://google.co.in/");
		Thread.sleep(1000);
		dr.findElement(By.name("q")).sendKeys("kalam", Keys.ENTER);
		Thread.sleep(1000);
		//collect all link type
		List <WebElement> alllinks=dr.findElements(By.xpath("(//a)|(//link)|(//href)|(//base)|(//area)|(//div)|(//img)|(//script)"));
		System.out.println("total count of links" +alllinks.size());
		
		List<WebElement> l2=new ArrayList<WebElement>();
		//collect all links type element in current page. 
		for(WebElement e:alllinks)
		{
			try 
			{
			if(e.getAttribute("href")!=null)
			{
				String x=e.getAttribute("href");
					if(x.startsWith("https")|x.startsWith("http"))
					{
						l2.add(e);
					}
			}
		
			}
			catch(Exception ex)
			{
				alllinks=dr.findElements(By.xpath("(//a)|(//link)|(//href)|(//base)|(//area)|(//div)|(//img)|(//script)"));
			}
		}
		
		int clc=0,blc=0;
		//test each link
		for(WebElement e1:l2)
		{
			String x=e1.getAttribute("href");
			URL u=new URL(x);
			HttpURLConnection con=(HttpURLConnection) u.openConnection();
			String y=con.getResponseMessage();
			int z=con.getResponseCode();
			if(y.equals("OK"))
			{
				clc++;
			}
			else
			{
				blc++;
				System.out.println(x+"URL"+y+"broken link"+z);
			}
			con.disconnect();
		}
		dr.findElement(By.linkText("Next")).click();
		
		System.out.println("total correct link "+clc);
		
		System.out.println("total broken link "+blc);
		dr.close();
	}
	
}
