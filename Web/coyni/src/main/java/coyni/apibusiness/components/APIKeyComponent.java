package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.api.business.popups.GenerateNewSecretKeyPopup;
import coyni.api.business.popups.SecretKeyPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class APIKeyComponent extends BrowserFunctions {
	private By lblApiKey = By.xpath("(//span[text()='API Keys'])[2]");
	private By lnkGenerateSecretKey = By.xpath("//button[text()='Generate New Secret Key']");
	private By iconCopy = By.xpath("//button[contains(@class,'cop')]");
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

	private By active(String active) {
		return By.xpath(String.format("(//div[@class='chip__text--green  '])[%s]", active));
	}

	private By inactive(String inactive) {
		return By.xpath(String.format("(// div[@class='chip__text--orange '])[%s]", inactive));
	}

	private By deactivate(String inactive) {
		return By.xpath(String.format("(//p[text()='Deactivated On: '])[%s]", inactive));
	}

	private By createdDate(String date) {
		return By.xpath(String.format("(//p[@class='text-xs font-bold text-cgy4 ml-14'])[%s]", date));
	}

	public void verifyAPIKey(String expHeading) {
		new CommonFunctions().verifyLabelText(lblApiKey, "API Keys", expHeading);
	}

	public void clickGenerateApiKey() {
		new CommonFunctions().verifyCursorAction(lnkGenerateSecretKey, "Generate Secret Key");
		new CommonFunctions().verifyTextUnderLine(lnkGenerateSecretKey, "Generate Secret Key");
		String str = getElement(lnkGenerateSecretKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lnkGenerateSecretKey, "Generate Secret Key");

	}

	public void clickCopy() {
		click(iconCopy, "Copy");
	}

	public void clickRevealSecretKey() {
		new CommonFunctions().verifyCursorAction(btnrevealSecretKey, "Reveal Secret Key");
//		new CommonFunctions().verifyRevealSecretKeyView(btnrevealSecretKey, "Reveal Secret Key");
		String str = getElement(btnrevealSecretKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(btnrevealSecretKey, "Reveal Key");
		new CommonFunctions().elementView(createdDate("1"), "Date");
	}

	public void clickHideSecretKey() {
		new CommonFunctions().verifyCursorAction(lblHideSecretKey, "Hide Secret Key");
		String str = getElement(lblHideSecretKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lblHideSecretKey, "Hide Secret Key");
		new CommonFunctions().elementView(createdDate("2"), "Date");
	}

	public void verifyCopy() {
		new CommonFunctions().elementView(iconCopy, "Copied to ClipBoard");
	}

	public void verifyLblPublicKey() {
		new CommonFunctions().verifyCursorAction(lblPublicKey, "Public Key");
		String str = getElement(lblPublicKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(lblPublicKey, "Public Key");
		String str1 = getElement(active("1"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str1);
		new CommonFunctions().elementView(active("1"), "Active");
	}

	public void verifyPublicKey() {
		new CommonFunctions().elementView(publicKey, "Public Key");
	}

	public void verifyLblSecretKey() {
		new CommonFunctions().verifyCursorAction(lblSecretKey, "Secret Key");
		String str = getElement(lblSecretKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(lblSecretKey, "Secret Key");
		String str1 = getElement(active("2"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str1);
		new CommonFunctions().elementView(active("2"), "Active");
	}

	public void verifySecretKey() {
		new CommonFunctions().elementView(secretKey, "Secret Key");
	}

	public void verifyInactiveSecretKey() {
		new CommonFunctions().verifyCursorAction(lblInactiveSecretKey, "In Active Secret Key");
		String str = getElement(lblInactiveSecretKey, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(lblInactiveSecretKey, "Inactive Secret Key");
		new CommonFunctions().elementView(deactivate("1"), "Deactivated On");
		String str1 = getElement(inactive("1"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str1);
		new CommonFunctions().elementView(inactive("1"), "Inactive");
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