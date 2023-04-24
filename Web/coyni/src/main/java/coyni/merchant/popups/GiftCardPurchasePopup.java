package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.reusable.components.ProcessingFeeComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class GiftCardPurchasePopup extends BrowserFunctions {

	CommonFunctions cf = new CommonFunctions();
	private By giftCardHeading = By.xpath("//h1[text()='Gift Card Purchase']");
	private By lblDescription = By.xpath("//span[.='Select Your Gift Card:']");
	private By txtSearch = By.className("Input_form_input__yl3pD");
	private By GiftCards = By.xpath("//div[@class='gift-card-list-item__wrapper']");
	private By lblEntries = By.xpath("(//span[contains(@class,'entries-message')])[2]");
	private By lblPagenator = By.xpath("(//ul[@class='paginator__pagination'])[2]");
	private By lblDailyLimitMsg = By.xpath("//p[contains(.,'Your  limit')]");
	private By lblGiftCardName = By.xpath("(//div/h2)[2]");
	private By lblSuccess = By.xpath("//h1[text()='Transaction in Progress']");
	private By lblGiftCardDescription = By.xpath("(//div/p)[2]");
	private By txtFirstName = By.id("first-name");
	private By txtLastName = By.id("last-name");
	private By txtEmail = By.id("email-address");
	private By txtAmount = By.id("amount");
	private By lblMsg = By.xpath("//span[contains(.,'Please double')]");
	private By btnPurchase = By.xpath("//button[.='Purchase']");
	private By labelOrderPreview = By.xpath("//p[text()='Order Preview']");
	private By cardAmazon = By.xpath("//div[@class='gift-card-list-item__gift-image-container']");// amazon
	private By cardVisa = By.xpath("(//button[@class='gift-card-list-item__link'])[2]");// Visa
	private By lnkCopy = By.cssSelector(".icon-copy");
	private By btnDone = By.cssSelector(".w-60");

	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void switchToAdmin(String url) throws InterruptedException {
		new CommonFunctions().switchtoUrl(url);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void enterSearckey(String searchKey) throws InterruptedException {
		Thread.sleep(2000);
		enterText(txtSearch, searchKey, "Search Field");
	}

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(giftCardHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickOnAmazon() {
		click(cardAmazon, "Click Amazon");
	}

	public void clickOnVisa() {
		click(cardVisa, "Click Visa");
	}

	public void verifySearchField() {
		cf.elementView(txtSearch, "Search text field");
	}

	public void verifyGiftCards() {
		List<WebElement> list = getElementsList(GiftCards, "");
		int size = list.size();
		ExtentTestManager.setInfoMessageInReport(size + " Gift cards are displayed");
		for (WebElement webElement : list) {
			webElement.click();
			break;
		}
	}

	public void verifyEntriesLbl() {
		String text = getText(lblEntries, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyPagenator() {
		cf.elementView(lblPagenator, "Pagenator");
	}

	public void verifyDailyMsg() {
		getText(lblDailyLimitMsg, "Daily Limit Message");
	}

	public void verifyGiftCardName() {
		String text = getText(lblGiftCardName, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyGiftCardDescription() {
		cf.elementView(lblGiftCardDescription, "Gift card description");
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

	public void verifyMsg() {
		String text = getText(lblMsg, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyPurchaseBtn() {
		cf.elementView(btnPurchase, "Purchase");
	}

	public void clickOnPurchase() {
		click(btnPurchase, "Click Purchase");

	}

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSuccess, "Tokens Requested Successfully", expHeading);
	}

	public void verifyOrderPreview() {
		String text = getText(labelOrderPreview, "");
		ExtentTestManager.setInfoMessageInReport(text);
	}

//	public void verifyOrderPreviewDetails() {
//		List<WebElement> list = getElementsList(lblPurchase, "");
//		for (WebElement webElement : list) {
//			String text = webElement.getText();
//			String value = getText(By.xpath(String.format("//span[.='%s']/following-sibling::div", text)), "");
//			ExtentTestManager.setInfoMessageInReport(text + " value is " + value + " is displayed");
//		}
//	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public ProcessingFeeComponent processingFeeComponent() {
		return new ProcessingFeeComponent();
	}

}
