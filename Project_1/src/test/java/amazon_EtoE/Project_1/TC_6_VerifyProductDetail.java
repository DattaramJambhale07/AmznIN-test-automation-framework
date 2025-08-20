package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_6_VerifyProductDetail extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void verifyNcssryProductinfo() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 6 Starterd ****");
		
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
		srchpg.click_on_product();
		logger.info("Clicked on the Search Product.");
		
		
		ProductDetailedPage pdpg = new ProductDetailedPage(driver);
		pdpg.verifyProductTitle();
		pdpg.verifyPriceInfo();
		pdpg.verifyReviewsInfo();
		pdpg.verifyProductDesc();
		logger.info("Checked all necessary information, including the product title, price, reviews and description.");
		
		logger.info("**** TC 6 Completed ****");
	}
	

}