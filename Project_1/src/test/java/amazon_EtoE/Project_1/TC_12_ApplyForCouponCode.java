package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_12_ApplyForCouponCode extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void validateCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 12 Starterd ****");
		
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
		srchpg.clickAddToCardButton();
		logger.info("Clicked on Add to Cart Button");
		srchpg.clickAddCart();
		logger.info("Clicked on Add Cart option - That navigate to Shopping Cart Page");
		
		ShoppingCartPage shpcrdpg = new ShoppingCartPage(driver);
		shpcrdpg.clickProceedToBuy();
		logger.info("Clicked on Proceed to Buy Button.");
		
		CheckoutPage chkoutpg = new CheckoutPage(driver);
		chkoutpg.enterCouponCode();
		logger.info("Entered incorrect Coupun Code.");
		chkoutpg.clickOnApplyButton();
		logger.info("After that Clicked on Apply Button.");
		chkoutpg.incorrectCodeValidation();
		logger.info("Validation Message Checked.");
		
		logger.info("**** TC 12 Completed ****");
	}
	
}
