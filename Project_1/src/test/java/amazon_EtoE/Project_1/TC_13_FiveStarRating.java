package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_13_FiveStarRating extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void validateCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 13 Starterd ****");
		
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
		
		hmpg.clickOrders();
		logger.info("Clicked on Orders that navigate to the 'Your Orders' details page.");
		
		YourOrdersPage orderpg = new YourOrdersPage(driver);
		orderpg.clickBuyAgain();
		logger.info("Clicked on Buy Again option.");
		orderpg.clickLatestBoughtProduct();
		logger.info("Clicked on Latest Bought Product.");
		orderpg.clickLatestBoughtProductStarIcons();
		logger.info("Clicked on Star Icons.");
		
		CustomerReviewsPage custrvwpg = new CustomerReviewsPage(driver);
		custrvwpg.clickOnWriteAReview();
		logger.info("Clicked on Write a Review.");
		
		CreateReviewPage creRvwpg = new CreateReviewPage(driver);
		creRvwpg.clickOnFifthStar();
		logger.info("Clicked on the 5th Star.");
//		creRvwpg.clickOnReviewSubmitButton();		
//		logger.info("Saved the Review but Clicking on the Submit Button.");
		
		logger.info("**** TC 13 Completed ****");
	}
	
}
