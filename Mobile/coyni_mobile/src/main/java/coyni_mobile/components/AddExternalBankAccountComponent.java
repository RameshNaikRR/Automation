package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.BankAccountAddedPage;
import coyni_mobile.pages.PaymentMethodsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddExternalBankAccountComponent extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Add Bank Checking Account']");
	private By lblAccountDescription = MobileBy.xpath("//*[contains(@text,'coyni uses')]");
	private By checkBox = MobileBy.xpath("//*[contains(@resource-id,'checkbox')]");
	private By checkBoxDescription = MobileBy.xpath("//*[contains(@text,'I understand that')]");
	private By btnStart = MobileBy.xpath("//*[contains(@resource-id,'cvStart')]");
	private By lblSelectInstitution = MobileBy.xpath("//*[@text='Select your institution']");
	// private By btnMXOauth = MobileBy.xpath("//*[@text='MX Bank (Oauth)www.mx.com']");
	private By LnkSearchInstitutions = MobileBy.xpath("//*[@text='Search more institutions']|//*[@text='Search for your institution']");
	private By lblSearch = MobileBy.xpath("//*[contains(@resource-id,'mx-connect-search')]");
	private By btnTryAgain = MobileBy.xpath("//*[@text='Try Again']");
	private By lblMxOauth = MobileBy.xpath("//*[@text='Add account with MX Bank (Oauth)']|//*[@text='MX Bank (Oauth)']|//*[@text='MX Bank (Oauth) www.mx.com']");
	private By lblVeifyIdentity = MobileBy.xpath("//*[@text='Verify identity']");
	private By btnContinueTesting = MobileBy.xpath("//*[@text='Continue']");
	private By btnMxSavings = MobileBy.xpath("(//*[@text='MX Bank Savings'])[2]");
	private By btnMxChecking = MobileBy.xpath("(//*[@text='MX Bank Checking'])[2]");
	private By btnContinue = MobileBy.xpath("//*[@text='Continue']");
	private By lblAccountAdded = MobileBy.xpath("//*[@text='Bank Account(s) Added']");
	private By lblAccountAddedDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'tvButton')]");

	public void verifyHeading(String bankHeading) {
		new CommonFunctions().verifyLabelText(heading, "Bank Heading", bankHeading);
	}

	public void verifyAccountDescription(String accountDescription) {
		new CommonFunctions().verifyLabelText(lblAccountDescription, "Bank Account Description", accountDescription);
	}

	public void clickCheckBx() {
		click(checkBox, "CheckBox");
	}
    public void fillBankName(String bankName) {
    	enterText(lblSearch, bankName,"Bank Name");
    }
	public void verifyCheckBoxDescription(String checkBxDescription) {
		new CommonFunctions().verifyLabelText(checkBoxDescription, "Checkbox Description", checkBxDescription);
	}

	public void clickStart() {
		click(btnStart, "Start");
	}

	public void verifySelectInstitution(String selectInstitution) {
		new CommonFunctions().verifyLabelText(lblSelectInstitution, "Select Institution", selectInstitution);
	}

	public void clickMxOauth() {
		click(lblMxOauth, "Mx Oauth");
	}

	public void clickSearchInstitution() {
		click(LnkSearchInstitutions, "Search Institution");
	}
	public void verifyMxOauth(String mxOauth) {
		new CommonFunctions().verifyLabelText(lblMxOauth, "Select Institution", mxOauth);
	}
	public void clickContinueTesting() {
		click(btnContinueTesting, "Continue");
	}
	public void verifyIdentity(String identity) {
		new CommonFunctions().verifyLabelText(lblVeifyIdentity, "identity", identity);
	}
	public void clickMxChecking() {
		click(btnMxChecking, "checking");
	}
	public void clickMxSavings() {
		click(btnMxSavings, "Savings");
	}
	public void clickContinue() {
		click(btnContinue, "Continue");
	}
	public void verifyAccountAdded(String successHeading) {
		new CommonFunctions().verifyLabelText(lblAccountAdded, "Account Added", successHeading);
	}
	public void verifyAccountAddedDes(String successDescription) {
		new CommonFunctions().verifyLabelText(lblAccountAddedDescription, "Account Added Description", successDescription);
	}
	public void clickDone() {
		click(btnDone, "Done");
	}
	public BankAccountAddedPage bankAccountAddedPage() {
		return new BankAccountAddedPage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AddAccountsComponent addAccountsComponent() {
		return new AddAccountsComponent();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

}
