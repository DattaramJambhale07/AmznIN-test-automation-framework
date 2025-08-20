package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_2_B_Login_with_incorrectPwd extends BaseClass
{
	
	
	@Test (retryAnalyzer=utilityclasses.IRetryAnalyzerMainLogic.class, enabled=true)
	public void invalid_password() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 2B Starterd ****");
		
		HomePage hmpg = new HomePage(driver);
		hmpg.Hovarover_accountandlists(driver);
		hmpg.click_signin();
		
		SignInPage siginpg = new SignInPage(driver);
		siginpg.enter_username1(driver);
		siginpg.click_continue1();
		logger.info("Entered the correct Email ID.");
		siginpg.enter_Password2(driver);
		siginpg.click_signin();
		logger.info("Entered an Incorrect Password.");
		
		logger.info("**** TC 2B Completed ****");
	}

}
