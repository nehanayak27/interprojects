package Dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Mailexamples.CreateMails;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownByDiv {

	@Test
	public void drop() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		WebElement dd=dr.findElement(By.xpath("//h4[text()='Selection']/following-sibling::div[2]"));
		
		//test case 1: check single select or multi select. 
		
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("its a multi select dropdown");
		}
		else
		{
			System.out.println("its a single select dropdown");
			//start testing
			//test case 2: collect all the items in that single select drop down and display
			List<WebElement> collect=dd.findElements(By.xpath("child::div[2]/div"));
			System.out.println("count of the items in the drop down list"+collect.size());
			System.out.println("items are:");
			for(WebElement item:collect)
			{
				//get hidden item text using javascript. 
				String x=(String) dr.executeScript("return(arguments[0].textContent);", item);
				System.out.println(x);
				
			}
			//Test case 3: select each item and test that selection. 
			for(WebElement item:collect )
			{
				try
				{
					//1.open dropdown to get visiblity of items. 
					dd.click();
					//2.select the item 
					item.click();
					Thread.sleep(5000);
					//get selected item text 
					if(item.isDisplayed())
					{
						//3. remmember text of the item to be selected. 
						String expected=item.getText();
						//4. select that item. 
						item.click();
						//5. get text of that item
						String actual = dd.findElement(By.xpath("child:div[1]")).getText();
						//6. compare 
						if(expected.equals(actual))
						{
							System.out.println("item selection text pass"+expected);
							
						}
						else
						{
							System.out.println("item selection text failed"+expected);
						}
						
					}
					else
					{
						
						String y=(String) dr.executeScript("return(arguments[0].textContent);", item);
						System.out.println(y+"item is hidden");
						
					}
					
					
					
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			
		}
		
		
		
		
		
	}
	
	public void divdrop(ChromeDriver dr)
	{
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement outter=dr.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[5]/div/div[2]/div"));
		List<WebElement>data=outter.findElements(By.xpath("child::div/div[2]/div"));
		Select s=new Select(outter);	
		ArrayList<String> l1=new ArrayList<String>();
		ArrayList<String> l2=new ArrayList<String>();
		
		for(WebElement item:data)
		{
			l1.add(item.getText());
			l2.add(item.getText());
		}
		
		Collections.sort(l2);
		
		if(l1.equals(l2))
		{
			System.out.println("the list isnt sorted");
		}
		else
		{
			System.out.println("the list is sorted");
		}
		
	}

}
