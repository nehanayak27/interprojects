import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Carousel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver dr=new ChromeDriver();
		
		dr.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		
		dr.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement cslider=dr.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div/div[1]"));
		//Test case 1 - get count of visible slider 
		String x= cslider.getTagName();
		int count =0;
		List<WebElement> slides;
		if(x.equals("div"))
				{
					slides=cslider.findElements(By.xpath("child::div"));
					for(WebElement slide:slides)
					{
						try
						{
							if(slide.getAttribute("data-clone").equals("false"))
							{
								count=count+1;
							}
						}
						catch (Exception ex)
						{
							//dev didnot use data clone concept
							count=count+1;
						}
						
						
					}
					
					
					}
		else
		{
			//each slide is <li>
			slides=cslider.findElements(By.xpath("child::li"));
			count=slides.size();
			
		}
		
		System.out.println("count of all visible slides is"+count);
		
		//Test case 2: 2D or 3D Slider 
		String a=cslider.getCssValue("transform");
		if(a.equals("none"))
		{
			//take transform - style property value
			a=cslider.getCssValue("transform-style");
		}
		//verification 
		if(a.contains("3d"))
		{
			System.out.println("its a 3D slider");
		}
		else
		{
			System.out.println("its a 2D slider");
		}
		
		//Test case 3: wherether my test case are moving automaticly or no? 
		String b=cslider.getCssValue("transform");
		if(b.equals("none"))
		{
			System.out.println("not moving automaticly");
		}
		else
		{
			System.out.println(" moving automaticly");
			System.out.println(b);
			//Test case 4: direction of slider , left to right.. or right to left. 
			String c=b.substring(7, b.length()-1);
			String p[]=c.split(",");
			p[4]=p[4].trim(); // remove unwanted spaces from befre and after 
			p[5]=p[5].trim();
			float v=Float.parseFloat(p[4]); //2856.21
			float m=Float.parseFloat(p[5]); //0
			if(v<0 && m==0)
			{
				System.out.println("slides are moving from right to left");
			}
			else if(v>0 && m==0)
			{
				System.out.println("slides are moving from left to right");
			}
			else if(v==0 && m<0)
			{
				System.out.println("slides are moving from bottom to top");
			}
			else
			{
				System.out.println("slides are moving from top to bottom");
			}
			
			//Test case 5: duration of the slide
			String z=cslider.getCssValue("transition");
			System.out.println(z);
			String[] q= z.split(" "); //space 
			if(q[2].equals("ease-in"))
			{
				System.out.println("slow starts from each slide");
			}
			else if(q[2].equals("ease-out"))
			{
				System.out.println("slow end from each slide");
			}
			else
			{
				System.out.println("slow start and end of each slide");
			}
			//duration of each slide
			System.out.println("duration of each slide is" +q[1]);
			q[3]=q[3].replace(",", "");
			System.out.println("delay between slides"+q[3]);
			//Test case 6 - slide are rotating correctly or no
			String[] values=new String[count+1];
			for(int i=0;i<count+1;i++)
			{
				String b1=cslider.getCssValue("transform");
				String c1=b1.substring(7,b1.length()-1);
				String[] p1=c1.split(",");
				p1[4]=p[4].trim();
				p1[5]=p[5].trim();
				values[i]=p[4];
				System.out.println(values[i]);
				Thread.sleep(1000);
				
			}
			if(values[0].equals(values[count]))
			{
				System.out.println("sliders are rotating correctly");
			}
			else 
			{
				System.out.println("sliders are not working correctly");
			}
			
			
				
		}
		
		
	}
public void ebay(ChromeDriver dr)
			{
				dr.get("https://www.ebay.com/");
				
				WebElement cslider=dr.findElement(By.xpath("//div[@class='carousel__viewport']/ul"));
				//Test case 1 - get count of visible slider 
				String x= cslider.getTagName();
				int count =0;
				List<WebElement> slides;
				if(x.equals("div"))
						{
							slides=cslider.findElements(By.xpath("child::div"));
							for(WebElement slide:slides)
							{
								try
								{
									if(slide.getAttribute("data-clone").equals("false"))
									{
										count=count+1;
									}
								}
								catch (Exception ex)
								{
									//dev didnot use data clone concept
									count=count+1;
								}
								
								
							}
							
							
							}
				else
				{
					//each slide is <li>
					slides=cslider.findElements(By.xpath("child::li"));
					count=slides.size();
					
				}
				
				System.out.println("count of all visible slides is"+count);
				
				
			}


public void threedi(ChromeDriver dr)
{
	dr.get("https://3dtransforms.desandro.com/carousel");
	WebElement cslider=dr.findElement(By.className("carousel"));
	//Test case 2: 2D or 3D Slider 
			String a=cslider.getCssValue("transform");
			if(a.equals("none"))
			{
				//take transform - style property value
				a=cslider.getCssValue("transform-style");
			}
			//verification 
			if(a.contains("3d"))
			{
				System.out.println("its a 3D slider");
			}
			else
			{
				System.out.println("its a 2D slider");
			}
			System.out.println(a);
	
}
}
