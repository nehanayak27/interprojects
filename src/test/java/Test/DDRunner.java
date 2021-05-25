package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Classes.Resuable;

public class DDRunner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("E:\\book.XLSX");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		for(int i=1;i<nour;i++)
		{
			DataFormatter df=new DataFormatter();
		String env=	df.formatCellValue(sh.getRow(i).getCell(0));
		String u= df.formatCellValue(sh.getRow(i).getCell(1));
		String bn=	 df.formatCellValue(sh.getRow(i).getCell(2));
		String v= df.formatCellValue(sh.getRow(i).getCell(3));
		String os=	df.formatCellValue(sh.getRow(i).getCell(4));
		String uid=	df.formatCellValue(sh.getRow(i).getCell(5));
		String uidc=	df.formatCellValue(sh.getRow(i).getCell(6));
		String pwd=	df.formatCellValue(sh.getRow(i).getCell(7));
		String pwdc=	df.formatCellValue(sh.getRow(i).getCell(8));
		
		//create objct to reusable class.
		Resuable obkk;
		if(env.equalsIgnoreCase("local"))
		{
			obkk = new Resuable(bn);
			
		}
		else
		{
			obkk = new Resuable(bn,v,os);
		}
		obkk.launchsite(u);
		obkk.fillandvalidationlogin1(uid, uidc, pwd, pwdc);
			
		obkk.close();
			
			
		}
		
		
		
	}

}
