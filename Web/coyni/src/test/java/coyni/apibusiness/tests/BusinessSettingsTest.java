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
}