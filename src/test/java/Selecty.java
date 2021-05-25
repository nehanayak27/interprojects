import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Dropdown.DropdownByDiv;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selecty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		DropdownByDiv ss=new DropdownByDiv();
		ss.divdrop(dr);
		
		/*
		dr.get("https://demoqa.com/select-menu");
		//locate the dropdown 
		WebElement sel=dr.findElement(By.id("oldSelectMenu"));
		Select s=new Select(sel);
		//get all the itemsand display
		List<WebElement> items=s.getOptions();
		for(WebElement item:items )
		{
			System.out.println(item.getText());
		}
		*/
		
		
		
	}
	public void sort(ChromeDriver dr)
	{
		
		dr.get("https://demoqa.com/select-menu");
		//locate the dropdown 
		WebElement sel=dr.findElement(By.id("oldSelectMenu"));
		Select s=new Select(sel);
		List<WebElement> data=s.getOptions();
		ArrayList<String> l1=new ArrayList<String>();
		ArrayList<String> l2=new ArrayList<String>();
		
		for(WebElement item:data)
		{
			l1.add(item.getText());
			l2.add(item.getText());
		}
	//sort 2nd array
		Collections.sort(l2);
		//compare l1 and l2 both arraylist
		
		if(l1.equals(l2))
		{
			System.out.println("the list isnt sorted");
		}
		else
		{
			System.out.println("the list is sorted");
		}
		ArrayList<String> l3=new ArrayList<String>();
		ArrayList<String> l4=new ArrayList<String>();
		//display items in l2 
		System.out.println("the sorted details:");
		for(int i=0;i<l2.size();i++)
			{
			
			System.out.println(l2.get(i));
			
			}
		
		
		
		
	}
	
	public void div(ChromeDriver dr)
	{
		dr.get("https://semantic-ui.com/modules/dropdown.html");
		WebElement sel=dr.findElement(By.xpath("//*[@id=\'example\']/div[4]/div/div[2]/div[4]/div[1]/div[5]/div"));

		
		List<WebElement>data=sel.findElements(By.xpath("child::div[2]/div"));
		Select s=new Select(sel);	
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
