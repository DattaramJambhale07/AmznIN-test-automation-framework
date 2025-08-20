package amazon_EtoE.Project_1;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utilityclasses.ExcelDataReader;

public class SignInPage extends ExcelDataReader
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (id = "ap_email_login") WebElement mobile_email;
	@FindBy (className = "a-button-input") WebElement cntine;
	@FindBy (id = "ap_password") WebElement pwd_click;
	@FindBy (id = "signInSubmit") WebElement sign_click_button;
	
	public void enter_username1(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOf(mobile_email));
		FetchingdatafromSheet();
		mobile_email.sendKeys(un1);
		Thread.sleep(1000);	
	}
	
	public void enter_username2(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOf(mobile_email));
		FetchingdatafromSheet();
		mobile_email.sendKeys(un2);
		Reporter.log("• Login fails for an incorrect email address.");
		
	}
	
	public void click_continue1()
	{
		cntine.click();
	}
	
	public void click_continue2()
	{
		cntine.click();
	
		WebElement errmsg_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='invalid-email-alert']")));
		String actual_email_error = errmsg_1.getText();
		Assert.assertEquals(actual_email_error, "Invalid email address.");
	}
	
	public void enter_Password1(WebDriver driver)throws EncryptedDocumentException, IOException, InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(pwd_click));
		FetchingdatafromSheet();
		pwd_click.sendKeys(pwd1);
		Thread.sleep(1000);
		Reporter.log("• The user has successfully logged into their Amazon account.");
	}
	public void enter_Password2(WebDriver driver)throws EncryptedDocumentException, IOException, InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(pwd_click));
		FetchingdatafromSheet();
		pwd_click.sendKeys(pwd2);
		Thread.sleep(1000);
		Reporter.log("• Login fails for an incorrect password.");
	}
	
	public void click_signin()
	{
		sign_click_button.click();
		
	}
	
	public SignInPage (WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
