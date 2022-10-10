package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AgreementComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ReviewApplicationPage extends MobileFunctions {

	private By lblReviewApplication = MobileBy.xpath("//*[contains(@text,'Review A')]");

	private By lblCompanyInfo = MobileBy.xpath("//*[contains(@text,'Company Info')]");
	private By btnCompanyEdit = MobileBy.xpath("//*[contains(@resource-id,'edit1')]");
	private By lnlCompanyDocView = MobileBy.xpath("(//*[contains(@text,'View')])[1]");
	private By btnDocumentClose = MobileBy.xpath("//*[contains(@resource-id,'closeBtn')]");
	private By lblDBAInfo = MobileBy.xpath("//*[contains(@text,'DBA Info')]");
	private By btnDBAEdit = MobileBy.xpath("//*[contains(@resource-id,'edit2')]");
	private By lnkDBADocView = MobileBy.xpath("//*[contains(@resource-id,'llDBADocuments')]");
	private By lblBeneficialHeading = MobileBy.xpath("(//*[contains(@text,'Beneficial Owner')])");
	private By btnBeneficialEdit = MobileBy.xpath("//*[contains(@resource-id,'edit3TV')]");
	private By lnkBeneficial1DocView = MobileBy.xpath("(//*[contains(@resource-id,'llUploadDocument')])[1]");
	private By lblBankAccountHeading = MobileBy.xpath("//*[contains(@text,'Bank Account')]");
	private By lblMerchantHeading = MobileBy.xpath("//*[contains(@text,'Merchant Agreements')]");
	private By chkBoxReviewAppli = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");
	private By btnSubmit = MobileBy.xpath("//*[contains(@text,'Submit')]");

	public void verifyReviewApplicationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReviewApplication, "Review Application Heading", expHeading);
	}

	public void verifyCompanyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCompanyInfo, "Company Info Heading", expHeading);
	}

	public int verifyCompanyHeading() {
		return DriverFactory.getDriver().findElements(lblCompanyInfo).size();
	}

	public void clickCompanyEdit() {
		click(btnCompanyEdit, "Company Info Edit");
	}

	public void clickCompanyDocView() {
		click(lnlCompanyDocView, "Company Info Documents View");
	}

//DBA information

	public void verifyDBAInfoHeading(String expHeading) {
		scrollDownToElement(lblDBAInfo, "DBA Info Heading");
		new CommonFunctions().verifyLabelText(lblDBAInfo, "DBA Info Heading", expHeading);
	}

	public void clickDBAEdit() {
		scrollDownToElement(btnDBAEdit, "DBA Info Edit");
		click(btnDBAEdit, "DBA Info Edit");
	}

	public void clickDBADocView() {
		scrollDownToElement(lnkDBADocView, "DBA Info Documents View");
		click(lnkDBADocView, "DBA Info Documents View");
	}

	public int verifyDBADocView() {
		return DriverFactory.getDriver().findElements(lnkDBADocView).size();
	}

	public void clickDocumentClose() {
		click(btnDocumentClose, "Documents Close");
	}

//Beneficial Owners information

	public void verifyBeneficialHeading(String expHeading) {
		scrollDownToElement(lblBeneficialHeading, "Beneficial Owners Heading");
		new CommonFunctions().verifyLabelText(lblBeneficialHeading, "Beneficial Owners Heading", expHeading);
	}

	public void clickBeneficialEdit() {
		scrollDownToElement(btnBeneficialEdit, "Beneficial Owners Edit");
		click(btnBeneficialEdit, "Beneficial Owners Edit");
	}

	public void clickBeneficialDocView() {
		scrollDownToElement(lnkBeneficial1DocView, "Beneficial Owners Documents View");
		click(lnkBeneficial1DocView, "Beneficial Owners Documents View");
	}

//	Bank Information

	public void verifyBankHeading(String expHeading) {
		scrollDownToElement(lblBankAccountHeading, "Bank Account Heading");
		new CommonFunctions().verifyLabelText(lblBankAccountHeading, "Bank Account Heading", expHeading);
	}

//Merchant Agreements Information

	public void verifyAgreementsHeading(String expHeading) {
		scrollDownToElement(lblMerchantHeading, "Agreements Heading");
		new CommonFunctions().verifyLabelText(lblMerchantHeading, "Agreements Heading", expHeading);
	}

//	public void clickMerchantAgreement() {
//		scrollDownToElement(lnkMerchantAgreement, "lnkMerchantAgreement");
//		click(lnkMerchantAgreement, "lnkMerchantAgreement");
//	}
//
//	public void clickTermsofService() {
//		scrollDownToElement(lnkTermsofService, "Terms of Service");
//		click(lnkTermsofService, "Terms of Service");
//	}
//
//	public void clicklPrivacyPolicy() {
//		scrollDownToElement(lnkPrivacyPolicy, "lnkPrivacyPolicy");
//		click(lnkPrivacyPolicy, "lnkPrivacyPolicy");
//	}

	public void clickReviewApplicationCheckBox() {
		scrollDownToElement(chkBoxReviewAppli, "chkBoxReviewAppli");
		click(chkBoxReviewAppli, "chkBoxReviewAppli");
	}

	public void clickSubmit() {
		scrollDownToElement(btnSubmit, "Submit");
		click(btnSubmit, "Submit");
	}

	public void verifyReviewApplication(String expReviewHeading, String expCompHeading, String expDBAHeading,
			String expBeneficialHeading, String expBankHeading, String expAgrrementsHeading)
			throws InterruptedException {
		Thread.sleep(2000);
		verifyReviewApplicationHeading(expReviewHeading);
		Thread.sleep(2000);
		if (verifyCompanyHeading() == 1) {
			verifyCompanyHeading(expCompHeading);
//		clickCompanyEdit();
//		registrationCompanyInfoPage().AddCompanyInfo(expCompHeading, expAgrrementsHeading, expAgrrementsHeading, expAgrrementsHeading, expAgrrementsHeading, expReviewHeading, expCompHeading, expDBAHeading, expBeneficialHeading, expAgrrementsHeading);
			clickCompanyDocView();
			clickDocumentClose();
		}
		verifyDBAInfoHeading(expDBAHeading);
		Thread.sleep(2000);
		if (verifyDBADocView() == 1) {
			clickDBADocView();
			clickDocumentClose();
		}
		Thread.sleep(2000);
		verifyBeneficialHeading(expBeneficialHeading);
		clickBeneficialDocView();
		clickDocumentClose();
		Thread.sleep(2000);
		verifyBankHeading(expBankHeading);
		verifyAgreementsHeading(expAgrrementsHeading);
		agreementComponent().verifyPrivacyPolicyView();
		agreementComponent().clickClose();
		Thread.sleep(2000);
		agreementComponent().verifyTermsOfServiceView();
		agreementComponent().clickClose();
		Thread.sleep(2000);
		agreementComponent().verifyMerchantAgreementView();
		agreementComponent().clickClose();
		Thread.sleep(2000);
		clickReviewApplicationCheckBox();
		clickSubmit();

	}

	public AgreementComponent agreementComponent() {
		return new AgreementComponent();
	}

	public RegistrationCompanyInfoPage registrationCompanyInfoPage() {
		return new RegistrationCompanyInfoPage();
	}
}
