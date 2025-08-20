package amazon_EtoE.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilityclasses.ITestListenerMainLogic.class)
public class TC_14_CartPageWithoutLogin extends BaseClass
{

	@Test(retryAnalyzer = utilityclasses.IRetryAnalyzerMainLogic.class)
	
	public void validateCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**** TC 14 Starterd ****");
		
		HomePage hmpg = new HomePage(driver);
		hmpg.search_product();
		
		SearchProductPage srchpg = new SearchProductPage(driver);
		srchpg.clickAddToCardButton();
		logger.info("Clicked on Add to Cart Button.");
		srchpg.clickOnGoToCart();
		logger.info("Clicked on Go to Cart Button.");
		
		logger.info("**** TC 14 Completed ****");
	}
	
}
