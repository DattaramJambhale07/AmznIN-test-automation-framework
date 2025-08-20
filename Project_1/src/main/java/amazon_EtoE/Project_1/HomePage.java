package amazon_EtoE.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage

{
	WebDriver driver;
	WebDriverWait wait;
	public static String product_name = "Table";
	
	@FindBy (xpath = "//div[@id='nav-link-accountList']") WebElement acntndLsts;
	@FindBy (xpath = "//span[.='Sign in']") WebElement signin;
	@FindBy (xpath = "//div[@class='sc-EgOXT iKaBpV']") WebElement mng_prfl;
	@FindBy (xpath = "//div[@class='sc-hmdomO qqYTW']") WebElement view_btn;
	@FindBy (id = "twotabsearchtextbox") WebElement srh_prdct;
	@FindBy (id = "nav-orders") WebElement orders;
	
	public void Hovarover_accountandlists(WebDriver driver)
	{
		Actions a1 = new Actions(driver);
		a1.moveToElement(acntndLsts).perform();
	}
	public void click_signin()
	{
		signin.click();
	}
	public void click_manage_profile()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mng_prfl));
		mng_prfl.click();
	}
	public void click_view()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-hmdomO qqYTW']")));
		view_btn.click();
	}
	public void search_product()
	{
		wait.until(ExpectedConditions.visibilityOf(srh_prdct));
		srh_prdct.sendKeys(product_name+Keys.ENTER);
	}
	public void clickOrders()
	{
		wait.until(ExpectedConditions.visibilityOf(orders));
		orders.click();
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
