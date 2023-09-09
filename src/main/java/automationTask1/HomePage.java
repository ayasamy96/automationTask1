package automationTask1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	 private WebDriver driver;

	 By searchTextBox = By.id("twotabsearchtextbox");
	 By searchBtn = By.id("nav-search-submit-button");
	 By todaysDealsBtn = By.linkText("Today's Deals");
	 By exceptionBtn= By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public SearchResultsPage typeTextInSearchBox(String text) {
		driver.findElement(searchTextBox).sendKeys(text);
		driver.findElement(searchBtn).click();
		return new SearchResultsPage(driver);
	}

	public TodayDealsPage openTodaysDeals() {
		try{
			driver.findElement(todaysDealsBtn).click();
		}
		catch(ElementClickInterceptedException e) {
			driver.findElement(exceptionBtn).click();

			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(todaysDealsBtn));
			driver.findElement(todaysDealsBtn).click();
		}

		return new TodayDealsPage(driver);
	}



}
