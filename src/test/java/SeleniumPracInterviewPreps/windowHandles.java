package SeleniumPracInterviewPreps;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String>s=driver.getWindowHandles();
		
		
		List<String> list = s.stream().collect(Collectors.toList());

		java.util.Iterator<String> I1= list.iterator();
		String child_window=I1.next();
		if(!parent.equals("CDwindow-029E5E0E9983D56F83081744090F2A2E"))
		{
			Thread.sleep(10000);	
		driver.switchTo().window(child_window);
		String titc=driver.getTitle();
		System.out.println(titc);
		Thread.sleep(10000);
		String titl=	driver.switchTo().window(child_window).getTitle();
		System.out.println(titl);

		
		}
		
		driver.switchTo().window(parent);
		
		
		
		
		
		
	}

}
