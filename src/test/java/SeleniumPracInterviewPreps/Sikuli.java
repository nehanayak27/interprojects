package SeleniumPracInterviewPreps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikuli {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		Screen sc=new Screen();
	//sc.doubleClick("src\\test\\resources\\doubleclick.PNG");
	sc.rightClick("src\\test\\resources\\righclick.PNG");
	driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
	sc.type("\\src\\test\\resources\\namePNG.PNG","neha nayak");
	int a=9, b=3; 
	String c="neha";
			String d=a+b+c;
	System.out.println(d);
	
		
		//Pattern p=new Pattern("src\\test\\resources\\rebin.PNG");
		//sc.click(p);
	
	
		

	}

}
