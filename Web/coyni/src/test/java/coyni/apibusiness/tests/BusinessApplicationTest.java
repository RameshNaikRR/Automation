package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.BankAccountPage;
import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessApplicationTest {
	SideBarMenuComponent sideBarMenuComponent;
	RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage;
	BankAccountPage bankAccountPage;

	@BeforeTest
	public void init() {
		registrationBeneficialOwnersPage = new RegistrationBeneficialOwnersPage();
		bankAccountPage = new BankAccountPage();
		sideBarMenuComponent = new SideBarMenuComponent();
	}

	@Test
	@Parameters({ "String strParams" })
	public void testBeneficialsOwnersFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyFirstNameView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyLastNameView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyDOBView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifySSNView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyOwnershipView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyAddressLine1View();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyAddressLine2View();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyCityView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyDrpdwnStateView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().verifyZipCodeView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().verifyUploadRequiredDocumentsView();
			sideBarMenuComponent.registrationBeneficialOwnersPage().verifyDriverLicenseView(data.get("driverLicense"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().verifyStateIssueIDView(data.get("StateIssueId"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().verifyPassportView(data.get("passport"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillFirstName(data.get("firstName"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().fillLastName("lastName");
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillDateOfBirth(data.get("dateOfBirth"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillSocialSecurityNum(data.get("ssn"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillOwnerShip(data.get("ownerShip"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillAddress1(data.get("addline1"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillAddress2(data.get("addline2"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillCity(data.get("state"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.selectState(data.get("state"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
					.verifyCountry(data.get("country"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().clickRadioBtn(data.get("radioButton"));
			// sideBarMenuComponent.registrationBeneficialOwnersPage().clickUploadImg();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners flow failed due to Exception " + e);
		}

	}

	public void testBankAccountFlow() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			sideBarMenuComponent.bankAccountPage().verifyHeadingView();
			sideBarMenuComponent.bankAccountPage().verifyLabelHeading(data.get("heading"));
			sideBarMenuComponent.bankAccountPage().VerifyAddBankAccountDesc(data.get("bankAccountDesc"));
			sideBarMenuComponent.bankAccountPage().clickLearnMore();
			sideBarMenuComponent.bankAccountPage().verifyFiesrvHeading(data.get("fiesrvhdg"));
			sideBarMenuComponent.bankAccountPage().clickBack();
			sideBarMenuComponent.bankAccountPage().clickImReady();
			sideBarMenuComponent.bankAccountPage().verifyAddBankAccountView();
			sideBarMenuComponent.bankAccountPage().verifyDoNotNavigateView();
			
																																

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Bank Account Flow is failed due to Exception " + e);
		}

	}

}
