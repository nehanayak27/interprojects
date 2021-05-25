package Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Emicalculator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		
		dr.get("https://emicalculator.net/");
		
		Actions act=new Actions(dr);
		WebElement l1=dr.findElement(By.id("loanamountslider"));
		WebElement l2=dr.findElement(By.id("loaninterestslider"));
		WebElement l3=dr.findElement(By.id("loantermslider"));
		
		act.dragAndDropBy(l1, 83, 0).build().perform();
		Thread.sleep(2000);
		
		act.dragAndDropBy(l2, 88, 0).build().perform();
		Thread.sleep(2000);
		
		act.dragAndDropBy(l3, -111, 0).build().perform();
		Thread.sleep(2000);
		
		System.out.println(dr.findElement(By.id("emiamount")).getText());
	}

}
