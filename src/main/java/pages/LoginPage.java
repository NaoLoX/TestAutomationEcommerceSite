package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage{

	WebDriver driver;
	private final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement emailAddressField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement createAnAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']") WebElement creatAccountEmailField;
	@FindBy(how = How.XPATH, using = "//*[@id='create_account_error']") WebElement invalidEmailAlert;
	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']/ol/li") WebElement invalidEmailAlertText;
	
	//InteractiveMethods
	public void enterEMailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickSigningButton() {
		signInButton.click();
	}
	
	public void clickCreateAnAccountButton() {
		createAnAccountButton.click();
	}
	
	public void fillCreatAccountEmailField() {
		creatAccountEmailField.sendKeys(randomNumberGenerator() + "." + randomNumberGenerator() + "user@email.com");
	}

	public void fillCreatAccountWithInvalidEmailField(String email) {
		creatAccountEmailField.sendKeys(email);
	}

	public void verifyCreatAccountWithInvalidEmailField() {
		
		if(invalidEmailAlertText.isDisplayed()) {
			logger.info("Success! Alert for invalid email was displayed");
			logger.info(invalidEmailAlertText.getText());
		}else {
			logger.warn("Failure, alert for invalid email was not displayed ");
		}
		
	}
}
