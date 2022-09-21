package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.reporter.ExtentReporter;

import coyni.api.business.popups.GenerateNewSecretKeyPopup;
import coyni.api.business.popups.SecretKeyPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentManager;
import ilabs.api.reporting.ExtentTestManager;

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
	private By apiEvents = By.xpath(
			"//div[@class='flex items-center justify-between pl-6 pr-4 mb-4 pb-4 ApiKeys_border_bottom__Whqjj']");
	private By txtEvents = By.xpath("//span[@class='text-xs font-bold text-cgy3']");

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
		List<WebElement> rows = getElementsList(apiEvents, "API Events");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyAPICount() {
		String events = getText(txtEvents, "No of Events");
		ExtentTestManager.setInfoMessageInReport(events + " is displayed");
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