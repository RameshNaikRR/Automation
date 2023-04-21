package coyni.checkout.tests;

import java.awt.AWTException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.checkout.CheckOutPage;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CheckOutTest {

	CheckOutPage checkOutPage;
	LoginPage loginPage;
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {

		checkOutPage = new CheckOutPage();
		loginPage = new LoginPage();
		sideMenuBarComponent = new SideMenuBarComponent();
	}

	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			new CommonFunctions().switchtoUrl(data.get(""));
			checkOutPage.enterDomain(data.get("domain"));
			checkOutPage.enterOrderId();
			checkOutPage.enterPublicKey(str);
			checkOutPage.enterSecretKey(str1);
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCardOne();
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			checkOutPage.clickCardTwo();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				Thread.sleep(2000);
				checkOutPage.clickCheckOut();
				Thread.sleep(3000);
				checkOutPage.switchToWindow();
				Thread.sleep(2000);
				checkOutPage.scanQRCodePayMerchantPage().clickContinueWithBrowser();

				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillEmail(data.get("email"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillPassword(data.get("password"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().clickNext();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
						.verifyHeading(data.get("heading"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickRadioBtnPhone();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickNext();
//				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
//						.verifyPhoneVerificationHeading();

				Thread.sleep(3000);
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.fillpin(data.get("code"));

				Thread.sleep(15000);
				int verifyBuyToken = checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
						.phoneVerificationPage().page().verifyBuyToken();

				if (verifyBuyToken > 0) {
					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().verifyInsufficient(data.get("insufficient"));
//					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
//							.phoneVerificationPage().page().getExchangeRate();
//					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
//							.phoneVerificationPage().page().getPaymentMethod();
					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().clickBuyTokens();
					if (checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().verifyCard() > 0) {
						addBuyToken(strParams);
					} else {
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().clickAddNewPaymentMethod();
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.clickDebitCard();
						Thread.sleep(3000);
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.fillNameOnCard(data.get("nameOnCard"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.fillCardNumber(data.get("cardNumber"));
						Thread.sleep(3000);
//						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
//								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
//								.validateCardBrand(data.get("cardType"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.fillCardExpiry(data.get("cardExpiry"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.fillCVVorCVC(data.get("cvvNumber"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().fillAddress1(data.get("addressLine1"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().fillAddress2(data.get("addressLine2"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().fillCity(data.get("city"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().fillZipCode(data.get("zipCode"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().selectState(data.get("state"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().verifyCountry(data.get("country"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().addCardComponent()
								.mailingAddressComponent().clickSave();
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().authorizationPopup()
								.fillAmount(data.get("preamount"));
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().buyCoyniTokensPaymentsPage().authorizationPopup()
								.clickOnVerify();
						checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
								.phoneVerificationPage().page().clickBackToBuyToken();
						addBuyToken(strParams);

					}

					// gooo
				} else if (checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
						.phoneVerificationPage().page().getSizeBackToLogin() > 0) {
					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().clickBackToMerchantLogin();

				}

				else if (checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
						.phoneVerificationPage().page().getPaynowButton() > 0) {

					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().clickPaynow();
					checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
							.phoneVerificationPage().page().verifyContent(data.get("successContent"));
				}
			} else {
				ExtentTestManager.setFailMessageInReport("Amount Is not matched");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test CheckOut transaction is failed due to Exception " + e);
		}

	}

	public void addBuyToken(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().clickCard();
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().txtCVV(data.get("cvv"));
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().clickNext();
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().fillAmount(data.get("amount"));
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().clickOutSide();
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().clickNext();
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().buyCoyniTokensOrderPreviewPage().clickConfirm();
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().buyCoyniTokensOrderPreviewPage().identityVerificationPage()
				.fillInput(data.get("code"));
		checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage().page()
				.buyCoyniTokensPaymentsPage().buyCoyniTokensOrderPreviewPage().identityVerificationPage()
				.successFailurePopupCardComponent().clickDone();
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testMerchantLoginForCheckOut(String strParams) throws InterruptedException, AWTException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		try {
        Thread.sleep(1000);
	//	loginPage.verifyHeading(data.get("loginHeading"));
		loginPage.fillEmail(data.get("merchEmail"));
		loginPage.fillPassword(data.get("merchPassword"));
		// loginPage.clickeyeIcon();
//		loginPage.verifyPasswordMaskedView(data.get("attribute"), "password");
		loginPage.clickNext();
		Thread.sleep(1000);
		loginPage.authyComponent().verifyHeading(data.get("authyHeading"));
		if (data.get("securityKey").equalsIgnoreCase("123456")) {
			loginPage.authyComponent().fillInput(data.get("securityKey"));
		} else {
			Thread.sleep(1000);
			loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			ExtentTestManager.setInfoMessageInReport("ok ");
		}
		
		Thread.sleep(2000);
		if(loginPage.verifyNonMaterialAgrrement()==0) {
			if(loginPage.verifyTermsOfServicesHeading()==1) {
				loginPage.scrollToTermsAgree();
			     loginPage.clickDone();
			}
			else {
			 loginPage.verifyWelcomeHeading();	
			}
			Thread.sleep(3000);
			if(loginPage.verifyPriacyPolicyHeading()==1) {
				loginPage.scrollToPrivacyAgree();
			     loginPage.clickDone();
			}

			else {
			 loginPage.verifyWelcomeHeading();	

		}
		}	
			else {
				Thread.sleep(3000);
		if(loginPage.verifyPriacyPolicyHeading()==1) {
			loginPage.scrollToPrivacyAgree();
		     loginPage.clickDone();
		}

		else {
		 loginPage.verifyWelcomeHeading();	
		}
		Thread.sleep(2000);
		if(loginPage.verifyTermsOfServicesHeading()==1) {
			loginPage.scrollToTermsAgree();
		     loginPage.clickDone();
		}

		else {
		 loginPage.verifyWelcomeHeading();	
		}
}
	} catch (Exception e) {
		ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
	}
	}	

	
	String str;
	String str1;
	
	@Test
	@Parameters({ "strParams" })
	public void testMerchantApiKeys(String strParams) throws InterruptedException, AWTException {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		try {
			Thread.sleep(2000);
			sideMenuBarComponent.clickMerchantSettings();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().clickApiKeyBtn();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.verifyHeading(data.get("apiKeysHeading"));
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickApiKeys();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickPublicKeyCopy();
			str=sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getPublicKey();
			Thread.sleep(2000);
			int i =sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().verifyButtonReavelSecretKey();
			if(i==1) {
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickReavelSecretKey();
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().authyComponent().fillInput(data.get("code"));
			Thread.sleep(2000);
			sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickSecretKeyCopy();
			str1 = sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
					.getSecretKey();
			}
			else {
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickGenerateNewSecretKey();
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().ClickGenerate();
				Thread.sleep(2000);
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickReavelSecretKey();
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().authyComponent().fillInput(data.get("code"));
				Thread.sleep(2000);
				sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage().clickSecretKeyCopy();
				str1 = sideMenuBarComponent.merchantSettingsPage().merchantSettingsSideBarMenuComponent().apiKeysPage()
						.getSecretKey();
			
			}
			Thread.sleep(3000);
			new CommonFunctions().switchtoUrl(data.get("checkOutUrl"));
			checkOutPage.enterDomain(data.get("url"));
			checkOutPage.enterOrderId();
			
			//checkOutPage.fillOrderId(data.get("orderID"));
			checkOutPage.enterPublicKey(str);
			checkOutPage.enterSecretKey(str1);
			checkOutPage.clickSaveDetails();
			
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			checkOutPage.clickCardOne();
			checkOutPage.clickCardTwo();
			
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				Thread.sleep(2000);
			
				checkOutPage.clickCheckOut();
				Thread.sleep(3000);
				checkOutPage.switchToWindow();
				Thread.sleep(2000);
				checkOutPage.scanQRCodePayMerchantPage().clickContinueWithBrowser();

				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillEmail(data.get("custEmail"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillPassword(data.get("custPassword"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().clickNext();

		        checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickRadioBtnPhone();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickNext();
//				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
//						.verifyPhoneVerificationHeading();

				Thread.sleep(3000);
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.fillpin(data.get("code"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
				.phoneVerificationPage().page().clickPaynow();
		        checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
				.phoneVerificationPage().page().verifyContent(data.get("successContent"));
		       
			}
		
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}	
		
	}
	
	
	
	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutTransactionForReserve(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			new CommonFunctions().switchtoUrl(data.get("checkOutUrl"));
			checkOutPage.enterDomain(data.get("url"));
			checkOutPage.enterOrderId();
			checkOutPage.enterPublicKey(str);
			checkOutPage.enterSecretKey(str1);
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCardOne();
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			checkOutPage.clickCardTwo();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				Thread.sleep(2000);
				checkOutPage.clickCheckOut();
				Thread.sleep(3000);
				checkOutPage.switchToWindow();
				Thread.sleep(2000);
				checkOutPage.scanQRCodePayMerchantPage().clickContinueWithBrowser();

				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillEmail(data.get("email"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillPassword(data.get("password"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().clickNext();

		        checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickRadioBtnPhone();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickNext();
//				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
//						.verifyPhoneVerificationHeading();

				Thread.sleep(3000);
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.fillpin(data.get("code"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
				.phoneVerificationPage().page().clickPaynow();
		        checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
				.phoneVerificationPage().page().verifyContent(data.get("successContent"));

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test failed due to exception " + e);
		}	
		
	}
		

	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			checkOutPage.enterDomain(data.get("domain"));
			checkOutPage.enterOrderIdContent(data.get("orderId"));
			;
			checkOutPage.enterPublicKey(data.get("publicKey"));
			checkOutPage.enterSecretKey(data.get("secretKey"));
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCardOne();
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			checkOutPage.clickCardTwo();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				Thread.sleep(2000);
				checkOutPage.clickCheckOut();
				checkOutPage.verifyPopUp();

			} else {
				ExtentTestManager.setFailMessageInReport("Amount Is not matched");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test CheckOut transaction is failed due to Exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutWithOutAddingProducts(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			checkOutPage.enterDomain(data.get("domain"));
			checkOutPage.enterOrderIdContent(data.get("orderId"));
			checkOutPage.enterPublicKey(data.get("publicKey"));
			checkOutPage.enterSecretKey(data.get("secretKey"));
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCheckOut();
			checkOutPage.verifyPopUp();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test CheckOut transaction is failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutCancelTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			checkOutPage.enterDomain(data.get("domain"));
			checkOutPage.enterOrderId();
			checkOutPage.enterPublicKey(data.get("publicKey"));
			checkOutPage.enterSecretKey(data.get("secretKey"));
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCardOne();
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			checkOutPage.clickCardTwo();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				Thread.sleep(2000);
				checkOutPage.clickCheckOut();
				Thread.sleep(3000);
				checkOutPage.switchToWindow();
				checkOutPage.scanQRCodePayMerchantPage().clickContinueWithBrowser();

				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillEmail(data.get("email"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().fillPassword(data.get("password"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().clickNext();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage()
						.verifyHeading(data.get("heading"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickRadioBtnPhone();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().clickNext();
//				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
//						.verifyPhoneVerificationHeading();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.fillpin(data.get("code"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().clickBackButton();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().cancelTransaction().verifyCancelHeading(data.get("cancelHeading"));

				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().cancelTransaction().verifyCancelContent(data.get("content"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().cancelTransaction().clickYes();
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().cancelTransaction().verifyCheckOutContent(data.get("checkOutContent"));
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().cancelTransaction().clickGoBackMerchant();
			} else {
				ExtentTestManager.setFailMessageInReport("Amount Is not matched");
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport(" test CheckOut Cancel transaction is failed due to Exception " + e);
		}

	}

	// ------------------

	public void testAddDebitCard(String strParams) {

		testAddCard(strParams, "debit");
	}

	public void testAddCreditCard(String strParams) {

		testAddCard(strParams, "credit");
	}

	public void testAddCard(String strParams, String card) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			// MerchantSettingsSideBarMenuComponent merchantSettingsSideBarMenuComponent =
			// new MerchantSettingsSideBarMenuComponent();
			Thread.sleep(2000);
			if (card.equalsIgnoreCase("credit")) {
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().buyCoyniTokensPaymentsPage().addCardComponent().clickCreditCard();
			} else {
				checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
						.page().buyCoyniTokensPaymentsPage().addCardComponent().clickDebitCard();
			}
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().clickDebitCard();
			Thread.sleep(3000);
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().fillNameOnCard(data.get("nameOnCard"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().fillCardNumber(data.get("cardNumber"));
			Thread.sleep(3000);
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().validateCardBrand(data.get("cardType"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().fillCardExpiry(data.get("cardExpiry"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().fillCVVorCVC(data.get("cvvNumber"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.fillAddress1(data.get("addressLine1"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.fillAddress2(data.get("addressLine2"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.fillCity(data.get("city"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.selectState(data.get("state"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent()
					.verifyCountry(data.get("country"));
			checkOutPage.scanQRCodePayMerchantPage().loginPage().identityVerificationPage().phoneVerificationPage()
					.page().buyCoyniTokensPaymentsPage().addCardComponent().mailingAddressComponent().clickSave();
//			merchantSettingsSideBarMenuComponent.paymentMethodComponent().preAuthorizationPopup()
//					.successFailurePopupCardComponent().clickDone();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Add DebitCard failed due to Exception " + e);
		}

	}

}
