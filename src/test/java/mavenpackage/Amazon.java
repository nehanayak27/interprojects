package mavenpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		Amazon a=new Amazon();
		a.brokenlinks(dr);
		
	}
	public void brokenlinks(ChromeDriver dr)
	{
		dr.get("https://www.drupal.org/qed42");
		List<WebElement> Links=dr.findElements(By.tagName("a"));
		Links.addAll(dr.findElements(By.tagName("img")));
		System.out.println("link link" +Links.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		for (int i=0;i<Links.size();i++)
		{
			if(Links.get(i).getAttribute("href") !=null)
			{
				activeLinks.add(Links.get(i));
			}
		}
		System.out.println("active link" +activeLinks.size());
		dr.close();
	}
	
	public void drag(ChromeDriver dr)
	{
		dr.get("http://book.theautomatedtester.co.uk/chapter4");
		Actions act=new Actions(dr);
		act.moveToElement(dr.findElement(By.id("hoverOver"))).build().perform();
		

		
	}
	public void frame(ChromeDriver dr)
	{
		dr.get("https://www.amazon.com/");
		dr.findElement(By.xpath("//*[@id='nav-logo']")).click();
		WebElement ee=dr.findElement(By.xpath("//*[text()='Registry']"));
		System.out.println(ee.getText());
		if(ee.getText().contains("amazon"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		dr.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		dr.switchTo().frame("iframe-name");
		WebElement r=dr.findElement(By.xpath("//*[text()='Register']"));
		System.out.println(r.getText());
		WebElement rp=dr.findElement(By.xpath("//*[@class='login-btn'][2]"));
		System.out.println(rp.getText());
		rp.click();
		
		
	}
	public void webtable(ChromeDriver dr)
	{
		dr.get("http://the-internet.herokuapp.com/tables");
		
		String beforexpath="//*[@id=\"table1\"]/tbody/tr[";
		String afterxpath="]/td[1]";
		
		//*[@id="table1"]/tbody/tr[1]/td[1]
		//*[@id="table1"]/tbody/tr[2]/td[1]
		//*[@id="table1"]/tbody/tr[3]/td[1]
		//*[@id="table1"]/tbody/tr[4]/td[1]
		for(int i=1;i<=4;i++)
		{
			String ii=dr.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			System.out.println(ii);
			if(ii.contains("Doe"))
				//*[@id="table1"]/tbody/tr[3]/td[6]/a[1]
			{
				dr.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+i+"]/td[6]/a[1]")).click(); 
			}
		}
	}
	public void alert(ChromeDriver dr)
	{
		dr.get("http://demo.guru99.com/test/delete_customer.php");
		dr.findElementByName("cusid").sendKeys("testing");
		dr.findElement(By.name("submit")).click();
		Alert ac= dr.switchTo().alert();
		String alterm=ac.getText();
		System.out.println(alterm);
		ac.accept();
		String ax=ac.getText();
		System.out.println(ax);
	ac.accept();
		
		
		
		
	}
	public void maha(ChromeDriver dr) throws InterruptedException
	{
		dr.get("http://book.theautomatedtester.co.uk/chapter1");
	System.out.println(	dr.findElement(By.xpath("//*[text()='Selenium: Beginners Guide'][@class='mainheading']")).getText());
	boolean  boo=dr.findElementById("radiobutton").isDisplayed();
	System.out.println(boo);
	
	Select ss=new Select(dr.findElementById("selecttype"));
			ss.selectByVisibleText("Selenium RC");
			
			System.out.println(dr.findElementByLinkText("Home Page").getText());
			dr.findElement(By.id("secondajaxbutton")).click();
			
			String textt=dr.findElement(By.xpath("//*[text()='I have been added with a timeout']")).getText();
			
			if(textt.equals("I have been added with a timeout"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			dr.findElementById("multiplewindow").click();
			Set <String> handles =dr.getWindowHandles();
			Iterator<String> it = handles.iterator();
			//iterate through your windows
			while (it.hasNext()){
			String parent = it.next();
			String newwin = it.next();
			dr.switchTo().window(newwin);
			String url=dr.getCurrentUrl();
			System.out.println(url);
			String titlle=dr.getTitle();
			System.out.println(titlle);
			dr.switchTo().window(parent);

			
				
	}
			String h=dr.findElement(By.id("verifybutton")).getText();
			System.out.println(h);
//			boolean val=dr.findElement(By.id("verifybutton")).isDisplayed();
//			if(h.endsWith("here"))
//			{
//				System.out.println("pass");
//			}
//			else
//			{
//				System.out.println("fail-no text button");
//			}
//	
	
	
	
	dr.quit();
	
			
	}

}
