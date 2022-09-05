package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.GenerateNewSecretKeyPopup;
import coyni.api.business.popups.SecretKeyPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class APIKeyComponent extends BrowserFunctions {
	private By lblApiKey = By.xpath("(//span[text()='API Keys'])[2]");
	private By lnkGenerateAPiKey = By.xpath("//button[text()='Generate New Secret Key']");
	private By iconCopy = By.xpath("//button[@data-event='click']");
	private By btnrevealSecretKey = By.xpath("(//span[contains(@class,'ApiKeys_reveal_secret_key__RA4a1')])[1]");
	private By lblPublicKey = By.xpath("//span[text()='Public Key:']");
	private By publicKey = By.xpath("//span[text()='Public Key:']/following-sibling::div[1]");
	private By lblSecretKey = By.xpath("//span[text()='Secret Key']");
	private By secretKey = By.xpath("//span[text()='Secret Key']/following-sibling::div[1]");
	private By lblInactiveSecretKey = By.xpath("");
	private By lblHideSecretKey = By.xpath("(//span[contains(@class,'ApiKeys_hide_secret_key__au2CL')])[1]");
	private By txtEvents = By.xpath("(//span[@class='text-xs font-bold text-cgy3']//text())[1]");

	public void verifyAPIKey(String expHeading) {
		new CommonFunctions().verifyLabelText(lblApiKey, "API Keys", expHeading);
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

	public void verifyLblPublicKey() {
		new CommonFunctions().elementView(lblPublicKey, "Public Key");
	}

	public void verifyPublicKey() {
		new CommonFunctions().elementView(publicKey, "Public Key");
	}

	public void verifyLblSecretKey() {
		new CommonFunctions().elementView(lblSecretKey, "Secret Key");
	}

	public void verifySecretKey() {
		new CommonFunctions().elementView(secretKey, "Secret Key");
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

	public GenerateNewSecretKeyPopup generateNewSecretKeyPopup() {
		return new GenerateNewSecretKeyPopup();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}