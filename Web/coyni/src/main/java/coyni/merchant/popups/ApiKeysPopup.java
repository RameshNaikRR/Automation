package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ApiKeysPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='API Keys']");

	private By lblPublicKey = By.xpath("(//p[contains(text(),'Public Key:')]/following-sibling::*)[2]");

	private By btnCopyReavelSecretKey = By.xpath("(//button[contains(@class,'copy-image')])[2]");

	private By revealSecretKey = By.xpath("//button[contains(text(),'Reveal Secret Key')]");

	private By btnGenerateNewSecretKey = By.xpath("//button[contains(text(),'Generate New Key')]");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	private By btnActivekeys = By.xpath("//button[contains(text(),'Active Keys')]");

	private By btnInActiveKeys = By.xpath("//button[contains(text(),'Inactive Keys')]");

	private By btnExpiredKeys = By.xpath("//button[contains(text(),'Expired Keys')]");

	public void clickActiveKeys() {
		click(btnActivekeys, "Active");
	}

	public void clickRevealSecretKey() {
		click(revealSecretKey, "Reveal Secret Key");
	}

	public void clickInActiveKeys() {
		click(btnInActiveKeys, "In Active");
	}

	public void clickExpiredKeys() {
		click(btnExpiredKeys, "Expired");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void clickSecretKeyCopy() {
		click(btnCopyReavelSecretKey, "Reavel Secret Key");
	}

	public void clickReavelSecretKey() {
		click(revealSecretKey, "Reveal SecretKey");
	}

	public String getPublicKey() {
		String str = getCopiedData();
		return str;
	}

	public String getSecretKey() {
		String str = getCopiedData();
		return str;

	}

	public void clickGenerateNewSecretKey() {
		click(btnGenerateNewSecretKey, "Generate New Secret Key");
	}

	public void ClickGenerate() {
		click(btnGenerate, "Generate");
	}

	public GenerateNewSecretKeyPopup generateNewSecretKeyPopup() {
		return new GenerateNewSecretKeyPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
