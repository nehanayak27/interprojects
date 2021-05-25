package mavenpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllInputTag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://www.spicejet.com/");
		//count of all elements
		List<WebElement> alltags=dr.findElements(By.xpath("//*"));
		System.out.println("total number of input tags" +alltags.size());
		
		List<WebElement> allinputtags=dr.findElements(By.tagName("input"));
		System.out.println("total number of input tags" +allinputtags.size());
		int hidden=0,url=0,button=0,text=0,password=0,checkbox=0, email=0,others=0;
		for(WebElement e:allinputtags)
		{
			String x=e.getAttribute("type");
			if(x.equals("hidden"))
			{
				hidden++;
			}
			else if (x.equals("url"))
			{
				url++;
			}
			else if(x.equals("button"))
			{
				button++;
			}
			else if(x.equals("text"))
			{
				text++;
			}
			else if(x.equals("password"))
			{
				password++;
			}
			else if(x.equals("checkbox"))
			{
				checkbox++;
			}
			else if(x.equals("email"))
			{
				email++;
				
			}
			else
			{
				others++;
			}
		}
		System.out.println("total count of hidden elements"+hidden);
		System.out.println("total count of url elements"+url);
		System.out.println("total count of button  elements"+button);
		System.out.println("total count of text  elements"+text);
		System.out.println("total count of password  elements"+password);
		System.out.println("total count of checkbox  elements"+checkbox);
		System.out.println("total count of email elements"+email);
		System.out.println("other elements"+others);
		
		
	}

}
