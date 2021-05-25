package mavenpackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//input[contains(@name, 'originStation1')])")).sendKeys("Bengaluru (BLR)");
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//input[contains(@name, 'destinationStation1')])")).sendKeys("Delhi (DEL)");
		Thread.sleep(5000);
		dr.findElement(By.linkText("12")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("(//*[@value='Search'])[1]")).click();
		
		//collect all flights information 
		List<WebElement> flights=dr.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr[not(contains(@class,'heading'))]"));
		
		
		List<Integer> fares=new ArrayList<Integer>();
		for(WebElement flight:flights)
		{
			String temp = flight.findElement(By.xpath("child::td[3]/descendant::span[1]")).getText(); //collect all t
			System.out.println(temp);
			temp=temp.replace(",", "");
			temp=temp.replace(" INR", "");
			int fare=Integer.parseInt(temp);
			fares.add(fare);
			
			
		
		}
		//find the min value
		int  index=0;
		int minfare=fares.get(0);
		for(int i=1;i<fares.size();i++)
		{
			if(minfare>fares.get(i))
			{
				minfare=fares.get(i);
				index=i;
			}
		}
		System.out.println(minfare+"at"+(index+1)+"th flight");
		flights.get(index).findElement(By.xpath("child::td[3]/descendant::input")).click();
		
		
		

	}
	
	public void min(ChromeDriver dr)
	{
		dr.get("https://book.spicejet.com/Select.aspx");
		
		
	}
}
