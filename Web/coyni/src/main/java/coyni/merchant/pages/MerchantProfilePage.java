package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.ChangePasswordComponent;
import coyni.merchant.components.MerchantMenuComponent;
import coyni.merchant.components.PreferencesComponent;
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

	public PreferencesComponent preferencesComponent() {
		return new PreferencesComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public ChangePasswordComponent changePasswordComponent() {
		return new ChangePasswordComponent();
	}

	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
