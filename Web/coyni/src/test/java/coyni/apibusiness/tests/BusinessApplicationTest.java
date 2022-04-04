package coyni.apibusiness.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.BankAccountPage;
import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import coyni.uitilities.CommonFunctions;
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
	@Parameters({ "strParams" })
	public void testBeneficialsOwners(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(5000);
			// sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
			sideBarMenuComponent.registrationBeneficialOwnersPage().VerifyHeading(data.get("heading"));
		//	sideBarMenuComponent.registrationBeneficialOwnersPage().verifyBeneficialOwnersDesc(data.get("description"));
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
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillFirstName(firstName[i],num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillLastName(lastName[i],num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillDateOfBirth(data.get("dateOfBirth"),num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillSocialSecurityNum(data.get("ssn"),num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillOwnerShip(ownerShip[i],num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillAddress1(data.get("addline1"),num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillAddress2(data.get("addline2"),num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillCity(data.get("city"),num1);
				// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.selectState(data.get("state"),num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
						.fillZipCode(data.get("zipcode"),num1);
//				sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent()
//						.verifyCountry(data.get("country"));
				sideBarMenuComponent.registrationBeneficialOwnersPage().selectID(id[i],num1);
				sideBarMenuComponent.registrationBeneficialOwnersPage().uploadSelectImage(data.get("folderName"),
						data.get("fileName"), num);
				
				sideBarMenuComponent.registrationBeneficialOwnersPage().clickSave(num1);
				Thread.sleep(6000);
				sideBarMenuComponent.registrationBeneficialOwnersPage().verifyBeneficialOwnerDetails(num,
						expOwnerlabel[i], ownerName[i], data.get("ownerShipLabel"), ownerShipValue[i]);
			}
			sideBarMenuComponent.registrationBeneficialOwnersPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners flow failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwnersWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
		//	sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
		//	sideBarMenuComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillFirstName(data.get("firstName"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillLastName(data.get("lastName"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillSocialSecurityNum(data.get("ssn"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress1(data.get("addline1"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress2(data.get("addline2"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillCity(data.get("city"),0);
			// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
			Thread.sleep(1000);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipcode"),0);
		//	Thread.sleep(1000);
		//	sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent().clickCountry();
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.verifyCountry(data.get("country"));
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				if (!data.get("elementName").equalsIgnoreCase("ownership")) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
							data.get("elementName"));
				}
				if (data.get("elementName").equalsIgnoreCase("ownership")) {
					sideBarMenuComponent.registrationBeneficialOwnersPage()
							.validateBeneificalOwnersError(data.get("errMessage"), data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners Negative Flow is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBankAccountFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			sideBarMenuComponent.bankAccountPage().verifyHeadingView();
			sideBarMenuComponent.bankAccountPage().verifyLabelHeading(data.get("heading"));
		//	sideBarMenuComponent.bankAccountPage().VerifyAddBankAccountDesc(data.get("bankAccountDesc"));
			sideBarMenuComponent.bankAccountPage().clickLearnMore();
			sideBarMenuComponent.bankAccountPage().verifyFiesrvHeading(data.get("fiesrvhdg"));
			sideBarMenuComponent.bankAccountPage().clickBack();
			Thread.sleep(5000);
			sideBarMenuComponent.bankAccountPage().clickImReady();
			sideBarMenuComponent.bankAccountPage().verifyAddBankAccountView();
			sideBarMenuComponent.bankAccountPage().verifyDoNotNavigateView();
			Thread.sleep(15000);
			sideBarMenuComponent.bankAccountPage().switchTab();
			sideBarMenuComponent.bankAccountPage().fillBankName(data.get("bankName"));
			Thread.sleep(1000);
			sideBarMenuComponent.bankAccountPage().fillUserName(data.get("userName"));
			sideBarMenuComponent.bankAccountPage().fillPassword(data.get("password1"));
			Thread.sleep(5000);
			sideBarMenuComponent.bankAccountPage().clickEnter();
			Thread.sleep(10000);
		//	sideBarMenuComponent.bankAccountPage().clickBankNext();
			sideBarMenuComponent.bankAccountPage().clickChkbxBank();
			sideBarMenuComponent.bankAccountPage().clickEnter();
		//	sideBarMenuComponent.bankAccountPage().clickBankNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Bank Account Flow is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialOwnersFieldValidationsFlow(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessApplicationArrow();
			sideBarMenuComponent.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
		//	sideBarMenuComponent.registrationSideBarMenuComponent().clickBeneficialOwners();
		//	sideBarMenuComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateFirstNameField(data.get("firstName"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateLastNameField(data.get("lastName"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateSSNField(data.get("ssn"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateAddline1Field(data.get("addline1"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateAddline2Field(data.get("addline2"));
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.validateCityField(data.get("city"));
			// sideBarMenuComponent.registrationBeneficialOwnersPage().mailingAddressComponent().clickstate();
			Thread.sleep(1000);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipcode"),0);
			sideBarMenuComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.verifyCountry(data.get("country"));
			

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Beneficial Owners Field Validations flow is failed due to Exception " + e);
		}
	}

}
