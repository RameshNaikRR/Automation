package coyni.merchant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationSummaryPage extends BrowserFunctions {
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 120);

	private By lblHeading = By.xpath("//h4[text()='Merchant Application Summary']");
	private By lblCompanyInformation = By
			.xpath("(//p[contains(text(),'Company Information')])[2]/following-sibling::*");
	private By lblBusinessEntity = By.xpath("(//p[contains(text(),'Business Entity')])/following-sibling::*");
	private By lblEINNumber = By.xpath("(//p[contains(text(),'EIN')])/following-sibling::*");
	private By lblEmailAddress = By.xpath("(//p[contains(text(),'Email Address')])/following-sibling::*");
	private By lblPhoneNumber = By.xpath("(//p[contains(text(),'Phone Number')])/following-sibling::*");
	private By lblAddressCompany = By.xpath("(//p[text()='Address'])[1]/following-sibling::*");
	private By lblDBAInformation = By.xpath("(//p[contains(text(),'DBA Name')])/following-sibling::*");
	private By lblBusinessType = By.xpath("(//p[contains(text(),'Business Type')])/following-sibling::*");
	private By lblCustomerServiceEmail = By
			.xpath("(//p[contains(text(),'Customer Service Email')])/following-sibling::*");
	private By lblCustomerServicePhone = By
			.xpath("(//p[contains(text(),'Customer Service Phone')])/following-sibling::*");
	private By lblWebsite = By.xpath("(//p[contains(text(),'Website')])/following-sibling::*");
	private By lblMonthlyProcessingVolume = By.xpath("(//p[contains(text(),'Monthly')])/following-sibling::*");
	private By lblHighTicket = By.xpath("(//p[contains(text(),'High')])/following-sibling::*");
	private By lblAverageTicket = By.xpath("(//p[contains(text(),'Average')])/following-sibling::*");
	private By lblAddressDBA = By.xpath("(//p[text()='Address'])[2]/following-sibling::*");
	private By lblBeneficialOwners = By.xpath("//p[contains(text(),'Beneficial Owner(s)')]");
	private By lblDrpDwn = By.xpath("//button[contains(@class,'BenificialOwnerAccordion_accordion_caret__yzIu2')]");
	private By lblBeneficialOwnerName = By.xpath("(//span[contains(text(),'Name')])/following-sibling::*");
	private By lblDateOfBirth = By.xpath("(//span[contains(text(),'Date of Birth')])/following-sibling::*");
	private By lblSocialSecurityNumber = By.xpath("(//span[contains(text(),'Social')])/following-sibling::*");
	private By lblOwnership = By.xpath("(//span[contains(text(),'Ownership')])/following-sibling::*");
	private By lblBeneficialAddress = By.xpath("(//span[contains(text(),'Address')])/following-sibling::*");
	private By lblIdentification = By.xpath("(//span[contains(text(),'Identification')])/following-sibling::*");
	private By lblBank = By.xpath("//p[contains(text(),'Bank')]");
	private By lblBankInfo = By.xpath("(//p[contains(text(),'CashEdge')])[1]");
	private By btnEdit1 = By.xpath("(//button[contains(text(),'Edit')])[1]");
	private By btnEdit2 = By.xpath("(//button[contains(text(),'Edit')])[2]");
	private By btnEdit3 = By.xpath("(//button[contains(text(),'Edit')])[3]");
	private By btnEdit4 = By.xpath("(//button[contains(text(),'Edit')])[4]");
	private By lblAgreements = By.xpath("//p[text()='Agreements']");
	private By lblAgreementsInfo = By.xpath("//span[contains(text(),'Merchant Agreement')]/following-sibling::*");
	private By lblAgreementsSigned = By.xpath("//span[contains(text(),'Signed On:')]");
	private By btnApplicationSummary = By.xpath("//h6[text()='Application Summary']");
	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By btnView = By.xpath("//button[text()='View']");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By lblMerchantAgreements = By.xpath("//span[contains(text(),'Merchant Agreement')]");
	private By done = By.xpath("(//button[contains(text(),'Done')])[2]");
	private By popupPDF = By.xpath("//div[contains(@class,'AgreementModal_apiData__xVMmx')]");

	public void clickEdit1() {
		click(btnEdit1, "Edit");
	}

	public void clickEdit2() {
		click(btnEdit2, "Edit");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void clickMerchantAgreementsDone() {
		click(done, "Done");
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

	public void getCompanyInformation() {
		String text = getText(lblCompanyInformation, "Company Information");
		ExtentTestManager.setInfoMessageInReport("Company Information " + text);
	}

	public void getCompanyInformationBusinessEntity() {
		String text = getText(lblBusinessEntity, "Business Entity");
		ExtentTestManager.setInfoMessageInReport("Business Entity " + text);
	}

	public void getCompanyInformationEINNumber() {
		String text = getText(lblEINNumber, "EIN Number");
		ExtentTestManager.setInfoMessageInReport("EIN Number" + text);
	}

	public void getCompanyInformationEmailAddress() {
		String text = getText(lblEmailAddress, "Email Address");
		ExtentTestManager.setInfoMessageInReport("Email Address" + text);
	}

	public void getCompanyInformationPhoneNumber() {
		String text = getText(lblPhoneNumber, "Phone Number");
		ExtentTestManager.setInfoMessageInReport("Phone Number" + text);
	}

	public void getCompanyInformationAddress() {
		String text = getText(lblAddressCompany, "Address");
		ExtentTestManager.setInfoMessageInReport("Address" + text);
	}

	public void getDBAInfomation() {
		String text = getText(lblBusinessType, "Business Type");
		ExtentTestManager.setInfoMessageInReport("Business Type" + text);
	}

	public void getDBAInformationEmail() {
		String text = getText(lblCustomerServiceEmail, "Customer Service Email");
		ExtentTestManager.setInfoMessageInReport("Customer Service Email" + text);
	}

	public void getDBAInformationPhoneNumber() {
		String text = getText(lblCustomerServicePhone, "Phone Number");
		ExtentTestManager.setInfoMessageInReport("Phone Number" + text);
	}

	public void getDBAInformationWebsite() {
		String text = getText(lblWebsite, "Website");
		ExtentTestManager.setInfoMessageInReport("Website" + text);
	}

	public void getDBAInformationMonthlyProcessingVolume() {
		String text = getText(lblMonthlyProcessingVolume, "Monthly Processing Volume");
		ExtentTestManager.setInfoMessageInReport("Monthly Processing Volume" + text);
	}

	public void getDBAInformationHighTicket() {
		String text = getText(lblHighTicket, "High Ticket ");
		ExtentTestManager.setInfoMessageInReport("High Ticket " + text);
	}

	public void getDBAInformationAverageTicket() {
		String text = getText(lblAverageTicket, "Average Ticket ");
		ExtentTestManager.setInfoMessageInReport("Average Ticket " + text);
	}

	public void getDBAInformationAddress() {
		String text = getText(lblAddressDBA, "Address");
		ExtentTestManager.setInfoMessageInReport("Address" + text);
	}

	public void getBeneficialOwnersDropDown() {
		String text = getText(lblDrpDwn, "Drop Down");
		ExtentTestManager.setInfoMessageInReport("Drop Down" + text);
	}

	public void getBeneficialOwnerName() {
		String text = getText(lblBeneficialOwnerName, "Beneficial Owner Name");
		ExtentTestManager.setInfoMessageInReport("Beneficial Owner Name" + text);
	}

	public void getBeneficialDateOfBirth() {
		String text = getText(lblBeneficialOwnerName, "Beneficial Owner Name");
		ExtentTestManager.setInfoMessageInReport("Beneficial Owner Name" + text);
	}

	public void getBeneficialSocialSecurity() {
		String text = getText(lblSocialSecurityNumber, "Social Secuirty");
		ExtentTestManager.setInfoMessageInReport("Beneficial Owner Name" + text);
	}

	public void getBeneficialOwnerShip() {
		String text = getText(lblOwnership, "OwnerShip");
		ExtentTestManager.setInfoMessageInReport("Beneficial Owner Name" + text);
	}

	public void getBeneficialOwnerAddress() {
		String text = getText(lblBeneficialAddress, "Beneficial Address");
		ExtentTestManager.setInfoMessageInReport("Beneficial Address" + text);
	}

	public void getBankDetails() {
		String text = getText(lblBankInfo, "Bank");
		ExtentTestManager.setInfoMessageInReport("Bank" + text);

	}

	public void getAgreementsDetails() {
		String text = getText(lblAgreementsInfo, "Agreements");
		ExtentTestManager.setInfoMessageInReport("Agreements" + text);

	}

	public void getAgreementsSignedDetails() {
		String text = getText(lblAgreementsSigned, "Agreements Signed");
		ExtentTestManager.setInfoMessageInReport("Agreements" + text);

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

	public void scrollDownPrivacyPolicy() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblMerchantAgreements));
		WebElement ele = getElement(popupPDF, "");
		int height = ele.getSize().getHeight();
		int temp = height;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(done, "");
		while (!element.isEnabled()) {
			js.executeScript("arguments[0].scrollTop = arguments[1]", ele, height);
			height += temp;
			Thread.sleep(200);
		}
		clickMerchantAgreementsDone();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
