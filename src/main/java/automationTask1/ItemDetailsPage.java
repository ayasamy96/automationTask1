package automationTask1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage {

	private WebDriver driver;
	By AddToCartBtn = By.id("add-to-cart-button");
	By GoToCartBtn = By.linkText("Go to Cart");

	public ItemDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addItemToCart() {
		driver.findElement(AddToCartBtn).click();
	}

	public CartPage goToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(GoToCartBtn));
		driver.findElement(GoToCartBtn).click();
		return new CartPage(driver);
	}


}
