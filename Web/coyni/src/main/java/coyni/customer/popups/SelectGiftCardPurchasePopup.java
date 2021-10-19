package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class SelectGiftCardPurchasePopup extends BrowserFunctions{
	
	private By lnkGiftCard = By.cssSelector("");
	private By txtSearch = By.cssSelector("");
	private By lnkViewMore = By.cssSelector("");
	private By lnkPageNumber = By.cssSelector("");
	
	public void clickOnGiftCardLink() {
		click(lnkGiftCard, "click GiftCard");
	}
   
	public void searchText(String Search) {
		enterText(txtSearch, Search, "Search");
	}
	
	public void clickOnViewMoreLink() {
		click(lnkViewMore, "click ViewMore");
	}
	
	public void clickOnPageNumberLink() {
		click(lnkPageNumber, "Click Page Number");
	}
}
