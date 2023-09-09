package automationTask1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodayDealsPage {

	private WebDriver driver;
	int productIndex = 26;

	By headphonesCheckBox = By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(.,'Headphones')]");
	By groceryCheckBox = By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(.,'Grocery')]");
	By chooseDiscount = By.linkText("10% off or more");
	By thirdPage = By.xpath("//a[@href='#'][contains(.,'3')]");
	By fourthPageBtn = By.xpath("//a[@href='#'][contains(.,'4')]");
	By itemToAdd = By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]"); 
	By itemToAdd2 = By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]");
	By seeAllOptionsBtn = By.xpath("//a[contains(@title,'See All Buying Options')]"); 
	By addToCartBtn = By.id("add-to-cart-button");
	By addedToCartMessage = By.xpath("//span[contains(.,'Added to Cart')]");

	public TodayDealsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectHeadphonesAndgroceryFromFilters() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(headphonesCheckBox));
		driver.findElement(headphonesCheckBox).click();
		driver.findElement(groceryCheckBox).click();
	}

	public void selectTenPercentDiscount() {
		driver.findElement(chooseDiscount).click();
	}

	public void selectThefourthPage() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(thirdPage));
		driver.findElement(thirdPage).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(fourthPageBtn));
		driver.findElement(fourthPageBtn).click();
	}

	public void AddItemToCart() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemToAdd));
		driver.findElement(By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]")).click();

		boolean done = false;
		while(!done) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(addToCartBtn));
		done = true;
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			driver.navigate().back();
			productIndex++;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemToAdd));
			driver.findElement(By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]")).click();

		}
		}
	}

	public String getAddedToCartMessage() {
		return driver.findElement(addedToCartMessage).getText();
	}
	
}
