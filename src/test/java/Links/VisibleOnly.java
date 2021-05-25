package Links;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisibleOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//this program is to find how many links are present on the page, get details of the link and click on the second link
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		
		dr.get("http://the-internet.herokuapp.com/");
		
		List<WebElement> p=dr.findElements(By.tagName("a"));
		
		System.out.println("total number of links on the page"+p.size());
		int vl=0;
		for(WebElement e:p)
		{
			if(e.isDisplayed()) {
				vl++;
				if(vl==7)
				{
					System.out.println(e.getText());
					e.click();
					break;//terminate the loop
				}
			}
			
		}
		
	}
	
	public void otherlogic(ChromeDriver dr)
	{
		dr.get("http://the-internet.herokuapp.com/");
		List<WebElement> l1=dr.findElements(By.tagName("a"));
		
		System.out.println("List of web links on the page"+l1.size());
		
		List <WebElement> l2=new ArrayList<WebElement>();
		
		for(WebElement e:l1)
		{
			if(e.isDisplayed())
			{
				l2.add(e);
				
			}
		}
		System.out.println(l2.get(0).getText());
		dr.close();
		
	}

}
