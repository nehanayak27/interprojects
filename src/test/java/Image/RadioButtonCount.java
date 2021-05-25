package Image;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this program is to collect all radio button on the page, and click on the 3rd radio button 
				WebDriverManager.chromedriver().setup();
				ChromeDriver dr=new ChromeDriver();
				
				
				dr.get("https://www.spicejet.com/");
				
				List<WebElement> radio=dr.findElements(By.xpath("//input[@type='radio']"));
				System.out.println("total radio button on the page"+radio.size()); //total count of the radio buttons on the page
				int vradio=0, hiddenradio=0;
				for(WebElement e:radio)
				{
					if(e.isDisplayed())
					{
						vradio++;
						if(vradio==3)
						{
							e.click();
							break;
						}
					}
					
				}
				
				

	}

}
