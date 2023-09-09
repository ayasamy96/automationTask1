package automationTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

	private WebDriver driver;

	 By FirstItem = By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'][contains(.,'Ships to Egypt')]");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public ItemDetailsPage selectFirstItem() {
		driver.findElement(FirstItem).click();
		return new ItemDetailsPage(driver);
	}

	public String getfirstItemName() {
		return driver.findElement(FirstItem).getText();
	}




}
