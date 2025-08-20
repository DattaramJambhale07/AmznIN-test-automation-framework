package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_9_UpdateProductsQty extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void productQTYUpdate() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 9 Starterd ****");
		
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
		shpcrdpg.frstprdctvsblty();
		logger.info("The product was added to the cart.");
		shpcrdpg.removeProduct();
		logger.info("Clicked on '-' sign to Remove Qty.");
		shpcrdpg.addProducts();
		logger.info("Clicked on '+' sign to Add Qty.");
		shpcrdpg.deleteAllQty();
		logger.info("Clicked on Delete to delete All Qty.");
		
		logger.info("**** TC 9 Completed ****");
	}
	
}
