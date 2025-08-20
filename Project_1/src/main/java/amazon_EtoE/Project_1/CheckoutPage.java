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

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (id = "deliver-to-address-text") WebElement checkoutaddrs;
	@FindBy (xpath = "//div[@class='a-column a-span8 a-spacing-base']/h2[normalize-space(text())='Payment method']") WebElement h2PaymentMethod;
	@FindBy (id = "checkout-subtotals-section") WebElement orderReview;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[2]") WebElement cardsRadio;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[1]") WebElement amazPayRadio;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[3]") WebElement upiRadio;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[4]") WebElement anthrPayMthdCredDeb;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[5]") WebElement anthrPayMthdNetBank;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[6]") WebElement anthrPayMthdOthrUPI;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[7]") WebElement anthrPayMthdEMI;
	@FindBy (xpath = "(//input[@name='ppw-instrumentRowSelection'])[8]") WebElement anthrPayMthdCOD;
	@FindBy (xpath = "//input[@placeholder='Enter Code']") WebElement CpnCde;
	@FindBy (xpath = "//input[@name='ppw-claimCodeApplyPressed']") WebElement appltBtn;
	@FindBy (xpath = "//div[@id='pmts-claim-code-error-messages']") WebElement errmsg;
	
	public void verifyCheckoutAdd()
	{
		wait.until(ExpectedConditions.visibilityOf(checkoutaddrs));
		Assert.assertEquals(checkoutaddrs.isDisplayed(), true);
	}
	public void verifyPaymentMethod()
	{
		wait.until(ExpectedConditions.visibilityOf(h2PaymentMethod));
		Assert.assertEquals(h2PaymentMethod.isDisplayed(), true);
	}
	public void verifyOrderReview()
	{
		wait.until(ExpectedConditions.visibilityOf(orderReview));
		Assert.assertEquals(orderReview.isDisplayed(), true);
		Reporter.log("• The order review section has been displayed.");
	}
	
	public void clickCreditAndDebitCard() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(cardsRadio));
		cardsRadio.click();
		Assert.assertEquals(cardsRadio.isDisplayed(), true);
	}
	public void clickAmazonPayBalance() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(amazPayRadio));
		amazPayRadio.click();
		Assert.assertEquals(amazPayRadio.isDisplayed(), true);
	}
	public void clickUPI() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(upiRadio));
		upiRadio.click();
		Assert.assertEquals(upiRadio.isDisplayed(), true);
	}
	public void clickAnthrPaymentMthdCredDeb() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(anthrPayMthdCredDeb));
		anthrPayMthdCredDeb.click();
		Assert.assertEquals(anthrPayMthdCredDeb.isDisplayed(), true);
	}
	public void clickAnthrPaymentMthdNetBanking() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(anthrPayMthdNetBank));
		anthrPayMthdNetBank.click();
		Assert.assertEquals(anthrPayMthdNetBank.isDisplayed(), true);
	}
	public void clickAnthrPaymentMthdOtherUPIApps() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(anthrPayMthdOthrUPI));
		anthrPayMthdOthrUPI.click();
		Assert.assertEquals(anthrPayMthdOthrUPI.isDisplayed(), true);
	}
//	public void clickAnthrPaymentMthdEMI() throws InterruptedException
//	{
//		wait.until(ExpectedConditions.visibilityOf(anthrPayMthdEMI));
//		anthrPayMthdEMI.click();
//		Assert.assertEquals(anthrPayMthdEMI.isDisplayed(), true);
//		Reporter.log("The 'Another payment method: EMI' is availble");
//	}
	public void clickAnthrPaymentMthdCODPOD() throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(anthrPayMthdCOD));
		anthrPayMthdCOD.click();
		Assert.assertEquals(anthrPayMthdCOD.isDisplayed(), true);
		Reporter.log("• The user is able to select each payment method one at a time.");
	}
	public void enterCouponCode()
	{
		wait.until(ExpectedConditions.visibilityOf(CpnCde));
		CpnCde.sendKeys("CoBo80");
	}
	public void clickOnApplyButton()
	{
		wait.until(ExpectedConditions.visibilityOf(appltBtn));
		appltBtn.click();
	}
	public void incorrectCodeValidation()
	{
		wait.until(ExpectedConditions.visibilityOf(errmsg));
		Assert.assertEquals(errmsg.isDisplayed(), true);
		Reporter.log("• The user is able to apply for a coupon code. Also an incorrect The coupon code has been entered.");
	}
	
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
