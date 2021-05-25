import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadiBrokenLink {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.navigate().to("https://www.gmail.com");
		Thread.sleep(3000);
		List<WebElement> AllElements=driver.findElements(By.xpath("//*"));
		System.out.println("no. of all elements in gmail homepage:"+AllElements.size());
		int correctly_working_links=0;
		int broken_links=0;
		//List<WebElement> list1= new ArrayList<WebElement>();
		
		for(WebElement e:AllElements)
		{
			try {
			String link=e.getAttribute("href");
			if(link.startsWith("http")||link.startsWith("https"))
			{
				
				URL url=new URL(link);
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				connection.connect();
				Thread.sleep(5000);
				String response=connection.getResponseMessage();
				if(response.equalsIgnoreCase("OK"))
				{
					correctly_working_links++;
				}
				else
				{
					broken_links++;
				}
				connection.disconnect();
				
			}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			
		}
		
		//System.out.println("total number of hyperlinks:"+list1.size());
		System.out.println("correctly working links:"+correctly_working_links);
		System.out.println("broken links in this site:"+broken_links);
		driver.close();

	}

}
