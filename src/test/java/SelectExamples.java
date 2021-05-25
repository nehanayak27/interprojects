import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectExamples {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://demoqa.com/select-menu");
		String c=dr.getWindowHandle();
		System.out.println(c);
		Select s=new Select(dr.findElement(By.id("oldSelectMenu")));
		List<WebElement> l=s.getOptions();
		//ArrayList<WebElement> a=new ArrayList<>();
		
		System.out.println(l.size());
		for(WebElement e:l)
		{
			System.out.println(e.getText());
		}
		
		dr.get("http://the-internet.herokuapp.com/dropdown");
		WebElement d=dr.findElement(By.id("dropdown"));
		Select s1=new Select(d);
		if(s1.isMultiple())
		{
			System.out.println("dropdown is multi select");
		}
		else
		{
			System.out.println("dropdown is single select");
		}
		
		dr.get("https://demoqa.com/select-menu");
		WebElement e=dr.findElement(By.id("cars"));
		ArrayList<WebElement>elements=new ArrayList<WebElement>();
		
		for(WebElement n:elements)
		{
			System.out.println(n.getText());
		}
		
		
		

	}
	

}
