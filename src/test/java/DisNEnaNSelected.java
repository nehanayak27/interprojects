import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisNEnaNSelected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		WebElement add=dr.findElement(By.xpath("//*[@class='advertisement']"));
		
		WebElement voicd=dr.findElement(By.xpath("//*[@class='search']/following-sibling::span[@class='text']"));
		
		
		if(voicd.isDisplayed())
		{
			System.out.println("the element is visible");
			if(voicd.isEnabled())
			{
				System.out.println("the elemnt is enabled");
				if(voicd.isSelected())
				{
					System.out.println("the element is selected");
				}
				else
				{
					System.out.println(" the element isnt selected");
				}
			}
			else
			{
				System.out.println("the element is disabled");
			}
		}
		else
		{
			System.out.println("the element isnt visible");
		}
	}

}
