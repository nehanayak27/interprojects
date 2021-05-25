import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.www.protocol.http.HttpURLConnection;

public class WebTable1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://spicejet.com/");
		Thread.sleep(1000);
		List<WebElement> listing=driver.findElements(By.xpath("//*"));
		System.out.println("total count of elements on the page"+listing.size());
		
		List<WebElement> l2=new ArrayList<WebElement>();
		
		for(WebElement e:listing)
		{
			if(e.getAttribute("href")!=null)
			{
				String x=e.getAttribute("href");
				if(x.startsWith("https")||(x.startsWith("http")))
						{
								l2.add(e);
								
						}
			}
		}
		System.out.println("total count of elements on the page"+l2.size());
		
		
		int clc=0, blc=0;
	for(WebElement e:listing)
	{
		String x=e.getAttribute("href");
		URL u=new URL(x);
		HttpURLConnection con=(HttpURLConnection) u.openConnection();
		con.connect();
		Thread.sleep(1000);
		String y=con.getResponseMessage();
		if(y.equalsIgnoreCase("OK"))
		{
			clc++;
		}
		else
		{
			blc++;
			System.out.println(x+"returns"+y);
		}
		
	}
	System.out.println("correctly working links"+clc);
	
	System.out.println("incorrect links"+blc);
	driver.close();
	
	}
}
