package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApiKeysPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='API Keys']");

	private By lblPublicKey = By.xpath("//span[contains(text(),'Public Key:')]/following-sibling::*");

	private By btnGenerateNewSecretKey = By.xpath("//button[text()='Generate New Secret Key']");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	private By btnRevealSecretKey = By.xpath("//span[text()='Reveal Secret Key']");

	private By lblSecretKey = By.xpath("//span[text()='Secret Key']/following-sibling::*[1]");

	private By lblAPIKeyLogs = By.xpath("//span[text()='API Key Log']/following-sibling::*");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void getPublicKey() {
		new CommonFunctions().elementView(lblPublicKey, "Public Key");
		String text = getText(lblPublicKey, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);

	}

	public void getSecretKey() {
		new CommonFunctions().elementView(lblSecretKey, "Secret Key");
		String text = getText(lblSecretKey, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);

	}

	public void getAPIKeysLogs() {
		new CommonFunctions().elementView(lblAPIKeyLogs, "API Keys Log");
		String text = getText(lblAPIKeyLogs, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void clickGenerateNewSecretKey() {
		click(btnGenerateNewSecretKey, "Generate New Secret Key");
	}

	public void ClickGenerate() {
		click(btnGenerate, "Generate");
	}

	public void clickRevealSecretKey() {
		click(btnRevealSecretKey, "Secret Key");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
