package Links;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		
		dr.get("https://www.spicejet.com/");
		
		List<WebElement> allelements=dr.findElements(By.xpath("//*"));
		System.out.println(allelements.size());
		List<WebElement> hlinks=new ArrayList<WebElement>();
		for(WebElement e:allelements)
		{
			if(e.getAttribute("href")!=null)
			{
				String x=e.getAttribute("href");
				if(x.startsWith("https")|x.startsWith("http"))
				{
					hlinks.add(e);
					
				}
			
			
			
			}
			
			
		}
		System.out.println("Total count of hyper link");
		
		
		
		
	}

}
