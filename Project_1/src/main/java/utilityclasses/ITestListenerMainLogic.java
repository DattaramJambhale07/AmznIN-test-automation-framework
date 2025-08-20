package utilityclasses;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ITestListenerMainLogic implements ITestListener
{
	
	public static WebDriver driver;
	
	public static void setDriver(WebDriver drv) {
        driver = drv;
    }

	
	public void onTestSuccess(ITestResult result)
	{
	
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime());
//		Sun May 25 02:27:44 IST 2025
//		0123456789012345678901234567
		String s1 = d2.toString();
		String date= s1.substring(0, 10);
		String hour = s1.substring(11, 13);
		String min = s1.substring(14, 16);
		String sec = s1.substring(17, 19);
		
		
		ITestListener.super.onTestSuccess(result);	
		Reporter.log("TC Success");
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File ("C:\\Users\\Akshay Jambhale\\eclipse-workspace\\Project_1\\All_SS\\PassedTC\\"+date+"_"+hour+"_"+min+"_"+sec+".jpg");
		try 
		{
			FileHandler.copy(source, destination);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	
	public void onTCfailure(ITestResult result)
	{
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime());
//		Sun May 25 02:27:44 IST 2025
//		0123456789012345678901234567
		String s1 = d2.toString();
		String date= s1.substring(0, 10);
		String hour = s1.substring(11, 13);
		String min = s1.substring(14, 16);
		String sec = s1.substring(17, 19);
		
		ITestListener.super.onTestFailure(result);
		Reporter.log("TC Failed");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File distination = new File ("C:\\Users\\Akshay Jambhale\\eclipse-workspace\\Project_1\\All_SS\\FailedTC\\"+date+"_"+hour+"_"+min+"_"+sec+".jpg");
		try 
		{
			FileHandler.copy(source, distination);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	

}
