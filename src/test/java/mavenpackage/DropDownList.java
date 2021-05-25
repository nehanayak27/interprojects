package mavenpackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//scroll to the neighbor element to get target into visible area of desktop. 
		WebElement neighbor=driver.findElement(By.xpath("//h4[text()='Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();", neighbor);
		Thread.sleep(10000);
		//locate a dropdown develop using <div> tag 
		WebElement dd=driver.findElement(By.xpath("//h4[text()='Selection']/following-sibling::div[2]"));
		
		
		
		//test case 1: check if its single or multiselect. 
		
		if(dd.getAttribute("class").contains("multiple"))
		{
	System.out.println("multiple select");
		}
		else
		{
			System.out.println("Single select dropdown");
			List<WebElement> items=driver.findElements(By.xpath("child::div[2]/div"));
			System.out.println("list of results under single dropdwon"+items.size()); //number of the iteams
			//listing the iteams
			System.out.println("iteams are");
			for(WebElement item:items)
			{
				String x=(String) driver.executeScript("return(arguments[0].textcontent);", item);
				System.out.println(x);
				
			}
			
			//test case 3: SELECT each item and test the selection 
			for (WebElement item:items)
			{
				try {
					dd.click();
					Thread.sleep(20000);
					//check for visiblity
					if(item.isDisplayed())
					{
						//remember the text of the item selected
						String expected=item.getText();
						//select the item
						item.clear();
						Thread.sleep(2000);
						//5.get selected item text. 
						String actuall=dd.findElement(By.xpath("child::div[1]")).getText();
						// 6. compare both actual and expected result. 
						if(expected.equals(actuall))
						{
							System.out.println(expected+"item selection test passed");
						}
						else
						{
							System.out.println(expected+"item selection test failed");
						}
						
					}
					else
					{
						String y=(String) driver.executeScript("return(arguments[0].textcontent);", item);
						System.out.println(y+"item is hidden");
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}//loop ending 
			
		}//else ending
		
		driver.close();
	}

}
