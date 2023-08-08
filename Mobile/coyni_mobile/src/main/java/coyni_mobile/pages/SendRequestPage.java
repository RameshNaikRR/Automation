package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.popups.OptionalMessagePopup;
import coyni_mobile.popups.ReloadPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SendRequestPage extends MobileFunctions {
// Send and Request select contact page elements
	private By lblHeading = MobileBy.xpath("//*[@text='Send/Request']");
	private By iconSearch = MobileBy.AccessibilityId("(//XCUIElementTypeImage[@name='search'])[1]");
	private By txtSearchBx = MobileBy.id("com.coyni.mapp:id/etSearch");
	private By lblUser = MobileBy.xpath(
			"(//*[@text='Recents']/following-sibling::*)[1]|(//*[@text='Other people on coyni']/following-sibling::android.widget.FrameLayout/descendant::android.widget.TextView[contains(@resource-id,'tvUserName')])[1]");
	private By lblRecentContacts = MobileBy.AccessibilityId("(//*[@name='Recent Contacts'])[1]");
	private By lblContactList = MobileBy.AccessibilityId("(//*[@name='Contact List'])[1]");
	private By RecentContactsList = MobileBy
			.AccessibilityId("(//*[@name='Contact List'])[1]/preceding-sibling::XCUIElementTypeCell");
	private By ContactList = MobileBy
			.AccessibilityId("(//*[@name='Contact List'])[1]/following-sibling::XCUIElementTypeCell");
	private By RecentContactList = MobileBy.AccessibilityId(
			"//*[contains(@name,'invite your friends')]/..)[2]/preceding-sibling::XCUIElementTypeCell");
	private By firstRecentContact = MobileBy.xpath(
			"(//*[@text='Recents']/following-sibling::*/descendant::android.widget.TextView[contains(@resource-id,'tvUserName')])[1]");
	private By lblOtherpeopleOnCoyni = MobileBy
			.AccessibilityId("//XCUIElementTypeOther[@name='Other people on coyni']");
	private By lblFirstAccount = MobileBy
			.AccessibilityId("//XCUIElementTypeOther[@name='Other people on coyni']/following-sibling::*[1]");
	private By btnCross = MobileBy.AccessibilityId("//XCUIElementTypeButton[@name='close']");
	private By btnScan = MobileBy.id("com.coyni.mapp:id/imgScan");
	private By btnPermission = MobileBy.xpath("//*[@text='While using the app']");
	private By btnMyQRCode = MobileBy.id("com.coyni.mapp:id/scanMeTV");
	private By btnScanCode = MobileBy.id("com.coyni.mapp:id/scanCodeTV");
	private By lblShare = MobileBy.id("com.coyni.mapp:id/imgShare");

// Send and Request Account holder details
	private By lblSend = MobileBy.xpath("//*[@text='Send / Request']");
	private By lblConfmSendHeading = MobileBy.xpath("//*[@text='Send']");
	private By lblName = MobileBy.id("com.coyni.mapp:id/tvName");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/payrequestET");
	private By btnSend = MobileBy.id("com.coyni.mapp:id/tvPay");
	private By btnRequest = MobileBy.id("com.coyni.mapp:id/tvRequest");
	private By btnMessage = MobileBy.id("com.coyni.mapp:id/addNoteClickLL");
	private By lblPopupHeading = MobileBy.id("com.coyni.mapp:id/tvHead");
	private By lblPopupDes = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By btnReload = MobileBy.id("com.coyni.mapp:id/reloadCV");
	private By btnNewAmount = MobileBy.id("com.coyni.mapp:id/cancelCV");
//	private By lblAmount = MobileBy.AccessibilityId("(//*[@name='Buy Tokens'])[1]");
	private By btnDiscard = MobileBy.id("com.coyni.mapp:id/discardLL");
	private By btnContinue = MobileBy.id("com.coyni.mapp:id/continueLL");
	private By lblWeeklyLimit = MobileBy.xpath("//*[contains(@resource-id,'limitsTV')]");

//	Confirm popup details
	private By lblAvailBal = MobileBy
			.xpath("// *[contains(@resource-id,'tvAvailableBal')]|// *[contains(@resource-id,'tvErrMessage')]");
	private By lblReqstAmount = MobileBy.id("com.coyni.mapp:id/amountPayTV");
	private By lblSenderName = MobileBy.id("com.coyni.mapp:id/tokenAccountTextview");
	private By btnConfirm = MobileBy.id("com.coyni.mapp:id/cvConfirm");
	private By lblRequesting = MobileBy.xpath("//*[@text='Requesting']");
	private By lblReceiptentName = MobileBy.id("com.coyni.mapp:id/tvContactName");
	private By lblMessage = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By lblNewBalance = MobileBy.id("com.coyni.mapp:id/imgNewBalance");
	private By lblSendErrMsg = MobileBy.id("com.coyni.mapp:id/tvSendEMsg");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

	public double verifyLimit() {
		new CommonFunctions().elementView(lblWeeklyLimit, "Weekly Limit");
		double weeklyLimit = Double
				.parseDouble(getText(lblWeeklyLimit).replace("Weekly limit is ", "").replace("Daily limit is ", "")
						.replace(" CYN", "").replace(",", "").replace("Per transaction limit is", ""));
		return weeklyLimit;
	}

	public void verifySendHeading(String expText) {
		new CommonFunctions().verifyLabelText(lblSend, "Send / Request heading", expText);
	}

	public void verifySendErrMsg(String expText) {
		new CommonFunctions().verifyLabelText(lblSendErrMsg, "Send Exceed amount error message", expText);
	}

	public void verifyConfmSendHeading(String expText) {
		new CommonFunctions().verifyLabelText(lblConfmSendHeading, "Send heading", expText);
	}

	public void clickDisCard() {
		click(btnDiscard, "Discard");
	}

	public void clickContinue() {
		click(btnContinue, "Continue");
	}

	public void clickPermission() throws InterruptedException {
//		Thread.sleep(1000);
//		if (getElementList(btnPermission, "Permission").size() == 0) {
		click(btnPermission, "Permission");
//		}
	}

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void clickNativeKeyBack() {
		new CommonFunctions().clickBack();
	}

	public void verifyScanCodePage() {
		new CommonFunctions().elementView(btnScanCode, "Scan Code");
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
		return getText(firstRecentContact);
	}

	public void clickfstRcntContact() {
		click(firstRecentContact, "contact list");
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
		DriverFactory.getDriver().hideKeyboard();
		if (getElement(lblUser, "User").isDisplayed()) {
			click(lblUser, "User");
		} else {
			ExtentTestManager.setFailMessageInReport("The Search results are not coming accurately/Given invalid data");
		}
//		click(MobileBy.xpath(String.format("(//*[@text='%s'])[1]", name)), "user");
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

	public void clickSend() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnSend));
		click(btnSend, "Send");
	}

	public void clickRequest() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnRequest));
		click(btnRequest, "Request");
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "amount");
	}

	public void clickAmount(String amount) {
		click(txtAmount, "amount");
	}

	public void verifyResetAmount(String amount) {
		double amt = Double.parseDouble(getText(txtAmount));
		if (amt == Double.parseDouble(amount)) {
			new CommonFunctions().verifyAutoFocusElement(txtAmount, "Amount");
			ExtentTestManager
					.setPassMessageInReport("After clicked on New Amount button, the same amount is showing in field");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"After clicked on New Amount button, the same amount is not showing in field");
		}
	}

	public double verifyRqstAmount() {
		double amt = Double.parseDouble(getText(lblReqstAmount));
		return amt;
	}

	public double verifySendCnfmAmount() {
		double amt = Double.parseDouble(getText(txtAmount));
		return amt;
	}

	public void clickMessageButton() {
		click(btnMessage, "Message Button");
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

	public double verifyAvailbleBalance() {
		double avlBalance = Double.parseDouble(getText(lblAvailBal).replace("Available Balance: ", "")
				.replace(" CYN", "").replace("Insufficient Balance:", ""));
		ExtentTestManager.setPassMessageInReport(getText(lblAvailBal));
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

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
