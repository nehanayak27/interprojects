package SeleniumPracInterviewPreps;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePagination {
	
	public void pagination(ChromeDriver driver)
	{
		driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
		driver.manage().window().maximize();
		int nop=0;
		
		WebDriver dri=new ChromeDriver();
	
		Set<Cookie> cookiess=driver.manage().getCookies();
		for(Cookie e:cookiess)
		{
			
		System.out.println(e.getName()+"path"+e.getDomain());
		}
		
		
		//pagination from 1 to last page   //a[normalize-space()='1']
		int j=1;
		while(true)
		try{	
		{	List<WebElement> pagination=driver.findElements(By.xpath("//tbody[@id='myTable']/tr"));
					for(int i=0;i<pagination.size();i++)
						{
							String x=pagination.get(i).getText();
							System.out.println(x);
						}
			Thread.sleep(10000);
			driver.findElement(By.xpath("//a[normalize-space()='"+j+"']")).click();
			
			j++;
			nop++;
		}
		}
		catch(Exception ex)
		{
			break;
		}
		System.out.println("total no of pages count"+nop);
		driver.close();
	}
	
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		WebTablePagination pp=new WebTablePagination();
		//pp.pagination(driver);
		pp.flaging();
	
		
	}
	
	public void WebTabledataentry(ChromeDriver driver)
	{
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		WebElement search=driver.findElement(By.id("task-table-filter"));
			search.click();
			search.sendKeys("land");
			String vv=driver.findElement(By.xpath("//*[@id=\"task-table\"]/tbody")).getText();
			System.out.println(vv);
	}
	
	public void flaging()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sentence");
		String cc=sc.nextLine();
		
		//String var="hello from from other side of the world";
		int flag =0; 
		int count=0;
		for(int i=1;i<cc.length()-1;i++)
		{
			
			if(cc.contains("hel"))
			{
				
			count++;
				break;
			}
			
		}
		if(flag==1)
		{
			System.out.println("the sentence contains word"+count);
			
		}
		else
		{
			System.out.println("the sentence doesnt contain word");
		}
		
		
	}

}
