package Image;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollectAllImages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("http://the-internet.herokuapp.com/");
		Thread.sleep(1000);
		List<WebElement> total=dr.findElements(By.xpath("(img)|//input[@type='image']"));
		System.out.println("total count of images" +total.size());
		
		//collect list of all images and click on the second image. 
		
		int vi=0, hi=0;
		for(WebElement e:total)
		{
			if(e.isDisplayed())
			{
				vi++;
				
				if(vi==2)
				{
					System.out.println(e.getAttribute("value"));
					e.click();
					break; //terminate the loop
				}
			}
			
			
		}
		CollectAllImages ci=new CollectAllImages();
		
		
		//close site
		
		dr.close();
		
		
	}
	
	public void radio(ChromeDriver dr)
	{
		dr.get("the-internet.herokuapp.com");
		List<WebElement> totalrad=dr.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("total number of radio button" +totalrad.size());
		int vr=0, er=0, sr=0;
		
		for(WebElement e:totalrad)
		{
			if(e.isDisplayed())
			{
				vr++;
				System.out.println("radio button is displayed");
				
				if(e.isEnabled())
				{
					er++;
					System.out.println("radio button is enabled");
						if(e.isSelected())
						{
							sr++;
							System.out.println("radio button is selected");
						}
						else
						{
							System.out.println("radio button is not selected");
						}
				}
				else
				{
					System.out.println("radio button is not enabled");
				}
				
			}
			else
			{
				System.out.println("radio button is not displayed");
			}
		}
		dr.close();
	}

}
