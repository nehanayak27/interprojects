package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f1=new File("E:\\Batch251Selenium\\Selenium1\\seleniumPrac\\project");
		File[] l=f1.listFiles();
		
		//create a new excel file.
		XSSFWorkbook wwb=new XSSFWorkbook();
		Sheet sh=wwb.createSheet("documents");
		sh.createRow(0).createCell(0).setCellValue("name");
		sh.getRow(0).createCell(1).setCellValue("file/folder");
		sh.getRow(0).createCell(2).setCellValue("file size");
		sh.getRow(0).createCell(3).setCellValue("last modified");
		sh.getRow(0).createCell(4).setCellValue("hidden");
		
		int rownum=1;
		for(File f:l)
		{
		
			sh.createRow(rownum).createCell(0).setCellValue(f.getName());
			sh.autoSizeColumn(0);
			
			if(f.isFile())
			{
			sh.getRow(rownum).createCell(1).setCellValue("file");
			sh.autoSizeColumn(1);
			double b=f.length();
			double k=(b/1024);
			sh.getRow(rownum).createCell(2).setCellValue(k+"KB");
			sh.autoSizeColumn(2);
			}
			else
			{
				sh.getRow(rownum).createCell(1).setCellValue("folder");
				long b=FileUtils.sizeOfDirectory(f);
				double k=(b/1024);
				sh.getRow(rownum).createCell(2).setCellValue(k+"KB");
				sh.autoSizeColumn(2);
			}
			
			SimpleDateFormat sdf=new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss");
			sh.getRow(rownum).createCell(3).setCellValue(sdf.format(f.lastModified()));
			sh.autoSizeColumn(3);
			
			//hidden or not
			if(f.isHidden())
			{
				sh.getRow(rownum).createCell(4).setCellValue("yes");
			}
			else
			{
				sh.getRow(rownum).createCell(4).setCellValue("NO");
			}
			rownum=rownum+1;
			
			
		}
		
		
		//write permission for the file. 
		File f2=new File("E:\\\\Batch251Selenium\\\\Selenium1\\\\seleniumPrac\\\\project\\resultbook.XLSX");
		FileOutputStream fo=new FileOutputStream(f2);
		wwb.write(fo);
		wwb.close();
		fo.close();
		
		
		
		
		 
		

	}

}
