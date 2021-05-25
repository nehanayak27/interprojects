package SeleniumPracInterviewPreps;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchnoOfWords {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the word to be searched");
		String x=sc.nextLine();
		System.out.println("enter the target word");
		String y=sc.nextLine();
		sc.close();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://google.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		 driver.findElement(By.name("q")).sendKeys("neha nayak", Keys.ENTER);
		 //pagination on page
		 int currectpageindex=0;
		 int total=0;
		 
		

	}

}
