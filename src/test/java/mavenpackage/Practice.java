package mavenpackage;



import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class Practice {
	
	public void eg(ChromeDriver dr)
	{
		dr.get("https://www.globalsqa.com/demo-site/select-dropdown-menu");
		WebElement e=dr.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
		Select s=new Select(e);
		List<WebElement> l=s.getOptions();
		System.out.println(l.size());
		for(WebElement x:l)
		{
			
			System.out.println(x.getText());
			
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver(); //2nd way 
		Practice p=new Practice();
		p.multiselect(dr);
			
		
	}

	private void multiselect (ChromeDriver dr) throws Exception 
	
	{
		// TODO Auto-generated method stub
		dr.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		dr.switchTo().frame("iframeResult");
		WebElement e=dr.findElement(By.name("cars"));
		Select s=new Select(e);
		Actions act=new Actions(dr);
		act.keyDown(Keys.CONTROL).perform();
		act.click(s.getOptions().get(1))
			.click(s.getOptions().get(0))
			.click(s.getOptions().get(2)).perform();
		act.keyUp(Keys.CONTROL).perform();
		String cc=s.getFirstSelectedOption().getText();
		System.out.println(cc);
		List<WebElement> ll=s.getAllSelectedOptions();
		for(WebElement d:ll)
		{
			System.out.println(d.getText());
		}
		s.getAllSelectedOptions().get(0).getText();
		s.deselectByIndex(0);
		s.deselectByVisibleText("Saab");
		s.deselectAll();
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		AShot as =  new AShot();
		ShootingStrategy shs= ShootingStrategies.viewportPasting(1000);
		Screenshot ss=as.shootingStrategy(shs).takeScreenshot(dr);
		File dest=new File("E:\\fullpagescreenshotd.png");
		ImageIO.write(ss.getImage(), "PNG", dest);
			
		
	}

}
