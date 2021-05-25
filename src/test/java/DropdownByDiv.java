import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownByDiv {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		Carousel cc=new Carousel();
		cc.ebay(dr);
		
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		//WebElement dropdown=dr.findElement(By.xpath("//div[@class='another dropdown example visible']//div[@class='ui fluid selection dropdown']"));
		//dr.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[5]/div")).click();
		Thread.sleep(3000);
		List<WebElement>values=dr.findElements(By.xpath("//div[@class='ui fluid selection dropdown']//div[@class='menu transition hidden']"));
		for(WebElement e:values)
		{
			String x=(String) dr.executeScript("return(arguments[0].textContent);",e);
		System.out.println(x);
		}
	}

}
