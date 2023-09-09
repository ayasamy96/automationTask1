package automationTask1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private WebDriver driver;
	By ItemName = By.xpath("(//div[contains(@class,'sc-list-item-content')])[1]");
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getItemName() {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(ItemName));
	return	driver.findElement(ItemName).getText();
	}
}
