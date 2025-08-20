package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_3_Edit_Profile extends BaseClass
{
	
	
	@Test (retryAnalyzer=utilityclasses.IRetryAnalyzerMainLogic.class)
	public void editprofileinfo() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 3 Starterd ****");
		
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
		
		hmpg.Hovarover_accountandlists(driver);
		hmpg.click_manage_profile();
		logger.info("Clicked on Manage Profile.");
		hmpg.click_view();
		logger.info("Clicked on View button.");
		
		ProfilePage propg = new ProfilePage(driver);
		propg.click_age_group();
		logger.info("Clicked on the Age Group.");
		propg.click_add();
		logger.info("Clicked on the Add Button.");
		propg.select_my_age_group();
		logger.info("Age Group Selected.");
		propg.click_save_age_data();
		logger.info("Saved selected age data.");
		propg.verifyAgeGroup();
		logger.info("Profile data edited successfully.");
		
		logger.info("**** TC 3 Completed ****");
		
	}
}
