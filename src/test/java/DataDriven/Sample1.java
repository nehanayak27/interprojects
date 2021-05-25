package DataDriven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Sample1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//create a new excel file (.xls)
		
		
		HSSFWorkbook wb=new HSSFWorkbook();
		Sheet sh=wb.createSheet("MySheet");
		Row r=sh.createRow(0); // first row
		Cell c=r.createCell(0); // first column 
		
		c.setCellValue("Neha nayak yfyj"); // auto fit on first column 
		sh.autoSizeColumn(0);
		//save in hard disk drive
		File f=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\target\\dummy.XLS");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		
		
		
		
		
		
	}

}
