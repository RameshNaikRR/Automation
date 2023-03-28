package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationSubmissionPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h4");
	private By lblDesc = By.xpath("//p[contains(text(),'Please review your')]");
	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By viewAppSummary = By.xpath("//div[@class='ApplicationSummary_dataInfoColumn__wWHAm']");
	private By ViewAppHeading = By
			.xpath("//p[@class='ml-4 text-cgy4 font-bold ApplicationSummary_companyInfo__X+fSY']");
	private By chckbox = By.xpath("//input[@type='checkbox']");
	private By agreementSign = By.xpath("//textarea[contains(@class,'ApplicationSummary_fontStyle__oM7ra')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Business Application Summary", expHeading);
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDesc, "Description", description);
	}

	public void clickSubmit() {
		if (getElement(btnSubmit, "Submit").isEnabled()) {
			click(btnSubmit, "Submit ");
		} else {
			ExtentTestManager.setPassMessageInReport("Submit button is in disabled mode");
		}
	}

	public void clickCheckBox() {
		click(chckbox, "CheckBox");
	}

	public void SignOnSubmission(String sign) {
		enterText(agreementSign, sign, "signature");
	}

	public void verifyAppSummary() {
		List<WebElement> rows = getElementsList(viewAppSummary, " ");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyAppStepHeading() {
		List<WebElement> rows = getElementsList(ViewAppHeading, " ");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

}
