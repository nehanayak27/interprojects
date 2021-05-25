package mavenpackage;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		Set<Cookie> cookie=dr.manage().getCookies();
		ArrayList<Cookie> arlist=new ArrayList<Cookie>(cookie);
		System.out.println("cookie size" +arlist.size());
		dr.get("http://gmail.com/");
		cookie=dr.manage().getCookies();
		arlist=new ArrayList<Cookie>(cookie);
		System.out.println("cookie size" +arlist.size());
		dr.manage().deleteAllCookies();
		cookie=dr.manage().getCookies();
		arlist=new ArrayList<Cookie>(cookie);
		if(arlist.size()==0)
		{
			System.out.println("cookies deleted fully");
		}
		else
		{
			System.out.println("cookies not deleted fully");
		}
		
	}

}
