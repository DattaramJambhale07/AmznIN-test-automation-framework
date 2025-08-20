package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_11_PaymentMethodSelection extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void validateCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 11 Starterd ****");
		
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
		logger.info("Clicked on Add to Cart Button.");
		srchpg.clickAddCart();
		logger.info("Clicked on Add Cart option - That navigate to Shopping Cart Page");
		
		ShoppingCartPage shpcrdpg = new ShoppingCartPage(driver);
		shpcrdpg.clickProceedToBuy();
		logger.info("Clicked on Proceed to Buy Button.");
		
		CheckoutPage chkoutpg = new CheckoutPage(driver);
		chkoutpg.clickCreditAndDebitCard();
		logger.info("Credit and Debit Card Payment Options: ✓");
		chkoutpg.clickAmazonPayBalance();
		logger.info("Amazon Pay Option: ✓");
		chkoutpg.clickUPI();
		logger.info("UPI Payment Option: ✓");
		chkoutpg.clickAnthrPaymentMthdCredDeb();
		logger.info("Another Payment Method: Credit or Debit Card Option: ✓");
		chkoutpg.clickAnthrPaymentMthdNetBanking();
		logger.info("Another payment method: Net Banking is availble: ✓");
		chkoutpg.clickAnthrPaymentMthdOtherUPIApps();
		logger.info("Another payment method: Other UPI Apps is availble: ✓");
//		chkoutpg.clickAnthrPaymentMthdEMI();
		chkoutpg.clickAnthrPaymentMthdCODPOD();
		logger.info("Another payment method: COD / POD: ✓ ");
		
		logger.info("**** TC 11 Completed ****");
	}
	
}
