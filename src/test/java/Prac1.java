import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prac1 {
	
	@FindBy (how=How.XPATH, using="//*[text()='Bank Manager Login']")
	public WebElement bankmanagerlogin;
	public void email()
	{
		bankmanagerlogin.click();
	}
	
	
	

}
