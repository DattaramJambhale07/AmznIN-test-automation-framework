package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_1_Login_with_correct_EmailPwd extends BaseClass{
	
	// Verify login is successful with correct email and password.
	
	@Test (retryAnalyzer=utilityclasses.IRetryAnalyzerMainLogic.class, enabled=true)
	public void validTC() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 1 Starterd ****");
		
		HomePage hmpg = new HomePage(driver);
		hmpg.Hovarover_accountandlists(driver);
		hmpg.click_signin();
		
		SignInPage siginpg = new SignInPage(driver);
		siginpg.enter_username1(driver);
		siginpg.click_continue1();
		logger.info("Entered the correct Email ID.");
		siginpg.enter_Password1(driver);
		siginpg.click_signin();
		logger.info("Entered the correct Password.");
		
		logger.info("**** TC 1 Completed ****");
		
	}
	
}
