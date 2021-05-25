package ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DistinctValuesInDynamcArrays {
	
	public void arr()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the values u want in the array");
		int xx=sc.nextInt();
	
		ArrayList<Integer> a=new ArrayList<Integer>();
		
		
		for(int i=0;i<xx;i++)
		{
			a.add(sc.nextInt());
		}
		System.out.println("added in arraylist"+a.toString());
		
		for(int i=10;i>=0;i--)
		{
			System.out.println("count "+i);
		}
	}
	public void nn(ChromeDriver driver)
	{
		driver.get("https://jqueryui.com/button/");
		List<WebElement> tl=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("No of text boxes in page are: "+tl.size());
		driver.switchTo().frame(0);
		List<WebElement> bl=driver.findElements(By.xpath("(//button)|(//input[@type='button' or @type='submit' or @role='button'])|(//a[@role='button'])"));
		System.out.println("No of buttons in page are: "+bl.size());
		driver.switchTo().defaultContent();
		List<WebElement> framesinpage=driver.findElements(By.xpath("//input[@type='iframe']"));
		System.out.println("No of frames in page are: "+framesinpage.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctValuesInDynamcArrays cc=new DistinctValuesInDynamcArrays();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		cc.nn(driver);
		//driver.switchTo().frame(0);
		
		
		

	}

}
