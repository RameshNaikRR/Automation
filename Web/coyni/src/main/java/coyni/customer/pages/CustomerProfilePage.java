package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.ChangePasswordComponent;
import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.PaymentMethodsComponent;
import coyni.customer.components.PreferencesComponent;
import coyni.customer.components.ToastComponent;
import coyni.customer.components.UserDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CustomerProfilePage extends BrowserFunctions {
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

	public CustomerMenuComponent customerMenuComponent() {
		return new CustomerMenuComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}

	public PaymentMethodsComponent paymentMethodsComponent() {
		return new PaymentMethodsComponent();
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
