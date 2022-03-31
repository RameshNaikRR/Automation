package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;

public class APIAdminProfilePage {
	private By imageImg = By.cssSelector(" ");
	private By lblAccountId = By.xpath("//div[contains(text(),'Account ID:')]");
	private By lblUserName = By.xpath("//div[contains(text(),'Account ID:')]/preceding-sibling::div ");

	public void verifyViewImage() {
		new CommonFunctions().elementView(imageImg, "imageImg");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(lblAccountId, "AccountId");
	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "AccountUser");
	}

	
}
