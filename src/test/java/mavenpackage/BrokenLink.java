package mavenpackage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://www.spicejet.com/");
		List<WebElement> allelemnts=dr.findElements(By.xpath("//*"));
		System.out.println("Totalcount of elements on the page:"+allelemnts.size());
		//collecting the links. 
		List<WebElement> alhref=new ArrayList<WebElement>();
		
		for(WebElement e:allelemnts)
		{
			allelemnts=dr.findElements(By.xpath("//*"));
			if(e.getAttribute("href")!=null)
			{
				String x=e.getAttribute("href");
				if(x.startsWith("https")|x.startsWith("http"))
				{
					alhref.add(e);
				}
				
				
			}
	}
		System.out.println("Total number ofhyperlink"+alhref.size());
		//testing the links from the list of  alhref 
		int clc=0,blc=0;
		for(WebElement e:alhref)
		{
			String x=e.getAttribute("href");
			URL u=new URL(x);
			HttpURLConnection con=(HttpURLConnection) u.openConnection();
			con.connect();
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
		System.out.println("broken links"+blc);
		
		
		dr.close();
		
		
		
	}

}
