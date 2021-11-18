package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.MyQRCodeComponent;
import coyni.customer.components.UserNameDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NavigationMenuPage extends BrowserFunctions {

	// added
	private By btnTokenAccount = By.id("token-dashboard");
	private By lblMessage = By.cssSelector(".welcome-text");
	private By notificationsIcon = By.cssSelector(".icon-notification-bold");
	private By lnkExportFiles = By.xpath("//span[text()='Export Files']");
	private By lnkGetHelp = By.xpath("//span[text()='Get Help']");

	private By lblUserNameMenu = By.cssSelector("");
	private By lblAccountId = By.xpath("//span[text()='Account ID:']");
	private By lnkTokenAccount = By.id("token-dashboard");
	private By ImgQRcode = By.cssSelector(" ");
	private By lblUserNameHead = By.cssSelector(" ");
	private By ImgNotifications = By.cssSelector(" ");
	private By imgUser = By.cssSelector("");
	private By drpDwnAccount = By.cssSelector("");
	private By lnkPersonalAccount = By.cssSelector("");
	private By lnkBusinessAccount = By.cssSelector("");
	private By lblBusinessAccount = By.cssSelector("");
	private By lnkAddNewBusiness = By.cssSelector("");
	private By lblTokenAccount = By.cssSelector("");
	private By lblExportFiles = By.xpath("");
	private By lblGetHelp = By.xpath("");

	// added
	public void clickTokenAccount() {
		click(btnTokenAccount, "Token Account ");
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
		new CommonFunctions().verifyLabelText(lblAccountId, "Account ID", expAccountID);
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

	public void verifyPersonalAccountView() {
		new CommonFunctions().elementView(lnkPersonalAccount, "Personal Account ");
	}

	public void verifyBusinessAccountView() {
		new CommonFunctions().elementView(lnkBusinessAccount, "Business Account ");
	}

	public void verifyAddNewBusinessAccountView() {
		new CommonFunctions().elementView(lnkAddNewBusiness, "Add New Business");
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

	// added
	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public void verifyBellIconMouseHoverAction(String background, String border) {
		new CommonFunctions().verifyMouseHoverAction(notificationsIcon, "Notification Icon", background, border);
	}
}
