package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_4_SearchProduct extends BaseClass

{
	
	@Test (retryAnalyzer=utilityclasses.IRetryAnalyzerMainLogic.class)
	public void searchproduct() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 4 Starterd ****");
		
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
		
		hmpg.search_product();
		logger.info("Searched for a product.");
		
		SearchProductPage srchpg = new SearchProductPage(driver);
		srchpg.search_product_name();
		logger.info("The product search was successful.");
		
		
		logger.info("**** TC 4 Completed ****");
	}
	
}
