package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.MyQRCodeComponent;
import coyni.customer.components.UserNameDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class NavigationMenuPage extends BrowserFunctions {

	// added
	private By btnTokenAccount = By.id("token-dashboard");
	private By lblMessage = By.cssSelector(".welcome-text");
	private By notificationsIcon = By.cssSelector(".icon-notification-bold");
	private By lnkExportFiles = By.xpath("//span[text()='Export Files']");
	private By lnkGetHelp = By.xpath("//span[text()='Get Help']");

	private By lblUserNameMenu = By.cssSelector("");
	private By lblAccountId = By.xpath("(//span[contains(text(),'Account ID:')])[1]");
	private By lnkTokenAccount = By.cssSelector("#token-dashboard");
	private By ImgQRcode = By
			.xpath("(//button[contains(@class,'UserProfile_QR_main__')])[1]");
	private By lblUserNameHead = By
			.xpath("//div[contains(@class,'DashboardMenu_downArrow')]/preceding-sibling::*[1]");
	private By ImgNotifications = By.cssSelector(" ");
	private By imgUser = By.xpath("//div[contains(@class,'bg-cm3 rounded-full UserProfile_image_navbar__1d_ht')]");
	private By drpDwnAccount = By.xpath("//div[contains(@class,'DashboardMenu_downArrow')]");
	private By lblPersonalAccount = By.xpath("(//div[text()='Personal Account'])[1]");
	private By lnkBusinessAccount = By.xpath("");
	private By lblBusinessAccount = By.cssSelector("");
	private By lnkAddNewBusiness = By.xpath("//div[text()=' Add New Business']");
	private By lblTokenAccount = By.cssSelector("");
	private By lblExportFiles = By.xpath("");
	private By lblGetHelp = By.xpath("");

	private By getSidebarItems(String sidebarItems) {
		return By.xpath(String.format(
				"(//div[contains(@class,'DashboardMenuItems_imgLogo__2kQaD ')]/following-sibling::span[text()='%s'])[1]",
				sidebarItems));
	}

	public String getCustId() {
		return getText(lblAccountId, "Account Id").replaceAll("[^0-9]", "");
	}

	// added
	public void clickTokenAccount() {
		click(getSidebarItems("Token Account"), "Token Account ");
		// click(btnTokenAccount, "Token Account ");

	}

	// added
	public void verifyLabelMessage() {
		new CommonFunctions().elementView(lblMessage, "Welcome to Coyni! ");

	}

//		public void verifyProfileInformation() {
//			new CommonFunctions().elementView(profileInfo, "Profile Information");
//		}

	// added
	public void verifyNotificationsIcon() {
		new CommonFunctions().elementView(notificationsIcon, "Bell Icon");
	}

	public void clickExportFilesMenu() {
		click(lnkExportFiles, "exports button");
	}

	public void clickGetHelpMenu() {
		click(lnkGetHelp, "help button");
	}

	public String getUserName() {
		return getText(lblUserNameMenu, "username");
	}

	public String getAccountId() {
		return getText(lblAccountId, "account Id").split("-")[1];
	}

	public void clickTokenAccountMenu() {
		click(lnkTokenAccount, "TokenAccount");
	}

	public void clickQRcode() {
		click(ImgQRcode, "QR code");
	}

	public void clickUserNameHead() {
		click(lblUserNameHead, "UserNameHeading");
	}

	public void clickNotifications() {
		click(ImgNotifications, "ImageNotifications");
	}

	public CustomerMenuComponent customerMenuComponent() {
		return new CustomerMenuComponent();
	}

	public MyQRCodeComponent myQRCodeComponent() {
		return new MyQRCodeComponent();
	}

	public void verifyAccountHolderNameView() {
		new CommonFunctions().elementView(lblUserNameHead, "Account Holder Name");
	}

	public void verifyAccountIDView() {
		new CommonFunctions().elementView(lblAccountId, "Account ID");
	}

	public void verifyAccountID(String expAccountID) {
		String id = getText(lblAccountId, "Account ID").split(" ")[2];
		System.out.println("id: " + id);
		if (id.equals(expAccountID)) {
			ExtentTestManager.setPassMessageInReport(id +" Account Id is verified");
		} else {
			ExtentTestManager.setWarningMessageInReport(id +" Account Id is not verified");
		}
	}

	public void verifyUserImageView() {
		new CommonFunctions().elementView(imgUser, "User Image");
	}

	public void verifyQRCodeView() {
		new CommonFunctions().elementView(ImgQRcode, "QR code");
	}

	public void clickAccountDropdwn() {
		click(drpDwnAccount, "Account Dropdown");

	}

	public void clickOnRefresh() {
		new CommonFunctions().Refresh();
	}

	public void verifyPersonalAccountView() {
		new CommonFunctions().elementView(lblPersonalAccount, "Personal Account ");
	}

	public void verifyBusinessAccountView() {
		new CommonFunctions().elementView(lnkBusinessAccount, "Business Account ");
	}

	public void verifyAddNewBusinessAccountView() {
		new CommonFunctions().elementView(lnkAddNewBusiness, "Add New Business");
		verifyElementDisabled(lnkAddNewBusiness, "Add New Business");
	}

	public void verifyAddNewBusinessAccountLabel(String expMessage) {
		new CommonFunctions().verifyLabelText(lblBusinessAccount, "Message", expMessage);
	}

	public void verifyTokenAccountView() {
		new CommonFunctions().elementView(lnkTokenAccount, "Token Account");
	}

	public void verifyExportFilesView() {
		new CommonFunctions().elementView(lnkExportFiles, "Export Files");
	}

	public void verifyGetHelpView() {
		new CommonFunctions().elementView(lnkGetHelp, "Get Help");
	}

	public void verifyTokenAccountHeadingView() {
		new CommonFunctions().elementView(lblTokenAccount, "Token Account ");
	}

	public void verifyExportFilesHeadingView() {
		new CommonFunctions().elementView(lblExportFiles, "Export Files ");
	}

	public void verifyGetHelpHeadingView() {
		new CommonFunctions().elementView(lblGetHelp, "Get Help ");
	}

	// added
	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}

	public void verifyBellIconMouseHoverAction(String background, String border) {
		new CommonFunctions().verifyMouseHoverAction(notificationsIcon, "Notification Icon", background, border);
	}
}
