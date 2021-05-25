package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Sample3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//open an exsisting file.
		File f=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project\\target\\sample1.XLSX");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		//create output column 
		sh.getRow(0).createCell(2).setCellValue("output");
		
		for(int i=1;i<nour;i++)
		{
			int x=(int) sh.getRow(i).getCell(0).getNumericCellValue();
			int y= (int) sh.getRow(i).getCell(1).getNumericCellValue();
			int z=x+y;
			sh.getRow(i).createCell(2).setCellValue(z);
		}
		
		sh.autoSizeColumn(2);
		sh.createFreezePane(0, 1);
		
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		
		
		

	}

}
