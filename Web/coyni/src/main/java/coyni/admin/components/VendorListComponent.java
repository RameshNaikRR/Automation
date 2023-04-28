package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class VendorListComponent extends BrowserFunctions {

	private By btnMerchant = By.xpath("//button[text()='Merchants']");
	private By btnApiKey = By.xpath("//button[text()='API Keys']");

	private By getMerchantName = By.xpath("//div[contains(@class,'MerchantsVendor_merchants_container__xtOcU')]");
	private By btnVendor = By.xpath("(//div[contains(@class,'flex justify-between mb-6')])[2]");

	public void clickVendor() {
		click(btnVendor, "Vendor");
	}

	public void clickMerchant() {
		click(btnMerchant, "Merchant");
	}

	public void clickApiKey() {
		click(btnApiKey, "ApiKey");
	}

	public void getMerchantName() {
		if (getElement(getMerchantName, "MerchantName").isDisplayed()) {
			ExtentTestManager.setInfoMessageInReport(getText(getMerchantName, "Assign MerchantName"));
		} else {
			ExtentTestManager.setWarningMessageInReport("Merchant is not assigned to the vendor");
		}
	}

	public ApiKeysComponent apiKeysComponent() {
		return new ApiKeysComponent();
	}

	public EditVendorComponent editVendorComponent() {
		return new EditVendorComponent();
	}
	public DeacttivateVendor deacttivateVendor() {
		return new DeacttivateVendor();
	}
}
