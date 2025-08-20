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

public class ProductDetailedPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath = "//span[@id='productTitle']") WebElement prodtitle;
	@FindBy (id = "delightPricingBadge_feature_div") WebElement pricingBadge;
	@FindBy (xpath = "//span[@id='acrCustomerReviewText']") WebElement reviews;
	@FindBy (id = "productDescription_feature_div") WebElement prodDesc;
	@FindBy (id = "add-to-cart-button") WebElement addtocard;
	@FindBy (xpath = "/html/body/div[10]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div[3]/div/span[2]/span/input") WebElement skpBtn;
	
	public void verifyProductTitle()
	{
		wait.until(ExpectedConditions.visibilityOf(prodtitle));
		Assert.assertEquals(prodtitle.isDisplayed(), true);
		Reporter.log("• Product Title: ✓");
	}
	
	public void verifyPriceInfo()
	{
		wait.until(ExpectedConditions.visibilityOf(pricingBadge));
		
		Assert.assertEquals(pricingBadge.isDisplayed(), true);
		Reporter.log("• Product Price: ✓");
	}
	
	public void verifyReviewsInfo()
	{
		wait.until(ExpectedConditions.visibilityOf(reviews));
		Assert.assertEquals(reviews.isDisplayed(), true);
		Reporter.log("• Product Reviews: ✓");
	}
	
	public void verifyProductDesc()
	{
		wait.until(ExpectedConditions.visibilityOf(prodDesc));
		Assert.assertEquals(prodDesc.isDisplayed(), true);
		Reporter.log("• Product Decreption: ✓");
		Reporter.log("• The product detail page displays all necessary information, including the product title, price, reviews and description.");
	}
	
	public void addProductToCart()
	{
		wait.until(ExpectedConditions.visibilityOf(addtocard));
		addtocard.click();
	}

	
	public ProductDetailedPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
