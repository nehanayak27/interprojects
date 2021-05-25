package Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksofHiddenAndVisible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//program to get all the visible and hidden links on the urlpage
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		
		dr.get("http://the-internet.herokuapp.com/");
		
		List<WebElement>p=dr.findElements(By.tagName("a"));
		System.out.println("total count of links" +p.size());
		int vl=0, hl=0;
		for(WebElement e:p)
		{
			if(e.isDisplayed()) 
			{
				vl++;
				System.out.println("The visible link:"+e.getText()+"-");
			}
			else
			{
				hl++;
			}
			
		}
		System.out.println("total number of visible links"+vl);
		System.out.println("total number of hidden links"+hl);
		dr.close();
		
	}

}
