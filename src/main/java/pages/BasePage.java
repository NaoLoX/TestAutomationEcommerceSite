package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasePage {
	private final Random random = new Random();
	public int randomNumberGenerator() {
		return random.nextInt() * 999 + 100;
	}

	public int dateNumberGenerator() {
		return random.nextInt() * 31 + 1;
	}

	public String phoneNumberGenerator() {
		int areaCode = random.nextInt() * 999 + 100;
		int firstThree = random.nextInt() * 999 + 100;
		int lastFour =  random.nextInt()* 9999 + 1000;
		return areaCode + " " + firstThree + " " + lastFour;
	}

	public void selectFromDropdownByVisibleText(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(input);
	}

	public void selectFromDropdownByValue(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(input);
	}

	public String removeDecimalPoint(String str) {
		return str.substring(0, str.length() - 2);
	}

	public double convertStringToDouble(WebElement element) {
		String stringElement = element.getText().substring(1);
		return Double.parseDouble(stringElement);
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
