package Tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import automationTask1.CartPage;
import automationTask1.ItemDetailsPage;
import automationTask1.SearchResultsPage;

public class TestSearch extends BaseTest {

	public TestSearch() throws IOException {
		super();
	}

	@Test
	public void userCanAddItemToCart() {
	 SearchResultsPage searchPageObj = homePageObj.typeTextInSearchBox(prop.getProperty("ProductName"));
	 String firstItemName = searchPageObj.getfirstItemName();
	 System.out.println(firstItemName);
	 ItemDetailsPage itemDetailsObj = searchPageObj.selectFirstItem();
	 itemDetailsObj.addItemToCart();
	 CartPage cartPageObj = itemDetailsObj.goToCart();
	 String verifyItemName = cartPageObj.getItemName();
	 System.out.println(verifyItemName);
	 Assert.assertTrue(firstItemName.startsWith(verifyItemName.subSequence(0, 10).toString()));
	}



}
