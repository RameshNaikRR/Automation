package coyni.apibusiness.tests;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.api.business.popups.AddIPAddressPopups;
import coyni.apibusiness.components.BusinessSettingsSideBarMenuComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.BusinessProfilePage;
import coyni.apibusiness.pages.HomePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class BusinessSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent;
	AddIPAddressPopups addIpAddressPopups;
	BusinessProfilePage businessProfilePage;
	NavigationMenuPage navigationMenuPage;
	HomePage homePage;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		businessSettingsSideBarMenuComponent = new BusinessSettingsSideBarMenuComponent();
		addIpAddressPopups = new AddIPAddressPopups();
		businessProfilePage = new BusinessProfilePage();
		navigationMenuPage = new NavigationMenuPage();
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsSideBarView(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		sideBarMenuComponent.clickBusinessSettings();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyHeading(data.get("heading"));
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyUserImageView();
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountIdView();
//		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountId(data.get("accountID"));
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
					.verifyNoIp(data.get("noIPExist"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("ipDescription"));
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
	public void testAddNewIpAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("ipDescription"));
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickIpAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountId();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.verifyAccountName();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillIpAddress(data.get("ipAddress"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.fillDescription(data.get("ipDescription"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().addIPAddressPopups()
					.clickOutSide();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent()
					.verifydesc(data.get("ipDescription"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().ipAddressComponent().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Remove ip address  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsWebhookView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointURL();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().verifyEndPointDescription();
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickEndPointURL();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.enterEndPointURL(data.get("endpointURL"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickEndPointDescription();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.enterEndpointDesc(data.get("endpointDesc"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickSave();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().saveChangePopUp().clickYes();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().toastComponent()
					.verifyToast(data.get("title"), data.get("message"));

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
					.enterEndPointURL(data.get("endpointURL"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent()
					.enterEndpointDesc(data.get("description"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().webhookComponent().clickCreate();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test webhook  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationView(String strParams) {
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().registrationDBAInformationPage()
					.clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test DBA Information Edit  Failed due to Exception " + e);
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
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test DBA Information Edit  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDBAInformationInvalidInfo(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().dbaInfoEditPage().clickSave();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test DBAInfo  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickCompanyInformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().verifyCompanyInfo();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().viewPhoneNumber();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().viewCompanyEmail();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickEditPhone();
//			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickEditEmail();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().verifyAddress();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickSaveEnabled();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Company Information  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCompanyInformationInvalidInfoEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickCompanyInformation();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.fillPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage()
					.fillCompanyEmail(data.get("companyEmail"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickTab();
			Thread.sleep(2000);
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().companyInfoEditPage().clickSaveEnabled();
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test CompanyInfo  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testFeesView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent()
					.verifyHeading(data.get("heading")); // Business Settings
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().clickFees();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyFeesHeading(data.get("feesHeading")); // Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesHeading(data.get("yourFeesHeading")); // Your Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyYourFeesCharges();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.clickUserFees();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesHeading(data.get("userFeesHeading")); // User Fees
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().feesPage()
					.verifyUserFeesCharges();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimitsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent()
					.verifyHeading(data.get("heading")); // Business Settings
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().clickAccountLimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifYAccountLimitsHeading(data.get("accountLimitsHeading")); // Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsHeading(data.get("yourLimitsHeading")); // Your Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyYourLimitsAccountlimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.clickUserLimits();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsHeading(data.get("userLimitsHeading")); // User Account Limits
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsLabels();
			sideBarMenuComponent.businessSettingsPage().businessSettingsSideBarMenuComponent().accountLimitsPage()
					.verifyUserLimitsAccountlimits();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialOwnersView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage().clickBeneficialOwner();
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage()
					.verifyHeading(data.get("heading"));
			sideBarMenuComponent.businessSettingsSideBarMenuComponent().beneficialOwnersPage()
					.viewBeneficialOwnerData();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimitsView failed due to " + e);
		}
	}

	@Test
	public void testNotifications() {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			// businessProfilePage.userDetailsComponent().notificationsComponent()
			// .verifyBellIconMouseHoverAction(data.get("background"), strParams);
			Thread.sleep(2000);
			businessProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			// businessProfilePage.userDetailsComponent().notificationsComponent().verifyCursorNotification();
			businessProfilePage.userDetailsComponent().notificationsComponent().clickNotifications();
			Thread.sleep(2000);
			// businessProfilePage.userDetailsComponent().notificationsComponent().verifyAllNotifications();
			businessProfilePage.userDetailsComponent().notificationsComponent().verifyDateFormatInNotifications();
			// businessProfilePage.userDetailsComponent().notificationsComponent().verifyNotificationsCount();
			businessProfilePage.userDetailsComponent().notificationsComponent().clickRequests();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Notifications is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testNotificationsCount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			System.out.println("id:" + navigationMenuPage.getCustId());
			String dbCount = DBConnection.getDbCon()
					.getColumnData(String.format(data.get("query"), navigationMenuPage.getCustId()));
			System.out.println(dbCount);
			String uiCount = businessProfilePage.userDetailsComponent().notificationsComponent().getUiCount();
			if (uiCount.equals(dbCount)) {
				ExtentTestManager.setPassMessageInReport("Count is verified");
			} else {
				ExtentTestManager.setFailMessageInReport("Count is not verified");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testNotifications count failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCancelNotifications(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			businessProfilePage.userDetailsComponent().notificationsComponent().clickNotificationsIcon();
			businessProfilePage.userDetailsComponent().notificationsComponent().clickRequests();
			businessProfilePage.userDetailsComponent().notificationsComponent().verifybtnCancelView();
			businessProfilePage.userDetailsComponent().notificationsComponent()
					.verifyReminderfirstMsg(data.get("initialMsg"));
			Thread.sleep(1000);
			// businessProfilePage.userDetailsComponent().notificationsComponent().verifyCancelBorderColor(data.get("CssProp"),
			// data.get("CssValue"), data.get("Color"));
			businessProfilePage.userDetailsComponent().notificationsComponent().clickCancel();
			businessProfilePage.userDetailsComponent().notificationsComponent().verifyCancelMsg(data.get("finalMsg"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Cancel notifications failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsNoTeamMember(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		homePage.sideBarMenuComponent().clickBusinessSettings();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
				.verifyTeamHeading(data.get("heading"));
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifySearch(data.get("search"));
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconSearch();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickFilter();
		homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyRecords();

	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAddTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickAddTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyHeading(data.get("addTeamHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyFirstName(data.get("firstName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyLastName(data.get("lastName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyEmail(data.get("emaildet"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.verifyPhone(data.get("phone"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.clickAddRole();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().verifyHeading(data.get("customHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().verifyRoleName(data.get("roleName"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.addCustomRolePopup().clickAdd();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.addCustomRolePopup().navigationComponent().clickClose();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickEdit();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyTokenWalletAccess();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyTransferToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyBuyToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyWithdrawToken();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyEcosystemActivity();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyExportedFiles();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.verifyBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent().clickSave();
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.saveChangePopUp().verifyHeading(data.get("expHeading"));

			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.saveChangePopUp().clickYes();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.clickSendInvitation();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.toastComponent().checkToastMessage(data.get("toastMessage"));

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Add Team Member failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifyTeamHeading(data.get("heading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().clickFilter();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyActive();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyPending();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyExpired();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyApplyFilters();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.teamComponent().clickFilter();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
//					.filtersPage().verifyClearAll();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().addTeamMemberComponent()
					.filtersPage().verifyResetFilters();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Filters failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent()
					.verifySearch(data.get("searchingKey"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconSearch();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickSearchIcon();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsRemoveTeamMember(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().iconDelete();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickRemove();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().toastComponent()
					.verifyToast(data.get("toastTitle"), data.get("toastMessage"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings Team Search  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsTeamEdit(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickTeam();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().verifyEditIcon();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().teamComponent().clickEdit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings Team Edit  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsGenerateAPIKeys(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyAPIKey(data.get("apiKeyHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickGenerateApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().verifyHeading(data.get("popupHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().getGenerateKeyDescription();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.generateNewSecretKeyPopup().clickGenerate();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().secretKeyPopup().clickEnd();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyLblPublicKey();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyPublicKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyLblSecretKey();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifySecretKey();
//			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
//					.verifyInactiveSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyCopy();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings API Keys  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsRevealSecretKeyAndHideSecretKey(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyAPIKey(data.get("apiKeyHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickRevealKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.fillInput(data.get("code"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.clickHideSecretKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickCopy();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyCopy();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings API Keys  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsGetSMSCodeRevealSecretKey(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyAPIKey(data.get("apiKeyHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().clickRevealKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.clickSmsCode();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().authyComponent()
					.fillInput(data.get("pin"));
			Thread.sleep(2000);
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().toastComponent()
					.verifyToast(data.get("title"), data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings API Keys  failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingsAPIKeyLogs(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarMenuComponent().clickBusinessSettings();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().clickApiKey();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent()
					.verifyAPIKey(data.get("apiKeyHeading"));
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().verifyApiKeyView();
			homePage.sideBarMenuComponent().businessSettingsSideBarMenuComponent().apiKeyComponent().verifyAPIEvents();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Settings API Keys  failed due to Exception " + e);
		}
	}

}