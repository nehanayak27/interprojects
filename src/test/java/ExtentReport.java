import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	@Test
	public void runme() throws Exception
	{
		System.out.println("Login in amazon");
		ExtentHtmlReporter report=new ExtentHtmlReporter("E:\\learn.html");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(report);
		ExtentTest log=extent.createTest("login test");
		
		log.log(Status.INFO, "Login to amamzon");
		
		log.log(Status.PASS, "Title verified");
		 
		ExtentTest logh=extent.createTest("logoff test");
		logh.log(Status.FAIL, "failed  report");
		logh.addScreenCaptureFromPath("E:\\");
		extent.flush();
		
	}

}
