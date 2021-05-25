import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLogs {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter browser name");
		String bn=sc.nextLine();
		System.out.println("enter the url");
		String u=sc.nextLine();
		sc.close();
		RemoteWebDriver driver=null;
		
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("pls check the browser name");
			System.exit(0);
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(u);
		
		
		
		Thread.sleep(20000);
		List<LogEntry> alllogs=driver.manage().logs().get("browser").getAll();
		for(LogEntry e:alllogs)
		{
			System.out.println(e.getMessage()+"browser logs"+e.getTimestamp());
		}
		driver.close();
		
		
	}

}
