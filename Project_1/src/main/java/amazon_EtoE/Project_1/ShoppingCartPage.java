package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ShoppingCartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath = "(//div[@role='listitem'])[1]") WebElement frstprdct;
	@FindBy (xpath = "(//div[@role='listitem'])[1]//span[@class='a-icon a-icon-small-add']") WebElement addqty;
	@FindBy (xpath = "(//div[@role='listitem'])[1]//span[@class='a-icon a-icon-small-remove']") WebElement remvqty;
	@FindBy (xpath = "(//div[@role='listitem'])[1]//input[@data-action='delete-active']") WebElement trashBtn;
	@FindBy (name = "proceedToRetailCheckout") WebElement prcdToBuy;
	
	public void frstprdctvsblty()
	{
		wait.until(ExpectedConditions.visibilityOf(frstprdct));
		Assert.assertTrue(frstprdct.isDisplayed(), "The product was not added to the cart.");
		Reporter.log("• The product was added to the cart.");
	}
	
	public void addProducts() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(addqty));
		addqty.click();
	}
	public void removeProduct() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(remvqty));
		remvqty.click();
		Thread.sleep(2000);
	}
	public void deleteAllQty() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(trashBtn));
		trashBtn.click();
		Reporter.log("• The Product Qty has been Updated.");
		Thread.sleep(2000);
	}
	public void clickProceedToBuy()
	{
		wait.until(ExpectedConditions.elementToBeClickable(prcdToBuy));
		prcdToBuy.click();
	}
	
	
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
