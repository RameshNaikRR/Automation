package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessInformationPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDes = By.xpath("");
	private By txtCompanyName = By.xpath("");
	private By drpdwnBusinessEntity = By.xpath("");
	private By txtBusinessStartDate = By.xpath("");
	private By txtCompanyEmail = By.xpath("");
	private By txtCompanyPhoneNumber = By.xpath("");
	private By txtCompanyAddressLine1 = By.xpath("");
	private By txtCompanyAddressLine2 = By.xpath("");
	private By txtCity = By.xpath("");
	private By drpdwnState = By.xpath("");
	private By txtZipCode = By.xpath("");
	private By lblCountry = By.xpath("");
	private By chkbxDoBusiness = By.xpath("");
	private By txtDBAName = By.xpath("");
	private By txtDBAAddressLine1 = By.xpath("");
	private By txtDBAAddressLine2 = By.xpath("");
	private By lnkExit = By.xpath("");
	private By btnNext = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	public void fillCompanyName(String companyName) {
		enterText(txtCompanyName, companyName, "Company Name");
	}

	public void selectBusinessEntity() {
		click(drpdwnBusinessEntity, "Business Entity");
	}

	public void fillBusinessStartDate(String startDate) {
		enterText(txtBusinessStartDate, startDate, "Business Start Date");
	}

	public void fillCompanyEmail(String companyEmail) {
		enterText(txtCompanyEmail, companyEmail, "Company Email");
	}

	public void fillCompanyPhoneNumber(String phoneNumber) {
		enterText(txtCompanyPhoneNumber, phoneNumber, "Company Phone Number");
	}

	public void fillCompanyAddress1(String address1) {
		enterText(txtCompanyAddressLine1, address1, "Company Address Line 1");
	}

	public void fillCompanyAddress2(String address2) {
		enterText(txtCompanyAddressLine2, address2, "Company Address Line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "City");
	}

	public void selectState(String state) {
		click(drpdwnState, "State");
		By stateName = By.xpath(String.format("", state));
		click(stateName, state);
	}

	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "Zip Code");
	}

	public void verifyCountry(String expCountry) {
		new CommonFunctions().verifyLabelText(lblCountry, "Country is: ", expCountry);
	}

	public void clickDoBusiness() {
		click(chkbxDoBusiness, "Do Business");
	}

	public void fillDBAName(String dbaName) {
		enterText(txtDBAName, dbaName, "DBA Name");
	}

	public void fillDBAAddress1(String address1) {
		enterText(txtDBAAddressLine1, address1, "DBA Address Line 1");
	}

	public void fillDBAAddress2(String address2) {
		enterText(txtDBAAddressLine2, address2, "DBA Address Line 2");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}
	public AuthorizedSignersPage authorizedSignersPage() {
		return new AuthorizedSignersPage();
	}

}
