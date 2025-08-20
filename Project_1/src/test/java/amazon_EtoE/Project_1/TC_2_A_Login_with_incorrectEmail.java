package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_2_A_Login_with_incorrectEmail extends BaseClass
{
	
	
	@Test (retryAnalyzer=utilityclasses.IRetryAnalyzerMainLogic.class, enabled=true)
	public void invalid_email() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 2A Starterd ****");
		
		HomePage hmpg = new HomePage(driver);
		hmpg.Hovarover_accountandlists(driver);
		hmpg.click_signin();
		
		SignInPage siginpg = new SignInPage(driver);
		siginpg.enter_username2(driver);
		siginpg.click_continue2();
		logger.info("Entered an Incorrect Email Address.");
//		siginpg.enter_Password1(driver);
//		siginpg.click_signin();
		
		logger.info("**** TC 2A Completed ****");
	}
	
}
