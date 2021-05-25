import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArrayLists {
	
	public void dum()
	{
		String s=" poiuy";
		s.trim(); // remove the blank space in the string
		
		List<String> x=(List<String>) new ArrayList<String>();
		x.add("abcdefgh");
		x.add("nehanahah");
		x.add("tree");
		x.add("hjgj");
		for(int i=0;i<3;i++)
		{
		System.out.println(x);
		}
		long pp=x.spliterator().estimateSize();
		
		
		
		
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		Thread.sleep(5000);
		WebElement dropy=driver.findElement(By.id("oldSelectMenu"));
		
		Select s=new Select(dropy);
		List<WebElement> items=s.getOptions();
		ArrayList<String> l1=new ArrayList<String>();
		ArrayList<String> l2=new ArrayList<String>();
		for(WebElement e:items)
		{
			
			l1.add(e.getText());
			l2.add(e.getText());
			
		}
		//sort 2 array
		Collections.sort(l2);
		System.out.println(l2);
		l2.add("water");
		l2.add("fire");
		System.out.println(l2);
		System.out.println(l2.size());
		if(l2.contains("water"))
		{
			System.out.println("yes it is present");
		}
		else
		{
			System.out.println("no its not present");
		}
		
		
		
		
		
	}

}
