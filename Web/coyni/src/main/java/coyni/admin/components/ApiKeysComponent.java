package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApiKeysComponent extends BrowserFunctions {

	private By lblApiKey = By.xpath("//span[text()='API Keys']");
	private By btnGenerateApiKeys = By.xpath("//button[text()='Generate API Key']");// Admin
	private By lnkGenerateSecretKey = By.xpath("//button[text()='Generate a New Secret Key']");// Admin
	private By lblSecretKey = By.xpath("//button[text()='Reveal Secret Key']");// admin

	public void clickGenerateApiKey() {
		if(getElement(btnGenerateApiKeys, "Api Keys").isEnabled()) {
		click(btnGenerateApiKeys, "Generate API Key");
		}else {
			ExtentTestManager.setInfoMessageInReport("Api Key generate SuccessFully");
		}
	}

	public void verifyAPIKey(String expHeading) {
		new CommonFunctions().verifyLabelText(lblApiKey, expHeading, "API Key");
	}

	public void clickGenerateSecretKey() {
		click(lnkGenerateSecretKey, "Generate Secret Key");
	}

	public void clickRevealKey() {
		click(lblSecretKey, "RevealKey Key");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public IpWhiteListComponent ipWhiteListComponent() {
		return new IpWhiteListComponent();
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
