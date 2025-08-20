package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerReviewsPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (linkText = "Write a review") WebElement wrtRvw;
	
	public void clickOnWriteAReview()
	{
		wait.until(ExpectedConditions.visibilityOf(wrtRvw));
		wrtRvw.click();
	}
	
	
	public CustomerReviewsPage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
}
