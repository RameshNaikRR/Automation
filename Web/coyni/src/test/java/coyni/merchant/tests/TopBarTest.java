package coyni.merchant.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coyni.merchant.components.TopBarComponent;
import ilabs.api.reporting.ExtentTestManager;

public class TopBarTest {
	TopBarComponent topBarComponent;

	@BeforeTest
	public void init() {
		topBarComponent = new TopBarComponent();
	}

	@Test
	public void testTopBarView() {
		try {
			topBarComponent.VerifyTitle();
			topBarComponent.verifyUserNameDrpDwn();
			topBarComponent.verifyIconNotification();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTopBarView failed due to " + e);
		}
	}

	@Test
	public void testTopBarDrpDwnBtns() {
		try {
			for (int i = 1; i <= 7; i++) {
				topBarComponent.clickUserNameDrpDwn();
				if (1 == i) {
					topBarComponent.topBarDrpDwnComponent().clickUserDetails();
					topBarComponent.topBarDrpDwnComponent().userDetailsPage().verifyHeading();
				} else if (2 == i) {
					topBarComponent.topBarDrpDwnComponent().clickMerchantAccounts();
					topBarComponent.topBarDrpDwnComponent().merchantAccountsPage().verifyHeading();
				} else if (3 == i) {
					topBarComponent.topBarDrpDwnComponent().clickPreferences();
					topBarComponent.topBarDrpDwnComponent().preferencesPage().verifyHeading();
				} else if (4 == i) {
					topBarComponent.topBarDrpDwnComponent().clickAgreements();
					topBarComponent.topBarDrpDwnComponent().agreementsPage().verifyHeading();
				} else if (5 == i) {
					topBarComponent.topBarDrpDwnComponent().clickChangePassword();
					topBarComponent.topBarDrpDwnComponent().changePasswordPage().verifyHeading();
				} else if (6 == i) {
					topBarComponent.topBarDrpDwnComponent().clickTwoStepAuthentication();
					topBarComponent.topBarDrpDwnComponent().twoStepAuthenticationPage().verifyHeading();
				} else {
					topBarComponent.topBarDrpDwnComponent().clickSignOut();
				}
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTopBarDrpDwnBtns failed due to " + e);
		}
	}

//	@Test
//	public void testTopBarDrpDwnBtns() {
//		try {
//			topBarComponent.clickUserNameDrpDwn();
//			topBarComponent.topBarDrpDwnComponent().clickUserDetails();
//			topBarComponent.topBarDrpDwnComponent().userDetailsPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickMerchantAccounts();
//			topBarComponent.topBarDrpDwnComponent().merchantAccountsPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickPreferences();
//			topBarComponent.topBarDrpDwnComponent().preferencesPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickAgreements();
//			topBarComponent.topBarDrpDwnComponent().agreementsPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickChangePassword();
//			topBarComponent.topBarDrpDwnComponent().changePasswordPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickTwoStepAuthentication();
//			topBarComponent.topBarDrpDwnComponent().twoStepAuthenticationPage().verifyHeading();
//			topBarComponent.clickUserNameDrpDwn();
//
//			topBarComponent.topBarDrpDwnComponent().clickSignOut();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
