package Links;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) dr;
		ExtentReports er;
		ExtentTest et;
		
		dr.get("https://www.eurodyn.com");
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(1000,0)");
		dr.manage().window().maximize();
		WebElement Element = dr.findElement(By.xpath("//*[@id='av_section_5']/div/div/div/div/div[2]/div[2]/div/div/div/img"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		WebElement mm = dr.findElement(By.xpath("//div[@id='av_section_5']//img[@title='Print']"));
		Actions act=new Actions(dr);
		WebElement e = dr.findElement(By.id("top"));
		act.moveToElement(e).perform();
		Thread.sleep(1000);
		Actions act2=new Actions(dr);
		WebElement e2 = dr.findElement(By.xpath("//h1[text()='Our Products']"));
		act.moveToElement(e2).perform();
		 
		 
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
	
		js.executeScript("arguments[0].scrollIntoView();",Element );
		
		
		
	}

}
