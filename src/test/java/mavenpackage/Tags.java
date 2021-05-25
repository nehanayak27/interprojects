package mavenpackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tags {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		List <WebElement> l1= driver.findElementsByXPath("//*");
		
		System.out.println("total number of elements on the page" +l1.size());
		
		List <WebElement> l2= driver.findElementsByTagName("input");
		System.out.println("total number of input tags on the page" +l2.size());
		
		int rcb=0;
		int cb=0;
		int hl=0;
		int ulc=0;
		int others=0;
		
		for(WebElement e:l2)
		{
			String x=e.getAttribute("type");
			if(x.equals("radio"))
			{
				rcb++;
			}
			else if(x.equals("checkbox"))
			{
				cb++;
			}
			else if(x.equals("hidden"))
			{
				hl++;
			}
			else if(x.equals("URL"))
			{
				ulc++;
			}
			else 
			{
				others++;
			}
			
		}
		System.out.println("count of radio button"+rcb);
		System.out.println("count of checkbox button"+cb);
		System.out.println("count of hidden links"+hl);
		System.out.println("count of url"+ulc);
		System.out.println("count of others"+others);
	}

}
