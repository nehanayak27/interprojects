package SeleniumPracInterviewPreps;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHand1 {

	public void windo() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		System.out.println("parent window"+driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[normalize-space()='New Window Message']")).click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
        java.util.Iterator<String> iterator = allWindowHandles.iterator();
  
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.xpath("//body"));
                System.out.println("Heading of child window is " + text.getText());
                String url= driver.getCurrentUrl();
                System.out.println(url);
                String title= driver.getTitle();
                System.out.println(title);
            }
        }
	
		
		
		
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WindowHand1 w= new WindowHand1();
		w.windo();
	}

}
