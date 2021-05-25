import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver dr=new ChromeDriver(); //2nd way 
		
		NewWindowExample nn=new NewWindowExample();
		nn.newness(dr);
		
		
	}
	
	public void newness(WebDriver dr) throws Exception
	{
		dr.get("https://demoqa.com/browser-windows");
		//jygjkg
		
		
			dr.switchTo().newWindow(WindowType.WINDOW);
		//collect the handle values of all tabs. 
				Set<String> s=dr.getWindowHandles();
				ArrayList<String> a=new ArrayList<String>(s);
				dr.switchTo().window(a.get(1));
				dr.get("https://www.amazon.in");
				 s=dr.getWindowHandles();
				 a=new ArrayList<String>(s);
				dr.switchTo().window(a.get(1));
				dr.get("https://www.selenium.dev");
				dr.findElement(By.id("")).getAttribute("tag");
				dr.navigate().to("https://www.w3schools.com/java/java_arrays.asp");
				
				URL u=new URL("https://www.amazon.in/");
				dr.navigate().to(u);
				
				dr.navigate().back();
				dr.navigate().forward();
			
				
	}

}
