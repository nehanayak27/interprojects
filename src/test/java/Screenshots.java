import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(1000);
		//get screenshot of the page
		File f=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\test-output\\pa.png");
		FileHandler.copy(f, des);
		
		//get element of screenshot
		WebElement d=driver.findElement(By.xpath("//h2[normalize-space()='Types']"));
		File f1=driver.getScreenshotAs(OutputType.FILE);
		File des1=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\test-output\\ele.png");
		FileHandler.copy(f1, des1);
		
		
	}

}
