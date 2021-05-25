package Test;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTest {
	public void n() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,100);
		
		
		driver.get("http://125.18.224.122/ERP10Demo-EWA");
		driver.findElementByXPath("//input[@id='txtUserID']").sendKeys("manager");
		driver.findElementByXPath("//input[@id='txtPassword']").sendKeys("manager");
		driver.findElementByXPath("//button[@id='btnLogin']").click();
		Thread.sleep(20000);
		WebElement e=driver.findElement(By.xpath("//div//iFrame[@id='menu']"));
		driver.switchTo().frame(e);
		Screen sc=new Screen();
	driver.findElement(By.xpath("(//a[text()='Epicor Education'])")).click();
		Thread.sleep(1000);
		//sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\main.PNG");
		driver.findElement(By.xpath("(//a[text()='Main'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Financial Management'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='General Ledger']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Setup'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[text()='General Ledger Account'])")).click();
		String win=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		driver.switchTo().window(childId);
	System.out.println(	driver.getTitle());
		Thread.sleep(10000);
	
	FileInputStream fi=new FileInputStream("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\autotest.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh=wb.getSheet("Sheet1");
	int nour=sh.getPhysicalNumberOfRows();
	System.out.println(nour);
	for(int i=1;i<nour;i++)
	{
		DataFormatter df=new DataFormatter();
		String ano=df.formatCellValue(sh.getRow(i).getCell(0));
		String des=df.formatCellValue(sh.getRow(i).getCell(1));
		System.out.println(ano);
		System.out.println(des);
		//driver.findElement(By.id("glaeGLAccount_dropText")).clear();
		sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\clickdrop.PNG");
		//driver.findElement(By.id("_dropArrow")).click();
		String[] spl=ano.split("-");
		for(int ia=0;ia<spl.length;ia++)
		{
			System.out.println(spl[ia]);
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.xpath("//*[@_idx='0']/td[2]/div")).sendKeys(spl[0]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@_idx='1']/td[2]/div")).sendKeys(spl[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@_idx='2']/td[2]/div")).sendKeys(spl[2]);
		
	
	
	
	//sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\ok.PNG");
	
	
	}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,100);
		
		
		driver.get("http://125.18.224.122/ERP10Demo-EWA");
		driver.findElementByXPath("//input[@id='txtUserID']").sendKeys("manager");
		driver.findElementByXPath("//input[@id='txtPassword']").sendKeys("manager");
		driver.findElementByXPath("//button[@id='btnLogin']").click();
		Thread.sleep(20000);
		WebElement e=driver.findElement(By.xpath("//div//iFrame[@id='menu']"));
		driver.switchTo().frame(e);
		Screen sc=new Screen();
	driver.findElement(By.xpath("(//a[text()='Epicor Education'])")).click();
		Thread.sleep(1000);
		//sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\main.PNG");
		driver.findElement(By.xpath("(//a[text()='Main'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Financial Management'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='General Ledger']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Setup'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[text()='General Ledger Account'])")).click();
		String win=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		driver.switchTo().window(childId);
	System.out.println(	driver.getTitle());
		Thread.sleep(10000);
	
	FileInputStream fi=new FileInputStream("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\autotest.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh=wb.getSheet("Sheet1");
	int nour=sh.getPhysicalNumberOfRows();
	System.out.println(nour);
	for(int i=1;i<nour;i++)
	{
		DataFormatter df=new DataFormatter();
		String ano=df.formatCellValue(sh.getRow(i).getCell(0));
		String des=df.formatCellValue(sh.getRow(i).getCell(1));
		System.out.println(ano);
		System.out.println(des);
		//driver.findElement(By.id("glaeGLAccount_dropText")).clear();
		//sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\clickdrop.PNG");
		//driver.findElement(By.id("_dropArrow")).click();
		String[] spl=ano.split("-");
		String p="";
		p=p.join("",spl);
		System.out.println(p);
		driver.findElement(By.id("glaeGLAccount_dropText")).sendKeys("12381020");
		Thread.sleep(1000);
		

	}
	
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//button[@class='tool-btn tool-Save']")).click();
	sc.click("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\src\\test\\resources\\savebut.PNG");
	Thread.sleep(1000);
	driver.findElement(By.id("btnKeyField")).click();
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNaturalAccount"))).sendKeys("1238");  
	
	Thread.sleep(1000);
	
	//search the record
	driver.findElement(By.id("btnSearch")).click();
	driver.findElement(By.xpath("//tbody//tr[@_idx='2']")).click();
	driver.findElement(By.id("")).click();
		
	

	}

}
