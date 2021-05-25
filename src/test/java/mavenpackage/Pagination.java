package mavenpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://google.co.in");
		dr.findElement(By.name("q")).sendKeys("abdul kalam", Keys.ENTER);
		Thread.sleep(1000);
		//pagination 
		int nor=0;
		int p=1;
		//className("g")
		while(true)
		{
			List<WebElement> l=dr.findElements(By.className("g")); 
			
			if(p==1) {
				System.out.println(p+"st page"+l.size());
			}
			else if(p==2)
			{
				System.out.println(p+"nd page"+l.size());
				
			}
			else if(p==3)
			{
				System.out.println(p+"rd page"+l.size());
				
			}
			else
			{
				System.out.println(p+"th page contains"+l.size());
			}
			p++;
			dr.findElement(By.linkText("Next")).click();
			Thread.sleep(1000);	
			System.out.println("total number of results"+nor);
		}	
		
	}
	

}
