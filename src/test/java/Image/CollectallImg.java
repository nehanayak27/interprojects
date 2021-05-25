package Image;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollectallImg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//this program is to collect all images on the page, with visible image and hidden image. 
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		
		dr.get("https://emicalculator.net/");
		
		List<WebElement> img=dr.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		System.out.println("total count of images on the page"+img.size()); //size or count of the image on the web page. 
		
		//Separate visible image and hidden image. 
		List <WebElement> vi=new ArrayList<WebElement>();
		List <WebElement> hi=new ArrayList<WebElement>();
		for(WebElement e:img)
		{
			if(e.isDisplayed())
			{
				
				vi.add(e);
				try
				{
				if(vi.get(1).isSelected())
				{
					System.out.println("img is selected");
					
				}
				else
				{
					System.out.println("image isnt selected");
				}
				}
				catch(Exception ex)
				{
					
				}
			
			}
			else
			{
				hi.add(e);
			}
			
			
		}
		System.out.println("total count of visible image" +vi.size());
		System.out.println("total count of hidden image"+hi.size());
		
		//close site
		dr.close();
		
	}

}
