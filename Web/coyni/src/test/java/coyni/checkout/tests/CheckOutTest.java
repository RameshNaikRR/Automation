package coyni.checkout.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.checkout.CheckOutPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CheckOutTest {

	CheckOutPage checkOutPage;

	@BeforeTest
	public void init() {

		checkOutPage = new CheckOutPage();
	}

	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutTransaction(String strParams) {
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
				checkOutPage.switchToWindoe();
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
				checkOutPage.switchToWindoe();
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
