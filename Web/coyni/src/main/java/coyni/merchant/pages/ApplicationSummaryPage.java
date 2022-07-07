package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationSummaryPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h4[text()='Merchant Application Summary']");
	private By lblCompanyInformation = By.xpath("(//p[contains(text(),'Company Information')])[2]/following-sibling::*");
	private By lblDBAInformation = By.xpath("(//p[contains(text(),'DBA Name')])/following-sibling::*");
	private By lblBeneficialOwners = By.xpath("//p[contains(text(),'Beneficial Owner(s)')]");
	private By lblBank = By.xpath("//p[contains(text(),'Bank')]");
	private By btnEdit1 = By.xpath("(//button[contains(text(),'Edit')])[1]");
	private By btnEdit2 = By.xpath("(//button[contains(text(),'Edit')])[2]");
	private By btnEdit3 = By.xpath("(//button[contains(text(),'Edit')])[3]");
	private By btnEdit4 = By.xpath("(//button[contains(text(),'Edit')])[4]");
	private By lblAgreements = By.xpath("//p[text()='Agreements']");
	private By btnApplicationSummary = By.xpath("//h6[text()='Application Summary']");
	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By btnView = By.xpath("//button[text()='View']");

	public void clickEdit1() {
		click(btnEdit1, "Edit");
	}

	public void clickEdit2() {
		click(btnEdit2, "Edit");
	}

	public void clickEdit3() {
		click(btnEdit3, "Edit");
	}

	public void clickEdit4() {
		click(btnEdit4, "Edit");
	}

	public void clickView() {
		click(btnView, "View");
	}

	public void clickApplicationSummary() {
		click(btnApplicationSummary, "Application Summary");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void verifyCompanyInformation() {
		String text = getText(lblCompanyInformation, "Company Information");
		ExtentTestManager.setInfoMessageInReport("Company Information " + text);

	}

	public void verifyDBAInformation() {
		String text = getText(lblDBAInformation, "DBA Information");
		ExtentTestManager.setInfoMessageInReport("DBA Information : " + text);
	}

	public void verifyBeneficialOwners() {
		String text = getText(lblBeneficialOwners, "Beneficial Owners");
		ExtentTestManager.setInfoMessageInReport("Beneficial Owners: " + text);
	}

	public void verifyBank() {
		String text = getText(lblBank, "Bank");
		ExtentTestManager.setInfoMessageInReport("Bank: " + text);
	}

	public void verifyAgreements() {
		String text = getText(lblAgreements, "Agreements");
		ExtentTestManager.setInfoMessageInReport("Agreements: " + text);
	}

	public void clickSubmit() {
		scrollToElement(btnSubmit, "Submit");
		click(btnSubmit, "Submit");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
