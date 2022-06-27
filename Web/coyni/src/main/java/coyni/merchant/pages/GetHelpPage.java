package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetHelpPage extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By txtFirstAndLastName = By.xpath("");
	private By txtEmail = By.xpath("");
	private By txtFeedbackIssue = By.xpath("");
	private By txtIosOrAndriod = By.xpath("");
	private By slctDropDown = By.xpath("");
	private By txtAccountId = By.xpath("");
	private By drpDownPhone = By.xpath("");
	private By btnSubmit = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Coyni");
	}

	public void enterName(String name) {
		enterText(txtFirstAndLastName, name, "Name");
	}

	public void enterEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void enterFeedBack(String feedback) {
		enterText(txtFeedbackIssue, feedback, "FeedBack/issue");
	}

	public void enterModel(String Model) {
		enterText(txtIosOrAndriod, Model, "Model Type");
	}

	public void selectDropDown(String inquiryType) {
		enterText(slctDropDown, inquiryType, "Inquiry Type");
	}

	public void dropDownPhone(String phoneNum) {
		enterText(drpDownPhone, phoneNum, "Phone Num");
	}

	public void enterAccountId(String accountId) {
		enterText(txtAccountId, accountId, "Account ID");
	}

	public void clickSubmit() {
		click(btnSubmit, "Submit");
	}
}
