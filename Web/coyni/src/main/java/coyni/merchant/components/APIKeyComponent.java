package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.merchant.popups.SecretKeyPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class APIKeyComponent extends BrowserFunctions {

	private By lblApiKey = By.xpath("//span[text()='API Keys']");
	private By lnkGenerateAPiKey = By.xpath("//button[text()='Generate New Secret Key']");
	private By iconCopy = By.xpath("");
	private By btnrevealSecretKey = By.xpath("");
	private By lblPublicKey = By.xpath("//span[text()='Public Key:']");
	private By lblSecretKey = By.xpath("//span[text()='Reveal Secret Key']");
	private By lblInactiveSecretKey = By.xpath("");
	private By lblHideSecretKey = By.xpath("//span[text()='Hide Secret Key']");
	private By txtEvents = By.xpath("//span[@class='text-xs font-bold text-cgy3'][text()]");

	public void verifyAPIKey(String expHeading) {
		new CommonFunctions().verifyLabelText(lblApiKey, expHeading, "API Key");
	}

	public void clickGenerateApiKey() {
		click(lnkGenerateAPiKey, "Generate API Key");
	}

	public void clickCopy() {
		click(iconCopy, "Copy");
	}

	public void clickRevealKey() {
		click(btnrevealSecretKey, "Reveal Key");
	}

	public void clickHideSecretKey() {
		click(lblHideSecretKey, "Hide Secret Key");
	}

	public void verifyCopy() {
		new CommonFunctions().elementView(iconCopy, "Copied to ClipBoard");
	}

	public void verifyPublicKey() {
		new CommonFunctions().elementView(lblPublicKey, "Public Key");
	}

	public void verifySecretKey() {
		new CommonFunctions().elementView(lblSecretKey, "Secret Key");
	}

	public void verifyInactiveSecretKey() {
		new CommonFunctions().elementView(lblInactiveSecretKey, "Inactive Secret Key");
	}

	public SecretKeyPopup secretKeyPopup() {
		return new SecretKeyPopup();
	}

	public void verifyAPIEvents() {
		new CommonFunctions().elementView(txtEvents, "Events");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}