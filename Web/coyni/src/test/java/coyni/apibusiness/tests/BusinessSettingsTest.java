package coyni.apibusiness.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.apibusiness.components.BusinessSettingsSideBarMenuComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		businessSettingsSideBarMenuComponent = new BusinessSettingsSideBarMenuComponent();
	}

	@Test
	public void testBusinessSettingsSideBarView() {
		Map<String, String> data = Runner.getKeywordParameters(null);
		sideBarMenuComponent.clickBusinessSettings();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyHeading(data.get("heading"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyUserImageView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountIdView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountId(data.get("accountID"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatusView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountStatus(data.get("accountStatus"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyCompanyInformationView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyDBAInformationView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyBeneficiaryOwnersView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPaymentMethodsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPaymentMethods();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPreferencesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPreferences();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAgreementsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAgreements();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyFeesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickFees();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountLimitsView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAccountLimits();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyTeamView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickTeam();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyIpAddressesView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyApiKeyView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickApiKey();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyWebHooksView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyIpHeading(data.get("ipHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("description"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickSubmit();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifySuccessHeading(data.get("successHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddIpAddressInvalidScenario(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyIpHeading(data.get("ipHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("description"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickOutSide();
			if (!data.get("errMessage").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Add ip address  Failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testDeleteAddIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickDelete();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
					.verifyRemoveHeading(data.get("removeHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Remove ip address  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointURL();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointStatus();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointStatus();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyLastUpdated();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsEditWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickIcon();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyEditEndPointURL(data.get("edit"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyEditEndPoint(data.get("editEndPoint"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickSave();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().saveChangePopUp()
					.verifyEndPointHeading(data.get("endPointHeading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().saveChangePopUp().clickYes();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsCreateWebhook(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickCreate();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyEndPointURL(data.get("textEndPoint"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.endPointDescription(data.get("description"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickCreate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().dBANameView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.phoneNumberView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.companyEmailView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.customerServiceView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.businessTypeView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickEditIcon();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().addressView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationInvalidInfoEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().dBANameView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.phoneNumberView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.companyEmailView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.customerServiceView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.businessTypeView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickEditIcon();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().addressView();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
//					.fillPhoneNumber(data.get("phoneNumber"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
//					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickSaveEnabled();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(500);
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
						.fillCompanyEmail(data.get("companyEmail"));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(500);
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
						.fillCompanyEmail(data.get("phoneNumber"));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().dBANameView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.phoneNumberView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.companyEmailView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.customerServiceView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.businessTypeView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickEditIcon();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().addressView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationInvalidInfoEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().dBANameView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.phoneNumberView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.companyEmailView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.customerServiceView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.businessTypeView();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickEditIcon();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage().addressView();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
//					.fillPhoneNumber(data.get("phoneNumber"));
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
//					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickSaveEnabled();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(500);
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
						.fillCompanyEmail(data.get("companyEmail"));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(500);
				sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
						.fillCompanyEmail(data.get("phoneNumber"));
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}
}