package Classes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resuable {

	
	//properties
	private RemoteWebDriver driver;
	private ExtentReports er;
	private ExtentTest et;
	//constructor method. 
	
	public Resuable (String bn)
	{
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if (bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Wrong browser name");
			System.exit(0);
			
		}
		er=new ExtentReports("E:\\dummy.html",false);
		et=er.startTest("dummy testing in local");
		
		
		
	}
	public Resuable(String bn, String version, String os)
	{
		String USERNAME="mounika.gaddam029";
		String ACCESSKEY="a495f991edf04245ac4130b2b0ece783";
		
		String uri="http://mounika.gaddam029:a495f991edf04245ac4130b2b0ece783@ondemand.saucelabs.com:80/wd/hub";
		
		try 
		{
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setBrowserName(bn);
			dc.setCapability("version",version);
			if(os.equalsIgnoreCase("windows"))
			{
				dc.setCapability("platform", Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				dc.setCapability("platform", Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				dc.setCapability("platform", Platform.LINUX);
			}
			else
			{
				System.out.println("wrong OS name");
				System.exit(0);
			}
			
			URL u=new URL(uri);
			driver=new RemoteWebDriver(u,dc);
			
		} 
		
		catch (Exception e) 
		{
			
			System.out.println(e.getMessage());
			System.exit(0);
		}
		er=new ExtentReports("E:\\Batch251Selenium\\dummy.html",false);
		et=er.startTest("dummy testing in cloud");
		
	}
	
	public void launchsite(String url) throws Exception

	{
		Thread.sleep(5000);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	public void fillandvalidationlogin1(String uid, String uidc, String pwc,String pwdc) throws Exception 
	{
		driver.findElement(By.name("identifier")).sendKeys(uid);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(1000);
		try 
		{
			if(uidc.equalsIgnoreCase("blank") && driver.findElement(By.xpath("//*[@class='o6cuMc']")).isDisplayed())
			{
				et.log(LogStatus.PASS, "blank user id test passed");
			}
			else if(uidc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//div[@class='o6cuMc']")).isDisplayed())
			{
				et.log(LogStatus.PASS, "Invalid user id test passed");
			}
			else if(uidc.equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
			{
				//password testing
				driver.findElement(By.id("password")).sendKeys(pwc);
				driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
				Thread.sleep(1000);
				if(pwdc.equalsIgnoreCase("blank")&& driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "blank passwrd test passed");
				}
				else if(uidc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//span[contains(text(),'Wrong password. Try again or click Forgot password')]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Invalid passwrd  test passed");
				}
				else if(uidc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "login test passed with valid creds");
				}
				else
				{
					et.log(LogStatus.FAIL, "passwrd failed"+et.addScreenCapture(screenshot()));
				}
			}
			else
			{
				et.log(LogStatus.FAIL, "userid failed and try to watch "+et.addScreenCapture(screenshot()));
			}
			
			
		} 
		catch (Exception e) 
		{
			et.log(LogStatus.FAIL, e.getMessage()+et.addScreenCapture(screenshot()));
		}
		
	}
	
	public void close()
	{
		driver.close();
		er.flush();
		er.endTest(et);
		
	}
	private String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=sf.format(dt)+".png";
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File(fn);
		FileHandler.copy(src, dest);
		return (dest.getAbsolutePath());
		
	}
	
	
	
}
