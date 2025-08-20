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

public class ProfilePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath = "//div[.='Age group']") WebElement age_grp;
	@FindBy (xpath = "//button[.='Add']") WebElement add_btn;
	@FindBy (xpath = "//button[.='25-29']") WebElement myagegrp;
	@FindBy (xpath = "(//button[.='Save'])[2]") WebElement savemyage;
	@FindBy (className = "attribute-value") WebElement checkage;
	
	public void click_age_group()
	{
		wait.until(ExpectedConditions.visibilityOf(age_grp));
		age_grp.click();
	}
	
	public void click_add()
	{
		wait.until(ExpectedConditions.visibilityOf(add_btn));
		add_btn.click();
	}
	
	public void select_my_age_group()
	{
		wait.until(ExpectedConditions.visibilityOf(myagegrp));
		myagegrp.click();
	}
	
	public void click_save_age_data()
	{
		wait.until(ExpectedConditions.visibilityOf(savemyage));
		savemyage.click();
	}
	
	public void verifyAgeGroup()
	{
		wait.until(ExpectedConditions.visibilityOf(checkage));
		Assert.assertEquals(checkage.isDisplayed(), true);
		Reporter.log("• The profile data has been edited successfully.");
	}
	
	
	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
