import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselLoop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://www.flipkart.com");
		
Thread.sleep(5000);
		
		dr.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement cslider=dr.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div/div[1]"));
		//Test case 1 - get count of visible slider 
		String x= cslider.getTagName();
		int count =0;
		List<WebElement> slides;
		if(x.equals("div"))
				{
					slides=cslider.findElements(By.xpath("child::div"));
					for(WebElement slide:slides)
					{
						try
						{
							if(slide.getAttribute("data-clone").equals("false"))
							{
								count=count+1;
							}
						}
						catch (Exception ex)
						{
							//dev didnot use data clone concept
							count=count+1;
						}
						
						
					}
					
					
					}
		else
		{
			//each slide is <li>
			slides=cslider.findElements(By.xpath("child::li"));
			count=slides.size();
			
		}
		
	}

}
