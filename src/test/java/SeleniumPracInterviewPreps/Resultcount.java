package SeleniumPracInterviewPreps;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resultcount {

	public void googkesearchresultcount(ChromeDriver driver)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value");
		String name=sc.nextLine();
		sc.close();
		int nop=0;
		driver.get("http://google.co.in/");
		driver.findElement(By.name("q")).sendKeys("sumnath pai", Keys.ENTER);
		
		List<WebElement> listofvalue=	driver.findElements(By.xpath("//h3[contains(text(),'Sumanth Pai')]"));
		for(WebElement e:listofvalue )
		{
			if(listofvalue.contains("Consultant"))
			{
				String x=e.getText();
				System.out.println(x);
				e.click();
				nop++;
			}
		}
		System.out.println("total no of person as consultant"+nop);
		
		
	}
		
	
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resultcount cc=new Resultcount();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		cc.googkesearchresultcount(driver);

	}

}
