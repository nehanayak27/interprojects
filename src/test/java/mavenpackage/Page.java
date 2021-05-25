package mavenpackage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//take a word from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		sc.close();
		//launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		
		Thread.sleep(1000);
		//pagination
		int nor=0;
		int pn=1;
		while(2>1)
		{
			
			try {
				List<WebElement> listofrows=driver.findElements(By.className("g"));
				nor=nor+listofrows.size();
				if(pn==1)
				{
					System.out.println(pn+"st page contains of"+listofrows.size());
				}
				else if(pn==2)
				{
					System.out.println(pn+"nd page contains of"+listofrows.size());
				}
				
				else if(pn==3)
				{
					System.out.println(pn+"rd page contains of"+listofrows.size());
				}
				else if(pn==4)
				{
					System.out.println(pn+"th page contains of"+listofrows.size());
				}
				else
				{
					System.out.println(pn+"th page contains of"+listofrows.size());
				}
				pn++;
				driver.findElement(By.linkText("Next")).click();
				Thread.sleep(20000);
				
			}
			catch(Exception ex)
			{
				break;
				//terminate from the loop. 
			}
		}
			System.out.println("total count of results is "+nor);
			//close site
			driver.close();
			
		}
	}


