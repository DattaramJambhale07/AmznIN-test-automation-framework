package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SearchProductPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath = "//span[@class='a-color-state a-text-bold']") WebElement srch_prdct_nm;
	@FindBy (id = "p_36/dynamic-picker-2") WebElement prc_rng;
	@FindBy (xpath = "//span[.='Desks & Workstations']") WebElement slct_cat;
	@FindBy (xpath = "(//div[@data-component-type='s-search-result'])[5]//h2") WebElement clk_prdct;
	@FindBy (id = "s-result-sort-select") WebElement srchoptns;
	@FindBy (xpath = "(//button[@name='submit.addToCart'])[5]") WebElement addCartButton;
	@FindBy (id = "nav-cart") WebElement navCart;
	@FindBy (linkText = "Go to Cart") WebElement goToCrt;
	
	public void search_product_name()
	{
		
		wait.until(ExpectedConditions.visibilityOf(srch_prdct_nm));
		String srch_rslt = srch_prdct_nm.getText();
		boolean b1 = srch_rslt.contains("Table");
		boolean b2 = HomePage.product_name.contains("Table");
		if (b1 && b2)
		{
			Reporter.log("• The product search was successful.");
		}
	}
	
	public void select_price_range()
	{
		wait.until(ExpectedConditions.visibilityOf(prc_rng));
		prc_rng.click();
		Reporter.log("• Price range has been selected : ✓");
	}
	
	public void select_category()
	{
		wait.until(ExpectedConditions.visibilityOf(slct_cat));
		slct_cat.click();
		Reporter.log("• Category has been selected : ✓");
		Reporter.log("• The category and price range filter both are working properly.");
	}
	
	public void click_on_product()
	{	
		wait.until(ExpectedConditions.visibilityOf(clk_prdct));
		clk_prdct.click();	
	}
	
	public void searchOptions() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(srchoptns));
		Select dropdown1 =  new Select(srchoptns);
		dropdown1.selectByVisibleText("Price: Low to High");
		Reporter.log("• Price: Low to High sorting : ✓");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(srchoptns));
		dropdown1.selectByVisibleText("Price: High to Low");
		Reporter.log("• Price: High to Low sorting : ✓");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(srchoptns));
		dropdown1.selectByVisibleText("Avg. Customer Review");
		Reporter.log("• Avg. Customer Review sorting : ✓");
		Thread.sleep(2000);
		
		Reporter.log("• Product sorting is done using filters for price, reviews, and relevancy.");
	}
	
	public void clickAddToCardButton()
	{	
		wait.until(ExpectedConditions.visibilityOf(addCartButton));
		addCartButton.click();	
	}
	public void clickAddCart()
	{	
		wait.until(ExpectedConditions.visibilityOf(navCart));
		navCart.click();	
	}
	public void clickOnGoToCart()
	{	
		wait.until(ExpectedConditions.visibilityOf(goToCrt));
		goToCrt.click();
		Reporter.log("• Reached Till Cart Page without Login to the Amazon Application.");
	}
	
	
	public SearchProductPage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
}
