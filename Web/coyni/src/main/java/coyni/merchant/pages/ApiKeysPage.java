package coyni.merchant.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class ApiKeysPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='API Keys']");

	private By lblPublicKey = By.xpath("//span[contains(text(),'Public Key:')]/following-sibling::*");
	
	private By btnCopyPublicKey = By.xpath("//button[contains(@class,'copy-image')]");
	
	private By btnCopyReavelSecretKey = By.xpath("(//button[contains(@class,'copy-image')])[2]");
	
	private By btnReavelSecretKey = By.xpath("//button[text()='Reveal Secret Key']");

	private By btnGenerateNewSecretKey = By.xpath("//button[text()='Generate New Secret Key']");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	private By btnRevealSecretKey = By.xpath("//span[text()='Reveal Secret Key']");

	private By lblSecretKey = By.xpath("//span[text()='Secret Key']/following-sibling::*[1]");

	private By lblAPIKeyLogs = By.xpath("//span[text()='API Key Log']/following-sibling::*");

	private By lblInActiveAPIKeys = By.cssSelector(".chip__text--orange");
	
	private By btneCommerceApiKeys = By.xpath("(//button[text()='API Keys'])[1]");

	public void clickApiKeys() {
		click(btneCommerceApiKeys, "ApiKeys");
	}
	
	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedApiKeys(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Api Keys"), "Api Keys");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Api Keys", cssProp, expValue, expColor);
	}

	public void clickPublicKeyCopy() {
		click(btnCopyPublicKey, "Public Key Copy");
	}
	
	public void clickSecretKeyCopy() {
		click(btnCopyReavelSecretKey, "Reavel Secret Key");
	}

	public void clickReavelSecretKey() {
		click(btnReavelSecretKey, "Reavel SecretKey");
	}
	
	public int verifyButtonReavelSecretKey(){
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


	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
