package mavenpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		List <WebElement> l1= driver.findElements(By.xpath("//*"));
		System.out.println("list of all the links"+l1.size());
		
		List <WebElement> l2= new ArrayList<WebElement>();
		for(WebElement e:l1)
		{
			if(e.getAttribute("href")!=null)
				{
				String x=e.getAttribute("href");
				
				if(x.startsWith("https") || x.startsWith("http"))
				{
				l2.add(e);
				
				}
			}
		}
		
		System.out.println("total count of hyper links" +l2.size());
		
		//check each hyper link for broken link 
		int clc = 0, blc =0;
		for(WebElement e:l2)
		{
			String x=e.getAttribute("href");
			URL u=new URL(x); //consider href attribute as URL
			HttpURLConnection con=(HttpURLConnection) u.openConnection(); //open connection to server related to that URL
			con.connect(); 
			Thread.sleep(1000);
			
			//test response
			String y=con.getResponseMessage();
			if(y.equalsIgnoreCase("OK"))
			{
				clc++;
			}
			else
			{
				blc++;
				System.out.println(x+""+y);
			}
		}
		System.out.println("count of broekn links"+blc);
		System.out.println("count of broekn links"+clc);
		
		driver.close();
		
		
	}

}
