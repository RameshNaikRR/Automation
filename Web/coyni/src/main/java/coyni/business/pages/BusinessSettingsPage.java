package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.components.PaymentMethodsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessSettingsPage extends BrowserFunctions {
	private By imageImg = By.cssSelector(" ");
	private By lblAccountId = By.xpath("");
	private By lblUserName = By.xpath("");
	private By wallets = By.xpath("//span[text()='Wallet Settings']");
	private By paymentMethods = By.xpath("//span[@data-ui-auto='payment_method']");
	private By team = By.xpath("");
	private By accountFeeLimits = By.xpath("//span[text()='Account Fees / Limits']");
	private By contactInfo = By.xpath("");
	private By businessInfo = By.xpath("(//span[text()='Business Information'])[1]");

	public void verifyViewImage() {
		new CommonFunctions().elementView(imageImg, "imageImg");
	}

	public void verifyAccountIdView() {
		new CommonFunctions().elementView(lblAccountId, "AccountId");
	}

	public void verifyUserNameView() {
		new CommonFunctions().elementView(lblUserName, "AccountUser");
	}

	public void clickWalletSettings() {
		click(wallets, "Wallet Settings");
	}

	public void clickPaymentMethods() {
		click(paymentMethods, "Payment methods");
	}

	public void clickTeam() {
		click(team, "Team");
	}

	public void clickAccountFeeLimits() {
		click(accountFeeLimits, "AccountFee and Limits");
	}

	public void clickContactInformation() {
		click(contactInfo, "Contact Information");
	}

	public void clickBusinessInformation() {
		click(businessInfo, "Business Information");
	}

	public PaymentMethodsComponent paymentMethodsComponent() {
		return new PaymentMethodsComponent();
	}

	public AccountFeesAndLimitsPage accountFeesAndLimitsPage() {
		return new AccountFeesAndLimitsPage();
	}

	public ContactInformation contactInformation() {
		return new ContactInformation();
	}

	public BusinessInformationPage businessInformation() {
		return new BusinessInformationPage();
	}

	public WalletsPage walletsPage() {
		return new WalletsPage();
	}
}
