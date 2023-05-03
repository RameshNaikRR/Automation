package coyni.merchant.pages;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.AuthyComponent;
import coyni.merchant.components.WebhookComponent;
import coyni.merchant.popups.ApiKeysPopup;
import coyni.merchant.popups.GenerateNewSecretKeyPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class ApiKeysPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='API Keys']");

	private By lblPublicKey = By.xpath("//span[contains(text(),'Public Key:')]/following-sibling::*");

	private By btnCopyPublicKey = By.xpath("//button[contains(@class,'copy-image')]");

	// private By btnWebhooks =
	// By.xpath("(//button[contains(text(),'Webhooks')])[1]");

	private By btnWebhookss = By.xpath("(//button[contains(text(),'Webhooks')])[2]");

	// private By btnIPAddresses = By.xpath("(//button[contains(text(),'IP
	// Addresses')])[1]");

	private By btnIpAddresss = By.xpath("(//button[contains(text(),'IP Addresses')])[2]");

	private By btnCopyReavelSecretKey = By.xpath("(//button[contains(@class,'copy-image')])[2]");

	private By btnReavelSecretKey = By.xpath("//button[text()='Reveal Secret Key']");

	private By btnGenerateNewSecretKey = By.xpath("//button[text()='Generate New Secret Key']");

	private By POSIntegrationAPIKey = By.xpath("(//button[contains(text(),'API Keys')])[2]");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	private By btnRevealSecretKey = By.xpath("//span[text()='Reveal Secret Key']");

	private By btnActivekeys = By.xpath("//button[contains(text(),'Active Keys')]");

	private By btnInActiveKeys = By.xpath("//button[contains(text(),'Inactive Keys')]");

	private By btnExpiredKeys = By.xpath("//button[contains(text(),'Expired Keys')]");

	private By lblInActiveKeysData = By.xpath("//p[contains(text(),'You do not have any Inactive keys.')]");

	private By lblExpiredKeysData = By.xpath("//p[contains(text(),'You do not have any Expired keys.')]");

//	private By apikeyname = By.xpath("(//p[contains(@class,'font-bold capitalize break-all')])[1]//span");

	private By apikeyname = By.xpath("(//span)[1]");

//	private By apikeyDate = By.xpath("((//p[contains(@class,'font-bold capitalize break-all')])[1]//span)[2]");

	private By apikeyDate = By.xpath("(//span)[2]");

	private By btnWebhooks = By.xpath("(//button[contains(text(),'Webhooks')])[1]");

	private By btnIPAddresses = By.xpath("(//button[contains(text(),'IP Addresses')])[1]");

	private By btnAPIKeyss = By.xpath("(//span[contains(text(),'API Keys')])[2]");

	private By btnCOnfigure = By.xpath("(//button[contains(text(),'Configure')])[1]");

	private By btnViewAPIKey = By.xpath("//button[contains(text(),'View API Key')]");

	private By lblAPIKeyLogs = By.xpath(
			"(//div[contains(@class,'ActivityLog_logs_container')]/parent::div//div[contains(@class,'flex flex-col mb-6')])");

	private By lblSecretKey = By.xpath("//span[text()='Secret Key']/following-sibling::*[1]");

//	private By lblAPIKeyLogs = By.xpath("//span[text()='API Key Log']/following-sibling::*");

	private By lblInActiveAPIKeys = By.cssSelector(".chip__text--orange");

	private By inactiveKeyLog = By.xpath("(//p[contains(@class,'text-sm text-cgy8 font-semibold')])[1]");

	private By inActiveKeysLogs = By.xpath("//span[contains(text(),'Inactive Secret Key:')]");

	private By btneCommerceApiKeys = By.xpath("(//button[text()='API Keys'])[1]");

	private By revealSecretKey = By.xpath("//button[contains(text(),'Reveal Secret Key')]");

	private By ipaddressName = By.xpath("(//span)[1]");

//	private By apikeyDate = By.xpath("((//p[contains(@class,'font-bold capitalize break-all')])[1]//span)[2]");

	private By ipAddressDate = By.xpath("(//span)[2]");
	
	private By lblIpAddressLogs = By.xpath(
			"(//div[contains(@class,'ActivityLog_logs_container')]/parent::div//div[contains(@class,'flex flex-col mb-6')])");

	private By ipAddressLog = By.xpath("(//div[contains(@class,'flex flex-col mb-6')])[1]");

	private By apiKeyLog = By.xpath("(//div[contains(@class,'flex flex-col mb-6')])[1]");

	private By webhookLog = By.xpath("(//div[contains(@class,'flex flex-col mb-6')])[1]");

	public void clickApiKeys() {
		click(btneCommerceApiKeys, "ApiKeys");
	}

	public void clickWebhooks() {
		click(btnWebhookss, "Webhooks");
	}

	public void getListOfWebHookLogs() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> list = getElementsList(lblAPIKeyLogs, "API Key Logs");
		int size = list.size();
		System.out.println("size is " + size);
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				WebElement ele = eles.findElement(apikeyname);
				String text = ele.getText();
				WebElement ele2 = eles.findElement(apikeyDate);
				String text2 = ele.getText();
				String text1 = text + text2;
				// System.out.println("Element is " + text);
				ExtentTestManager.setInfoMessageInReport("API Keys " + text1);

			} catch (Exception e) {
				ExtentTestManager.setInfoMessageInReport("Information is " + e);
			}

		}

	}

	public void getListOfIpAddressKeyLogs() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> list = getElementsList(lblIpAddressLogs, "Ip address logs");
		int size = list.size();
		System.out.println("size is " + size);
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				WebElement ele = eles.findElement(ipaddressName);
				String text = ele.getText();
				WebElement ele2 = eles.findElement(ipAddressDate);
				String text2 = ele.getText();
				String text1 = text + text2;
				// System.out.println("Element is " + text);
				ExtentTestManager.setInfoMessageInReport("API Keys " + text1);

			} catch (Exception e) {
				ExtentTestManager.setInfoMessageInReport("Information is " + e);
			}

		}

	}

	public void clickIPAddress() {
		click(btnIpAddresss, "IP Address");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void getListOfAPIKeyLogs() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> list = getElementsList(lblAPIKeyLogs, "API Key Logs");
		int size = list.size();
		System.out.println("size is " + size);
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				WebElement ele = eles.findElement(apikeyname);
				String text = ele.getText();
				WebElement ele2 = eles.findElement(apikeyDate);
				String text2 = ele.getText();
				String text1 = text + text2;
				// System.out.println("Element is " + text);
				ExtentTestManager.setInfoMessageInReport("API Keys " + text1);

			} catch (Exception e) {
				ExtentTestManager.setInfoMessageInReport("Information is " + e);
			}

		}

	}

	public void verifyhandSymbolHighlightedApiKeys(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Api Keys"), "Api Keys");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Api Keys", cssProp, expValue, expColor);
	}

	public void clickPublicKeyCopy() {
		click(btnCopyPublicKey, "Public Key Copy");
	}

	public void clickRevealSecretKey() {
		click(revealSecretKey, "Reveal Secret Key");
	}

	public void clickSecretKeyCopy() {
		click(btnCopyReavelSecretKey, "Reavel Secret Key");
	}

	public void clickReavelSecretKey() {
		click(btnReavelSecretKey, "Reavel SecretKey");
	}

	public int verifyButtonReavelSecretKey() {
		int i = getElementsList(btnReavelSecretKey, "Reavel SecretKey").size();
		return i;
	}

	public String getPublicKey() {
		String str = getCopiedData();
		return str;
	}

	public String getInActiveAPIKeys() {
		return getText(lblInActiveAPIKeys, "API Keys InActive");
	}

	public String getSecretKey() {
		String str = getCopiedData();
		return str;

	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(getInActiveAPIKeys());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Number of" + count
					+ " InActive API Keys in table matches with number of InActive API Keys selected");
		} else {
			ExtentTestManager.setWarningMessageInReport("Number of" + count
					+ " InActive API Keys in table doesn't matches with number of InActive API Keys selected");
		}
	}

	public void getListOfInActiveAPIKeys() {

		List<WebElement> list = getElementsList(inActiveKeysLogs, "InActive Key Logs");
		int size = list.size();
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				WebElement ele = eles.findElement(inactiveKeyLog);
				String text = ele.getText();
				ExtentTestManager.setInfoMessageInReport("API Inactive Keys " + text);

			} catch (Exception e) {
				ExtentTestManager.setInfoMessageInReport("Information is " + e);
			}

		}
	}

	public void clickOnWebHooks() {
		click(btnWebhooks, "Webhooks");
	}

	public void clickInActiveKeys() {
		click(btnInActiveKeys, "In Active");
	}

	public void clickExpiredKeys() {
		click(btnExpiredKeys, "Expired");
	}

	public String getInActiveKeysData() {
		String text = getText(lblInActiveKeysData, "InActive Keys ");
		return text;
	}

	public String getExpiredKeysData() {
		String text = getText(lblExpiredKeysData, "Expired Keys ");
		return text;
	}

	public void clickApiKeysEcommerce() {
		click(btneCommerceApiKeys, "ApiKeys");
	}

	public void clickOnAPIKeyss() {
		click(btnAPIKeyss, "API Keyss");
	}

	public void clickOnIpAddress() {
		click(btnIPAddresses, "IP Address");
	}

	public void clickOnViewAPIKey() {
		click(btnViewAPIKey, "API Keys");
	}

	public void clickOnConfigure() {
		click(btnCOnfigure, "Configure");
	}

	public void clickOnPOSIntegrationAPIKeys() {
		click(POSIntegrationAPIKey, "POS Integration Key");
	}

	public void clickActiveKeys() {
		click(btnActivekeys, "Active");
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

	public void getIPAddressLog() throws InterruptedException {
		Thread.sleep(5000);
		ExtentTestManager.setInfoMessageInReport("IP Address Log is " + getText(ipAddressLog, "IP Address"));

	}

	public void getWebHookLog() throws InterruptedException {
		Thread.sleep(5000);
		ExtentTestManager.setInfoMessageInReport("Webhook Log is " + getText(webhookLog, "WebHook Log"));

	}

	public void getAPIKeyLog() throws InterruptedException {
		Thread.sleep(5000);
		ExtentTestManager.setInfoMessageInReport("API Key Log is" + getText(apiKeyLog, "API key"));

	}

	public GenerateNewSecretKeyPopup generateNewSecretKeyPopup() {
		return new GenerateNewSecretKeyPopup();
	}

	public IPAddressPage ipAddressPage() {
		return new IPAddressPage();
	}

	public ApiKeysPopup apiKeysPopup() {
		return new ApiKeysPopup();
	}

	public WebhookComponent webhookComponent() {
		return new WebhookComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
