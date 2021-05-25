package mavenpackage;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://mail.google.com/");
		Thread.sleep(1000);
		//create a new tab
		dr.switchTo().newWindow(WindowType.TAB);
		//collect the handle values of all tabs. 
		Set<String> s=dr.getWindowHandles();
		ArrayList<String> a=new ArrayList<String>(s);
		//switch to new window. 
		
		
		ArrayList<Integer> vv=new ArrayList<Integer>();
		vv.add(7);
		
		
		
		
		dr.switchTo().window("");
		dr.get("http://durgasoftvideos.com/core-java-ratan/");
		dr.quit();
	}

}
