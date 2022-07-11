package coyni.merchant.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.pages.BankAccountPage;
import coyni.merchant.pages.ProcessingFeesPage;
import coyni.merchant.pages.RegistrationBeneficialOwnersPage;
import coyni.merchant.pages.RegistrationStartPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantApplicationTest {
	

	SideMenuBarComponent sideMenuBarComponent;
	RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage;
	BankAccountPage bankAccountPage;
	RegistrationStartPage registrationStartPage;
	ProcessingFeesPage processingFeesPage;

	@BeforeTest
	public void init() {
		registrationBeneficialOwnersPage = new RegistrationBeneficialOwnersPage();
		bankAccountPage = new BankAccountPage();
		sideMenuBarComponent = new SideMenuBarComponent();
		registrationStartPage = new RegistrationStartPage();
		processingFeesPage = new ProcessingFeesPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwners(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// sideBarMenuComponent.clickBusinessApplicationArrow();
			sideMenuBarComponent.clickContinueApplication();
			// sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(5000);
			// sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
			sideMenuBarComponent.registrationBeneficialOwnersPage().VerifyHeading(data.get("heading"));
			//sideMenuBarComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			// sideBarMenuComponent.registrationBeneficialOwnersPage().verifyBeneficialOwnersDesc(data.get("description"));
			Thread.sleep(7000);
			String[] id = data.get("id").split(",");
			String[] expOwnerlabel = data.get("expOwnerLabels").split(",");
			String[] ownerName = data.get("ownerName").split(",");
			String[] ownerShipValue = data.get("ownerShipValue").split(",");
			String[] firstName = data.get("firstName").split(",");
			String[] lastName = data.get("lastName").split(",");
			String[] ownerShip = data.get("ownerShip").split(",");
			for (int i = 0; i < 3; i++) {
				String num = Integer.toString(i + 1);
				int num1 = i;
				// sideBarMenuComponent.registrationBeneficialOwnersPage().verifyBenificialOwner1(data.get("owner1"));
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillFirstName(firstName[i], num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillLastName(lastName[i], num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillDateOfBirth(data.get("dateOfBirth"), num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillSocialSecurityNum(data.get("ssn"), num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillOwnerShip(ownerShip[i], num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillAddress1(data.get("addline1"), num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillAddress2(data.get("addline2"), num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillCity(data.get("city"), num1);
				// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.selectState(data.get("state"), num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillZipCode(data.get("zipCode"), num1);
//				sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
//						.verifyCountry(data.get("country"));
				sideMenuBarComponent.registrationBeneficialOwnersPage().selectID(id[i], num1);
				sideMenuBarComponent.registrationBeneficialOwnersPage().uploadSelectImage(data.get("folderName"),
						data.get("fileName"), num);

				sideMenuBarComponent.registrationBeneficialOwnersPage().clickSave(num1);
				Thread.sleep(6000);
//				sideMenuBarComponent.registrationBeneficialOwnersPage().verifyBeneficialOwnerDetails(num,
//						expOwnerlabel[i], ownerName[i], data.get("ownerShipLabel"), ownerShipValue[i]);
			}
			sideMenuBarComponent.registrationBeneficialOwnersPage().clickNext();
			Thread.sleep(7000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners  failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwnersWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// sideBarMenuComponent.clickBusinessApplicationArrow();
			sideMenuBarComponent.clickContinueApplication();
			// sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(10000);
			// sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
			sideMenuBarComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillFirstName(data.get("firstName"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillLastName(data.get("lastName"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillSocialSecurityNum(data.get("ssn"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress1(data.get("addline1"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress2(data.get("addline2"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillCity(data.get("city"), 0);
			// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
			Thread.sleep(1000);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipCode"), 0);
			// Thread.sleep(1000);
			// sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent().clickCountry();
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.verifyCountry(data.get("country"));
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				if (!data.get("elementName").equalsIgnoreCase("ownership")) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
							data.get("elementName"));
				}
				if (data.get("elementName").equalsIgnoreCase("ownership")) {
					sideMenuBarComponent.registrationBeneficialOwnersPage()
							.validateBeneificalOwnersError(data.get("errMessage"), data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners Invalid Data is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccountFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// sideBarMenuComponent.clickBusinessApplicationArrow();
			sideMenuBarComponent.clickContinueApplication();
			Thread.sleep(5000);
			// sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			sideMenuBarComponent.bankAccountPage().verifyHeadingView();
			sideMenuBarComponent.bankAccountPage().verifyLabelHeading(data.get("heading"));
			// sideBarMenuComponent.bankAccountPage().VerifyAddBankAccountDesc(data.get("bankAccountDesc"));
			// sideBarMenuComponent.bankAccountPage().clickLearnMore();
			// sideBarMenuComponent.bankAccountPage().verifyFiesrvHeading(data.get("fiesrvhdg"));
			// sideBarMenuComponent.bankAccountPage().clickBack();
			Thread.sleep(5000);
			sideMenuBarComponent.bankAccountPage().clickImReady();
			sideMenuBarComponent.bankAccountPage().verifyAddBankAccountView();
			sideMenuBarComponent.bankAccountPage().verifyDoNotNavigateView();
			Thread.sleep(15000);
			sideMenuBarComponent.bankAccountPage().switchTab();
			sideMenuBarComponent.bankAccountPage().fillBankName(data.get("bankName"));
			Thread.sleep(1000);
			sideMenuBarComponent.bankAccountPage().fillUserName(data.get("userName"));
			sideMenuBarComponent.bankAccountPage().fillPassword(data.get("password1"));
			Thread.sleep(5000);
			sideMenuBarComponent.bankAccountPage().clickEnter();
			Thread.sleep(10000);
			// sideBarMenuComponent.bankAccountPage().clickBankNext();
			sideMenuBarComponent.bankAccountPage().clickChkbxBank();
			sideMenuBarComponent.bankAccountPage().clickNextButtonBank();
			// sideBarMenuComponent.bankAccountPage().clickBankNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Bank Account Flow is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialOwnersFieldValidationsFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// sideBarMenuComponent.clickBusinessApplicationArrow();
			sideMenuBarComponent.clickContinueApplication();
			// sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
			// sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
			sideMenuBarComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateFirstNameField(data.get("firstName"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateLastNameField(data.get("lastName"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateSSNField(data.get("ssn"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateAddline1Field(data.get("addline1"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateAddline2Field(data.get("addline2"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateCityField(data.get("city"));
			// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
			Thread.sleep(1000);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipCode"), 0);
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.verifyCountry(data.get("country"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Beneficial Owners Field Validations flow is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(7000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyPageDescription(data.get("startPageDescription"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			registrationStartPage.registrationCompanyInfoPage()
					.verifyPageDescription(data.get("companyInfoDescription"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.verifyCountry(data.get("country"));
			registrationStartPage.registrationCompanyInfoPage().uploadDocument(data.get("folderName"),
					data.get("fileName"), data.get("businessEntity"));

			registrationStartPage.registrationCompanyInfoPage().clickNext();
			Thread.sleep(10000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInformation failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(7000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyPageDescription(data.get("startPageDescription"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			registrationStartPage.registrationCompanyInfoPage()
					.verifyPageDescription(data.get("companyInfoDescription"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.verifyCountry(data.get("country"));
			registrationStartPage.registrationCompanyInfoPage().uploadDocument(data.get("folderName"),
					data.get("fileName"), data.get("businessEntity"));
			registrationStartPage.registrationCompanyInfoPage().removeFile(data.get("businessEntity"));
			registrationStartPage.registrationCompanyInfoPage().clickCancel();
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			Thread.sleep(10000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInformationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			// registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity();
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			new CommonFunctions().clickOutSideElement();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testCompanyInformationWithInvalidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInfoTextField(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().validateCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().validateCompanyEmail(data.get("companyEmail"));
			// registrationStartPage.registrationCompanyInfoPage().validatePhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateZipCode(data.get("zipCode"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testCompanyInfoTextField failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			registrationStartPage.registrationDBAInformationPage().verifyPageDescription(data.get("dbaDescription"));
			registrationStartPage.registrationDBAInformationPage().verifyInfo(data.get("expInfo"));
			registrationStartPage.registrationDBAInformationPage().verifyLabelYes(data.get("yesDes"));
			registrationStartPage.registrationDBAInformationPage().verifyLabelNo(data.get("noDes"));
			registrationStartPage.registrationDBAInformationPage().verifyMessage(data.get("expMessage"));
			registrationStartPage.registrationDBAInformationPage().clickExit();
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformationView failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationWithCompanyInfo(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			registrationStartPage.registrationDBAInformationPage().clickYes();
			Thread.sleep(10000);
			registrationStartPage.registrationDBAInformationPage().verifyDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAInformationPage().selectBusinessType(data.get("businessType"));
			registrationStartPage.registrationDBAInformationPage().clickeCommerce();
			registrationStartPage.registrationDBAInformationPage().verifyCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationDBAInformationPage().verifyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationDBAInformationPage().fillWebsite(data.get("website"));
			registrationStartPage.registrationDBAInformationPage()
					.fillMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			registrationStartPage.registrationDBAInformationPage().fillHighTicket(data.get("highTicket"));
			registrationStartPage.registrationDBAInformationPage().fillAverageTicket(data.get("averageTicket"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.verifyAddline1(data.get("addressline1"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.verifyAddline2(data.get("addressline2"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.verifyCity(data.get("city"));
			// registrationStartPage.registrationDBAInformationPage().mailingAddressComponent().verifyState(data.get("state"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.verifyZipCode(data.get("zipCode"));
			registrationStartPage.registrationDBAInformationPage().selectTimeZone(data.get("timezone"));
			registrationStartPage.registrationDBAInformationPage().clickBack();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformationWithCompanyInfo failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			registrationStartPage.registrationDBAInformationPage().clickNo();
			Thread.sleep(1000);
			registrationStartPage.registrationDBAInformationPage().fillDBAName(data.get("dbaName"));
			if (!data.get("elementName").equalsIgnoreCase("businessType")) {
				registrationStartPage.registrationDBAInformationPage().selectBusinessType(data.get("businessType"));
			}
			registrationStartPage.registrationDBAInformationPage().clickeCommerce();
			registrationStartPage.registrationDBAInformationPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationDBAInformationPage().fillPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationDBAInformationPage().fillWebsite(data.get("website"));
			registrationStartPage.registrationDBAInformationPage()
					.fillMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			registrationStartPage.registrationDBAInformationPage().fillHighTicket(data.get("highTicket"));
			registrationStartPage.registrationDBAInformationPage().fillAverageTicket(data.get("averageTicket"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent().fillCity(data.get("city"));
			if (!data.get("elementName").equalsIgnoreCase("state")) {
				registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
						.selectState(data.get("state"));
			}
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			if (!data.get("elementName").equalsIgnoreCase("timeZone")) {
				registrationStartPage.registrationDBAInformationPage().selectTimeZone(data.get("timezone"));
			}
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMessage").isEmpty() && !data.get("elementName").equalsIgnoreCase("businessType")
					&& !data.get("elementName").equalsIgnoreCase("state")
					&& !data.get("elementName").equalsIgnoreCase("timezone")) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty() && data.get("elementName").equalsIgnoreCase("businessType")) {
				registrationStartPage.registrationDBAInformationPage().clickBusinessTypeDropdown();
				new CommonFunctions().clickOutSideElement();
				Thread.sleep(500);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty() && data.get("elementName").equalsIgnoreCase("state")) {
				registrationStartPage.registrationDBAInformationPage().mailingAddressComponent().clickStateDropdown();
				new CommonFunctions().clickOutSideElement();
				Thread.sleep(500);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty() && data.get("elementName").equalsIgnoreCase("timeZone")) {
				registrationStartPage.registrationDBAInformationPage().clickTimeZoneDropdown();
				new CommonFunctions().clickOutSideElement();
				Thread.sleep(500);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformationWithInvalidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationFields(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			registrationStartPage.registrationDBAInformationPage().clickNo();
			Thread.sleep(10000);
			registrationStartPage.registrationDBAInformationPage().validateDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAInformationPage().selectBusinessType(data.get("businessType"));
			registrationStartPage.registrationDBAInformationPage().clickeCommerce();
			registrationStartPage.registrationDBAInformationPage()
					.validateCompanyServiceEmail(data.get("companyEmail"));
			// registrationStartPage.registrationDBAInformationPage().validatePhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationDBAInformationPage().fillWebsite(data.get("website"));
			registrationStartPage.registrationDBAInformationPage()
					.fillMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			registrationStartPage.registrationDBAInformationPage().fillHighTicket(data.get("highTicket"));
			registrationStartPage.registrationDBAInformationPage().fillAverageTicket(data.get("averageTicket"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.validateAddress1(data.get("addressline1"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.validateAddress2(data.get("addressline2"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.validateCity(data.get("city"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.validateZipCode(data.get("zipCode"));
			registrationStartPage.registrationDBAInformationPage().selectTimeZone(data.get("timezone"));
			registrationStartPage.registrationDBAInformationPage().uploadFile(data.get("folderName"),
					data.get("fileName"));
			registrationStartPage.registrationDBAInformationPage().removeFile();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformationFields failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			// registrationStartPage.registrationDBAInformationPage().clickNo();
			Thread.sleep(10000);
			registrationStartPage.registrationDBAInformationPage().fillDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAInformationPage().selectBusinessType(data.get("businessType"));
			registrationStartPage.registrationDBAInformationPage().clickeCommerce();
			registrationStartPage.registrationDBAInformationPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationDBAInformationPage().fillPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationDBAInformationPage().fillWebsite(data.get("website"));
			registrationStartPage.registrationDBAInformationPage()
					.fillMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			registrationStartPage.registrationDBAInformationPage().fillHighTicket(data.get("highTicket"));
			registrationStartPage.registrationDBAInformationPage().fillAverageTicket(data.get("averageTicket"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationDBAInformationPage().selectTimeZone(data.get("timezone"));
//			registrationStartPage.registrationDBAInformationPage().uploadFile(data.get("folderName"),
//					data.get("fileName"));
			registrationStartPage.registrationDBAInformationPage().clickNext();
			Thread.sleep(5000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDBAInformation failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantAgreements(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			// registrationStartPage.verifyMerchantApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.merchantAgreementsPage().clickMerchantAgreement();
			registrationStartPage.merchantAgreementsPage().verifyESignature(data.get("signature"));
			registrationStartPage.merchantAgreementsPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantAgreements failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationSummary(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.applicationSummaryPage().verifyCompanyInformation();
			registrationStartPage.applicationSummaryPage().getCompanyInformation();
			registrationStartPage.applicationSummaryPage().getCompanyInformationBusinessEntity();
			registrationStartPage.applicationSummaryPage().getCompanyInformationEINNumber();
			registrationStartPage.applicationSummaryPage().getCompanyInformationEmailAddress();
			registrationStartPage.applicationSummaryPage().getCompanyInformationPhoneNumber();
			registrationStartPage.applicationSummaryPage().getCompanyInformationAddress();
			registrationStartPage.applicationSummaryPage().verifyDBAInformation();
			registrationStartPage.applicationSummaryPage().getDBAInfomation();
			registrationStartPage.applicationSummaryPage().getDBAInformationEmail();
			registrationStartPage.applicationSummaryPage().getDBAInformationPhoneNumber();
			registrationStartPage.applicationSummaryPage().getDBAInformationWebsite();
			registrationStartPage.applicationSummaryPage().getDBAInformationMonthlyProcessingVolume();
			registrationStartPage.applicationSummaryPage().getDBAInformationHighTicket();
			registrationStartPage.applicationSummaryPage().getDBAInformationAverageTicket();
			registrationStartPage.applicationSummaryPage().getDBAInformationAddress();
			registrationStartPage.applicationSummaryPage().verifyBeneficialOwners();
			registrationStartPage.applicationSummaryPage().getBeneficialOwnersDropDown();
			registrationStartPage.applicationSummaryPage().getBeneficialOwnerName();
			registrationStartPage.applicationSummaryPage().getBeneficialDateOfBirth();
			registrationStartPage.applicationSummaryPage().getBeneficialSocialSecurity();
			registrationStartPage.applicationSummaryPage().getBeneficialOwnerShip();
			registrationStartPage.applicationSummaryPage().getBeneficialOwnerAddress();
			registrationStartPage.applicationSummaryPage().verifyBank();
			registrationStartPage.applicationSummaryPage().getBankDetails();
			registrationStartPage.applicationSummaryPage().verifyAgreements();
			registrationStartPage.applicationSummaryPage().getAgreementsDetails();
			registrationStartPage.applicationSummaryPage().getAgreementsSignedDetails();
			registrationStartPage.applicationSummaryPage().clickSubmit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testApplicationSummary failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationSummaryEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.applicationSummaryPage().verifyCompanyInformation();
			registrationStartPage.applicationSummaryPage().clickEdit1();
			registrationStartPage.applicationSummaryPage().clickApplicationSummary();
			registrationStartPage.applicationSummaryPage().verifyDBAInformation();
			registrationStartPage.applicationSummaryPage().clickEdit2();
			registrationStartPage.applicationSummaryPage().clickApplicationSummary();
			registrationStartPage.applicationSummaryPage().verifyBeneficialOwners();
			registrationStartPage.applicationSummaryPage().clickEdit3();
			registrationStartPage.applicationSummaryPage().clickApplicationSummary();
			registrationStartPage.applicationSummaryPage().verifyBank();
			registrationStartPage.applicationSummaryPage().clickEdit4();
			registrationStartPage.applicationSummaryPage().clickApplicationSummary();
			registrationStartPage.applicationSummaryPage().verifyAgreements();
			registrationStartPage.applicationSummaryPage().clickView();
			registrationStartPage.applicationSummaryPage().clickApplicationSummary();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testApplicationSummaryEdit failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantApplication(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationCompanyInfoPage().getCompanyInformation();
			registrationStartPage.registrationCompanyInfoPage().clickCancel();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationCompanyInfoPage().clickCompanyName();
			registrationStartPage.registrationCompanyInfoPage().clickNext();
			registrationStartPage.registrationCompanyInfoPage().clickExit();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationDBAInformationPage().clickDBAInformation();
			registrationStartPage.registrationDBAInformationPage().clickBack();
			registrationStartPage.registrationCompanyInfoPage().clickNext();
			registrationStartPage.registrationDBAInformationPage().clickExit();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.registrationBeneficialOwnersPage().clickBeneficialOwners();
			registrationStartPage.registrationBeneficialOwnersPage().clickBack();
			registrationStartPage.registrationBeneficialOwnersPage().clickNext();
			registrationStartPage.registrationBeneficialOwnersPage().clickExit();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.bankAccountPage().clickOnBankAccount();
			registrationStartPage.bankAccountPage().clickBack();
			registrationStartPage.bankAccountPage().clickBank();
			registrationStartPage.bankAccountPage().clickExit();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.merchantAgreementsPage().clickMerchantAgreements();
			registrationStartPage.merchantAgreementsPage().clickBack();
			registrationStartPage.merchantAgreementsPage().clickExit();
			registrationStartPage.clickContinueApplication();
			// registrationStartPage.merchantAgreementsPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testMerchantApplication failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationSubmission(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// registrationStartPage.verifyHeading(data.get("startPageHeading"));
			registrationStartPage.applicationSubmissionPage().verifyHeading(data.get("heading"));
			registrationStartPage.applicationSubmissionPage().verifyDescription();
			registrationStartPage.applicationSubmissionPage().verifyStatus();
			registrationStartPage.applicationSubmissionPage().clickCancelApplication();
			registrationStartPage.applicationSubmissionPage().cancelMerchantApplicationPopup().clickBack();
			registrationStartPage.applicationSubmissionPage().clickCancelApplication();
			registrationStartPage.applicationSubmissionPage().cancelMerchantApplicationPopup().clickCancelApplication();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testApplicationSubmission failed due to Exception " + e);
		}
	}
}
