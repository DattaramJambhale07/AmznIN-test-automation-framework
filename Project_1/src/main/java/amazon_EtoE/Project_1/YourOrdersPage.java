package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourOrdersPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (linkText = "Buy Again") WebElement buyAgn;
	@FindBy (id = "title-B078V9X189-grid") WebElement frstprdct;
	@FindBy (xpath = "//div[@id='detailContent-B078V9X189']//a[contains(@class, 'linkReview')]") WebElement strIcns;
	
	public void clickBuyAgain()
	{
		wait.until(ExpectedConditions.visibilityOf(buyAgn));
		buyAgn.click();
	}
	public void clickLatestBoughtProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(frstprdct));
		frstprdct.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strIcns);
	}
	public void clickLatestBoughtProductStarIcons()
	{
		
		 wait.until(ExpectedConditions.visibilityOf(strIcns));
		 wait.until(ExpectedConditions.elementToBeClickable(strIcns));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", strIcns);
		    
	     // Optional pause if overlays are common
	     try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

	     // Optionally, replace the below with JS click if issue persists
	     strIcns.click();
	}
	
	
	public YourOrdersPage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
}
