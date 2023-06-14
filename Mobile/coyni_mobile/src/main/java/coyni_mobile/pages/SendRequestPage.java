package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.OptionalMessagePopup;
import coyni_mobile.components.ReloadPopup;
import coyni_mobile.utilities.AndroidCommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SendRequestPage extends MobileFunctions {
// Send and Request select contact page elements
	private By lblHeading = MobileBy.AccessibilityId("//*[@name='close']/following-sibling::*[1]");
	private By iconSearch = MobileBy.AccessibilityId("(//XCUIElementTypeImage[@name='search'])[1]");
	private By txtSearchBx = MobileBy.AccessibilityId("(//*[@name='search'])[2]/following-sibling::*[1]");
	private By lblUser = MobileBy.AccessibilityId(
			"(//*[@name='search']/../../../following-sibling::*[1]/XCUIElementTypeTable/XCUIElementTypeCell)[1]");
	private By lblRecentContacts = MobileBy.AccessibilityId("(//*[@name='Recent Contacts'])[1]");
	private By lblContactList = MobileBy.AccessibilityId("(//*[@name='Contact List'])[1]");
	private By RecentContactsList = MobileBy
			.AccessibilityId("(//*[@name='Contact List'])[1]/preceding-sibling::XCUIElementTypeCell");
	private By ContactList = MobileBy
			.AccessibilityId("(//*[@name='Contact List'])[1]/following-sibling::XCUIElementTypeCell");
	private By RecentContactList = MobileBy.AccessibilityId(
			"//*[contains(@name,'invite your friends')]/..)[2]/preceding-sibling::XCUIElementTypeCell");
	private By firstRecentContact = MobileBy.AccessibilityId("//*[@name='Recent Contacts']/following-sibling::*[1]");
	private By lblOtherpeopleOnCoyni = MobileBy
			.AccessibilityId("//XCUIElementTypeOther[@name='Other people on coyni']");
	private By lblFirstAccount = MobileBy
			.AccessibilityId("//XCUIElementTypeOther[@name='Other people on coyni']/following-sibling::*[1]");
	private By btnCross = MobileBy.AccessibilityId("//XCUIElementTypeButton[@name='close']");
	private By btnScan = MobileBy
			.AccessibilityId("//XCUIElementTypeOther[@name='Other people on coyni']/following-sibling::*[1]");
	private By btnMyQRCode = MobileBy.AccessibilityId("//XCUIElementTypeButton[@name='close']");
	private By lblScanCode = MobileBy.AccessibilityId("");
	private By lblShare = MobileBy.AccessibilityId("");

// Send and Request Account holder details
	private By lblSend = MobileBy.AccessibilityId("");
	private By lblName = MobileBy.AccessibilityId("//*[@name='currency toggle']/../preceding-sibling::*[1]/*[2]/*[1]");
	private By txtAmount = MobileBy.AccessibilityId("//*[@name='currency toggle']/preceding-sibling::*[1]");
	private By btnSend = MobileBy.AccessibilityId("(//*[@name='Send'])[1]");
	private By btnRequest = MobileBy.AccessibilityId("(//*[@name='Request'])[1]");
	private By btnMessage = MobileBy.AccessibilityId("(//*[contains(@name,'Optional')])");
	private By lnkConverter = MobileBy.AccessibilityId("//*[@name='currency toggle']");
	private By lblAmountInDollars = MobileBy
			.AccessibilityId("//*[@name='$']/following-sibling:: XCUIElementTypeTextField");
	private By lblBalance = MobileBy
			.AccessibilityId("//*[contains(@name,'Optional')]/../preceding-sibling::*[1]/XCUIElementTypeStaticText");
	private By lblPopupHeading = MobileBy.AccessibilityId("//*[@name='Oops!']");
	private By lblPopupDes = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");
	private By btnReload = MobileBy.AccessibilityId("(//*[@name='Buy Tokens'])[1]");
	private By lblAmount = MobileBy.AccessibilityId("(//*[@name='Buy Tokens'])[1]");
	private By btnDiscard = MobileBy.AccessibilityId("(//*[@name='Buy Tokens'])[1]");
	private By btnContinue = MobileBy.AccessibilityId("(//*[@name='Buy Tokens'])[1]");
	private By lblWeeklyLimit = MobileBy.AccessibilityId("");

//	Confirm popup details
	private By lblAvailBal = MobileBy.AccessibilityId("//*[@name='Oops!']");
	private By lblSenderName = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");
	private By btnConfirm = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");
	private By lblRequesting = MobileBy.AccessibilityId("//*[@name='Oops!']");
	private By lblReceiptentName = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");
	private By lblMessage = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");
	private By lblNewBalance = MobileBy.AccessibilityId("//*[contains(@name,'Seems')]");

	public double verifyWeeklyLimit() {
		new CommonFunctions().elementView(lblWeeklyLimit, "Weekly Limit");
		double weeklyLimit = Double.parseDouble(getText(lblWeeklyLimit).replace("Weekly limit is ", ""));
		return weeklyLimit;
	}

	public void viewSendHeading() {
		new CommonFunctions().elementView(lblSend, "Send");
	}

	public void clickDisCard() {
		click(btnDiscard, "Discard");
	}

	public void clickContinue() {
		click(btnContinue, "Continue");
	}

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void clickNativeKeyBack() {
		new CommonFunctions().clickBack();
	}

	public void verifyScanCodePage() {
		new CommonFunctions().elementView(lblScanCode, "Scan Code");
	}

	public void clickMyQRCode() {
		click(btnMyQRCode, "My QR Code");
		new CommonFunctions().elementView(lblShare, "Share");
	}

	public void viewRequestingHeading() {
		new CommonFunctions().elementView(lblRequesting, "Requesting");
	}

	public String verifyReceiptentName() {
		new CommonFunctions().elementView(lblReceiptentName, "Receiptent Name");
		return getText(lblReceiptentName);
	}

	public String verifyMessage() {
		new CommonFunctions().elementView(lblMessage, "Message");
		return getText(lblMessage);
	}

	// Send and Request select contact page methods
	public void verifyOtherPeopleView() {
		new CommonFunctions().elementView(lblOtherpeopleOnCoyni, "Other people on Coyni");
		click(lblFirstAccount, "First Account");
	}

	public String verifyfirstRecentContact() {
		click(firstRecentContact, "contact list");
		return getText(firstRecentContact);
	}

	public void verifyRecentContactListSize() throws InterruptedException {
		Thread.sleep(1000);
		int contacts = getElementList(RecentContactsList, "Contact List").size();
		System.out.println(contacts);
		if (contacts <= 5) {
			ExtentTestManager.setPassMessageInReport("Recent contact list is equal or below five contacts");
		} else {
			ExtentTestManager.setFailMessageInReport("Recent contact list is above 5 Contacts");
		}

	}

	public void verifyRecentContactList() throws InterruptedException {
		if (getElementList(RecentContactsList, "").size() > 0) {
			Thread.sleep(1000);
			ExtentTestManager.setInfoMessageInReport("Recent Contacts are displayed");
		} else {
			ExtentTestManager.setInfoMessageInReport("you have no recent contacts");
		}
	}

	public void verifyContactList() throws InterruptedException {
		if (getElementList(ContactList, "").size() >= 1) {
			Thread.sleep(1000);
			ExtentTestManager.setInfoMessageInReport("Contacts are displayed");
		} else {
			ExtentTestManager.setInfoMessageInReport("you have no contacts");
		}
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void verifySendRequestPageView() {
		new CommonFunctions().elementView(lblHeading, "Send/Request Page ");
	}

	public void clickSearch() {
		click(iconSearch, "Search");
	}

	public void fillSearchBx(String userName) {
		enterText(txtSearchBx, userName, "userName");
	}

	public void selectUser() {
		click(lblUser, "user");
	}

	public void verifyRecentContactslblView() {
		new CommonFunctions().elementView(lblRecentContacts, "Recent Contacts label");
	}

	public void verifyContactsListlblView() {
		new CommonFunctions().elementView(lblContactList, "Contacts List");
	}

//	public ScanPage scanPage() {
//		return new ScanPage();
//	}
////	public SelectUserPage selectUserPage() {
////		return new SelectUserPage();
////	}
	public void clickCross() {
		click(btnCross, "Cross");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public String verifyName() {
		new CommonFunctions().elementView(lblName, "Name");
		return getText(lblName);
	}

	public void clickConverter() {
		click(lnkConverter, "Converter");
	}

	public void clickSend() {
		click(btnSend, "Send");
	}

	public void clickRequest() {
		click(btnRequest, "Request");
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "amount");
	}

	public void verifyResetAmount() {
		double amt = Double.parseDouble(getText(txtAmount));
		if (amt == 0.00) {
			ExtentTestManager
					.setPassMessageInReport("After clicked on New Amount button, the amount field is reset to 0");
		} else {
			ExtentTestManager
					.setFailMessageInReport("After clicked on New Amount button, the amount field is not reset to 0");
		}
	}

	public int verifyAmount() {
		Integer amt = Integer.parseInt(getText(lblAmount));
		return amt;
	}

	public void clickMessageButton() {
		click(btnMessage, "Message Button");
	}

	public void getAmountInDollars() {
		ExtentTestManager.setInfoMessageInReport(
				"Amount In Dollars: $" + new CommonFunctions().getTextBoxValue(lblAmountInDollars));
	}

	public void getBalance() {
		ExtentTestManager.setInfoMessageInReport(getText(lblBalance));
	}

	public OptionalMessagePopup optionalMessagePopup() {
		return new OptionalMessagePopup();
	}

//
//	public SendRequestConfirmPopup SendRequestConfirmPopup() {
//		return new SendRequestConfirmPopup();
//	}
//	
	public void verifyPopupHeading(String expPopupHeading) {
		new CommonFunctions().verifyLabelText(lblPopupHeading, "Popup Heading", expPopupHeading);
	}

	public void verifypopupDes(String expPopupDes) {
		new CommonFunctions().verifyLabelText(lblPopupDes, "Popup Description", expPopupDes);
	}

	public void clickReload() {
		click(btnReload, "Reload");
	}

//	Confirm payment details
	public void viewSender() {
		new CommonFunctions().elementView(lblSenderName, "Sender Name");
	}

	public int verifyAvailbleBalance() {
		String avlBal = getText(lblAvailBal).replace("Available Balance:", "").replace(" CYN", "");
		int avlBalance = Integer.parseInt(avlBal);
		return avlBalance;
	}

	public void viewNewBalance() {
		new CommonFunctions().elementView(lblNewBalance, "New Balance");
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public ReloadPopup reloadPopup() {
		return new ReloadPopup();
	}

}
