package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.MerchantMenuComponent;
import coyni.merchant.components.ToastComponent;
import coyni.merchant.components.UserDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantProfilePage extends BrowserFunctions {

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

	public MerchantMenuComponent merchantMenuComponent() {
		return new MerchantMenuComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}

	public MerchantAccountsPage merchantAccountsPage() {
		return new MerchantAccountsPage();
	}

	public PreferencesPage preferencesPage() {
		return new PreferencesPage();
	}

	public AgreementsPage agreementsPage() {
		return new AgreementsPage();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public ChangePasswordPage changePasswordPage() {
		return new ChangePasswordPage();
	}

	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public TwoStepAuthenticationPage twoStepAuthenticationPage() {
		return new TwoStepAuthenticationPage();
	}

	public MerchantSettingsPage merchantSettingsPage() {
		return new MerchantSettingsPage();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
