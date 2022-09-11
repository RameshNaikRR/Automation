package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RegistrationAgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h4[text()='Agreements']");
	private By lblDesc = By.xpath("//p[contains(text(),'before you submit your')]");
	private By agreementSign = By.xpath("//div[@contenteditable='true']");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By btnAgree = By.xpath("//button[text()='Agree']");
	private By btnNext=By.xpath("//button[text()='Next']");
	private By clickBusinessAgreementView = By.xpath("(//button[text()='View'])[1]");
	private By clickPrivacyPolicyView = By.xpath("(//button[text()='View'])[2]");
	private By clickTermsOfService = By.xpath("(//button[text()='View'])[3]");

	public By getAgreementsView(String Agreements) {
		return By.xpath(String.format("(//button[text()='View'])[%s]", "Agreements"));
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyAgreementsDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDesc, "Description", description);
	}

	public void clickBusinessAgreement() {
		click(clickBusinessAgreementView, "Business Agreements");
	}

	public void clickPrivacyPolicy() {
		click(clickPrivacyPolicyView, "Privacy Policy");
	}

	public void clickTermsOfServices() {
		click(clickTermsOfService, "Terms Of Services");
	}

	public void AgreementSign(String sign) {
		enterText(agreementSign, sign, "Business Agreement");
	}

	public void clickSave() {
		if (getElement(btnSave, "Next").isEnabled()) {
			click(btnSave, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Save button is in disabled mode");
		}
	}

	public void clickAgree() {
		if (getElement(btnAgree, "Agree").isEnabled()) {
			click(btnAgree, "Agree ");
		} else {
			ExtentTestManager.setPassMessageInReport("Agree button is in disabled mode");
		}
	}
	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void clickCheckBox() {
		click(checkbox, "checkbox");
	}
}