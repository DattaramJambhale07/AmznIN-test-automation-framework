package amazon_EtoE.Project_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilityclasses.ITestListenerMainLogic;

public class BaseClass {
	
	public Logger logger = LogManager.getLogger(this.getClass());
	public Properties p;
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void browserlaunch(String browsername) throws IOException
	{
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		Properties p = new Properties();  
		p.load(file);
		
		if (browsername.equals("chrome"))
		{
			driver =  new ChromeDriver();
		}
		
		if(browsername.equals("edge"))
		{
			
			driver = new EdgeDriver();
		}
		
		if(browsername.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		ITestListenerMainLogic.setDriver(driver);
			
	}
	
	@AfterMethod
	public void browserquit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
