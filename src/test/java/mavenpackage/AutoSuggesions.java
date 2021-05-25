package mavenpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggesions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("http://google.co.in/");
		WebElement n=dr.findElement(By.name("q"));
		n.sendKeys("kalam");
		
		String k=dr.findElement(By.name("q")).getText();
		
		Thread.sleep(10000);
		WebElement autolist=dr.findElement(By.xpath("//*[@role='listbox']"));
		
		List<WebElement> autoresult=autolist.findElements(By.xpath("child::li"));
		
		//test case 1 - get count of all the suggesions in that cache element. 
		System.out.println("total count of the listed items"+autoresult.size());
		
		//test case 2 display all the auto result. 
		
		for(WebElement e:autoresult)
		{
			System.out.println(e.getText());
		}
		
		//test case 3 - check each text, which consist of given word or not.
		int flag=0;
		for(WebElement e:autoresult)
		{
			String y=e.getText();
			if(!y.contains(k))
			{
				flag=1;
				System.out.println(y+"doesnt contain "+k);
			}
		}
		if(flag==0)
		{
			System.out.println("The cache is passed for"+k);
		}
		else
		{
			System.out.println("the cache is failed for"+k);
		}
		
		
		dr.close();

	}

}
