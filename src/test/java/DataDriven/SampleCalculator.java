package DataDriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleCalculator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File f=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\target");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("My Sheet");
		sh.createRow(0).createCell(1).setCellValue("Result");
		Double  expected =sh.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(expected);
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.calculator.net/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='sin'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='4'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='5'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='='])[1]")).click();
		String op=driver.findElement(By.id("sciOutPut")).getText();
		op=op.trim();
		System.out.println(op);
		
		driver.close();
		
		
		
	}

}
