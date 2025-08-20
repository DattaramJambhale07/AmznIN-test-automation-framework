package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CreateReviewPage 
{
	WebDriver driver;
	WebDriverWait wait;
	@FindBy (xpath = "(//span[@tabindex='0'])[5]") WebElement fifthStr;
	@FindBy (xpath = "(//input[@type='submit'])[2]") WebElement subBtn;
	
	public void clickOnFifthStar()
	{
		wait.until(ExpectedConditions.visibilityOf(fifthStr));
		fifthStr.click();
		Reporter.log("• The Five Star Rating has been given to the Last Ordered Product.");
	}
	public void clickOnReviewSubmitButton()
	{
		wait.until(ExpectedConditions.visibilityOf(subBtn));
		subBtn.click();
	}
	
	
	public CreateReviewPage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
}
