package SeleniumPracInterviewPreps;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ifconditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the word to search");
			String word=sc.nextLine();
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://google.co.in/");
				driver.findElement(By.name("q")).sendKeys(word, Keys.ENTER);
				int nor=0; 
				int p=1;
			while(true)
			{
				
				try {
					List<WebElement> l=driver.findElements(By.className("g"));
					nor=nor+l.size();
					if(p==1)
					{
						System.out.println(p+"st page contains of"+l.size());
					}
					else if(p==2)
					{
						System.out.println(p+"nd page contains of"+l.size());
					}
					else if(p==3)
					{
						System.out.println(3+"rd page contains of"+l.size());
					}
					else
					{
						System.out.println(p+"th page contains of"+l.size());
					}
					//go to next page
					p++;
					driver.findElement(By.linkText("Next")).click();
					Thread.sleep(10000);
					
					
				}
				catch(Exception ex)
				{
					break; //terminate from the loop. 
				}
				
				
			}
		
		
				
				
				
				
			

	}

}
