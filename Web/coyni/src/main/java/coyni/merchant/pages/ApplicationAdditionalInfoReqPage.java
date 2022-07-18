package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.popups.DeclineReserveRulePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class ApplicationAdditionalInfoReqPage extends BrowserFunctions {

	private By lblAdditionalReqDescription = By
			.xpath("//h1[contains(text(),'Merchant Application Additional Documentation')]");

	private By lblStatus = By.xpath("//span[contains(text(),'Additional Info')]");

	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");

	private By lblDBAWebsite = By.xpath("(//button[text()='Approve'])[1]");

	private By lblBeneficialOwners = By.xpath("(//button[text()='Approve'])[2]");

	private By lnkUploadImg = By.xpath(
			"(//div[contains(@class,'BeneficialOwners_owners_wrap')]/details)[1]//p[text()='Select Identification to Upload:']/../following-sibling::*[1]/input");

	public void verifyAdditionalInfoRequiredDescription() {
		String text = getText(lblAdditionalReqDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("Status " + text);

	}

	public void clickDBA() {
		click(lblDBAWebsite, "DBA Website Approved");
	}

	public void clickBeneficialOwners() {
		click(lblBeneficialOwners, "Beneficial Owenrs Approved");
	}

	private By getUploadDocumentElement(String num) {
		return By.xpath(String.format("(//div[contains(@class,'justify-center')])[%s]", num));
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	// added
	public void getMerchantTrackerApplication() {
		new CommonFunctions().verifyCursorAction(merchnatApplicationTracker, "Notification ");
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickUploadImage() {
		click(lnkUploadImg, "Upload Image");
	}

}
