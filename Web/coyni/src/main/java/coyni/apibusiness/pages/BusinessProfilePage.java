package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.PaymentMethodComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfilePage extends BrowserFunctions {
	private By imageImg = By.cssSelector(" ");
	private By lblAccountId = By.xpath("//div[contains(text(),'Account ID:')]");
	private By lblUserName = By.xpath("//div[contains(text(),'Account ID:')]/preceding-sibling::div ");
	private By countNotifications = By.xpath("//div[@class='notification-count']");

	public void countNotify() {
		String notifyCount = getText(countNotifications, "");
		ExtentTestManager.setInfoMessageInReport(notifyCount + " Notifications are displayed");
	}

	public void verifyViewImage() {
		new CommonFunctions().elementView(imageImg, "imageImg");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(lblAccountId, "AccountId");
	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "AccountUser");
	}

	public PaymentMethodComponent paymentMethodComponent() {
		return new PaymentMethodComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}

}
