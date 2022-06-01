package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class GiftCardPurchasePopup extends BrowserFunctions {

	private By txtFirstName = By.id("first-name");
	private By txtLastName = By.id("last-name");
	private By txtEmail = By.id("email-address");
	private By txtAmount = By.id("amount");
	private By btnPurchase = By.cssSelector(".w-60");
	private By lblErrorMsg = By.cssSelector("");
	private By cardAmazon = By.xpath("//div[@class='gift-card-list-item__gift-image-container']");// amazon
	private By cardVisa = By.xpath("(//button[@class='gift-card-list-item__link'])[2]");// Visa
	private By txtSearch = By.xpath("//input[@placeholder='Search By Keyword']");
	private By giftCardHeading = By.xpath("//h1[text()='Gift Card Purchase']");
	private By labelOrderPreview = By.xpath("//p[text()='Order Preview']");

	private By lblSuccess = By.xpath("//h1[text()='Transaction in Progress']");

	private By lnkCopy = By.cssSelector(".icon-copy");
	private By btnDone = By.cssSelector(".w-60");

	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void enterSearckey(String searchKey) {
		enterText(txtSearch, searchKey, "Search Field");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(giftCardHeading, "Gift Card Purchase", expHeading);
	}

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSuccess, "Tokens Requested Successfully", expHeading);
	}

	public void verifyHeadingOrderPreview(String expHeading) {
		new CommonFunctions().verifyLabelText(labelOrderPreview, "Order preview Heading", expHeading);
	}

	public void fillFirstName(String Firstname) {
		enterText(txtFirstName, Firstname, "Firstname");
	}

	public void fillLastName(String LastName) {
		enterText(txtLastName, LastName, "LastName");
	}

	public void fillEmail(String Email) {
		enterText(txtEmail, Email, "Email");
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public void clickOnPurchase() {
		if (getElement(btnPurchase, "Purchased").isEnabled()) {
			click(btnPurchase, "Click Purchase");
		} else {
			ExtentTestManager.setInfoMessageInReport("Purchased Button is disable");
		}

	}

	public void VerifyErrorMessage(String ErrorMessage) {
		new CommonFunctions().verifyLabelText(lblErrorMsg, ErrorMessage, "ErrorMessage");
	}

	public void clickOnAmazon() {
		click(cardAmazon, "Click Amazon");
	}

	public void clickOnVisa() {
		click(cardVisa, "Click Visa");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

}
