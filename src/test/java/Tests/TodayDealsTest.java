package Tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import automationTask1.TodayDealsPage;

public class TodayDealsTest extends BaseTest {


	public TodayDealsTest() throws IOException {
		super();
	}

	@Test
	public void userCanFilterProducts() {
		TodayDealsPage todaysDealsObj = homePageObj.openTodaysDeals();
		todaysDealsObj.selectHeadphonesAndgroceryFromFilters();
		todaysDealsObj.selectTenPercentDiscount();
		todaysDealsObj.selectThefourthPage();
		todaysDealsObj.AddItemToCart();
		Assert.assertTrue(todaysDealsObj.getAddedToCartMessage().contains("Added to Cart")); 
	}

}
