package mavenpackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Mavenclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver2= new FirefoxDriver();
		
//		WebDriverManager.edgedriver().setup();
//		EdgeDriver driver3=new EdgeDriver();
		
		WebDriverManager.operadriver().setup();
		OperaDriver driver4=new OperaDriver();
		
//		WebDriverManager.iedriver().setup();
//		InternetExplorerDriver driver5=new InternetExplorerDriver();
		
		
		
		
		

	}

}
