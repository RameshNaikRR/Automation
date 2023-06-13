package coyni.admin.MerchantServicescomponents;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SideBarApiBusinessComponent extends BrowserFunctions {

	private By getLblElement(String text) {
		return By.xpath(String.format("//span[text()='%s']", text));
	}

	private By btnViewMore = By.xpath("(//button[text()='View Wallet'])[1]");

	private By lblAvaliableBalance = By.xpath("//h2[text()='Available Balance']/following-sibling::span");

	private By btnAddNewWallet = By.xpath("//button[text()='Add New Token Wallet']");

	private By lblAddnewToken = By.xpath("//h1[text()='Add New Token Wallet']");
	private By txtTokenWallet = By.xpath("//input[@id='Walletname']");
	private By btnAddWallet = By.xpath("//button[text()='Add Wallet']");

	public void verifyTokenHeading(String text) {
		new CommonFunctions().verifyLabelText(lblAddnewToken, "Add New Token Wallet", text);
	}

	public void enterTokenWallet(String text) {
		enterText(txtTokenWallet, randomLetters(), "Token Wallet");
	}

	public String randomLetters() {
		int len = 8;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();

	}

	public void clickAddWallet() {
		click(btnAddWallet, "Add Wallet");
	}

	public void clickAddNewWallet() {
		click(btnAddNewWallet, "");
	}

	public void getAvaliableBalance() {
		getElement(lblAvaliableBalance, "");
	}

	public void clickViewMore() {
		click(btnViewMore, "ViewMore");
	}

	private By name = By.xpath("//span[contains(@class,'w-40 ml-2 font-semibold')]");

	public void tokenAmount() {
		List<WebElement> elementsList = getElementsList(name, "");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String value = getText(By.xpath(String.format("(//span[.='%s']/../following-sibling::div)[1]", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " Value is " + value);
		}
	}

	private By lblWallet = By.xpath("//span[contains(@class,'w-40 font-bold text-cgy4 ')]");

	public void viewWalletIdAndBalance() throws InterruptedException {
		List<WebElement> element = getElementsList(lblWallet, "");
		Thread.sleep(2000);
		for (WebElement ele : element) {
			String text = ele.getText();
			String walletBalance = getText(By.xpath(String.format(
					"//span[@class='w-40 font-bold text-cgy4 ' and text()='%s']/ancestor::div[@class='text-sm Wallet_Wallet_index_main__2F3QD text-cgy3 flex justify-between']/descendant::span[@class='items-center w-40 font-semibold text-cgy4']",
					text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " Value is " + walletBalance);
		}
		

	}

	public void clickXDashboard() {
		click(getLblElement("Dashboard"), "Dashboard");
	}

	private By babs = By.xpath("//span[text()='Token Wallet(s)']");

	public void clickTokenWallet() {
		click(babs, "TokenWallet(s)");
	}

	public void clickCompanyInformation() {
		click(getLblElement("Company Information"), "Company Information");
	}

	public void clickDBA() {
		click(getLblElement("DBA Information"), "DBA Information");
	}

	public void clickOwners() {
		click(getLblElement("Beneficial Owner(s)"), "Beneficial Owner(s)");
	}

	public void clickUsers() {
		click(getLblElement("Platform Users"), "Platform Users");
	}

	public void clickAccountLimits() {
		click(getLblElement("Account Limits"), "Account Limits");
	}

	public void clickAccountFee() {
		click(getLblElement("Account Fees"), "Account Fees");
	}

	public void clickIpAddress() {
		click(getLblElement("IP Addresses"), "IP Addresses");
	}

	public void clickAgreements() {
		click(getLblElement("Agreements"), "Agreements");
	}

	public void clickAPIKeys() {
		click(getLblElement("API Keys"), "API Keys");
	}

	public void clickWebhooks() {
		click(getLblElement("Webhooks"), "Webhooks");
	}

	// Company Information

	private By lblCompanyInfo = By.xpath("//span[contains(@class,'pt-1 text-sm text-cgy8')]");
	private By lblContactInfo = By.xpath("//span[contains(@class,'undefined text-sm text-cgy4 break-all')]");
	private By lblAddress = By
			.xpath("//div[contains(@class,'flex flex-col gap-1 text-sm text-cgy8 break-all capitalize')]");

	public void getCompany() {
		ExtentTestManager.setInfoMessageInReport(getText(lblCompanyInfo, "Company info"));
	}

	public void getContact() {
		ExtentTestManager.setInfoMessageInReport(getText(lblContactInfo, "Company info"));
	}

	public void getAddress() {
		ExtentTestManager.setInfoMessageInReport(getText(lblAddress, "Company info"));
	}

	// DBA Info
	private By lblBusinessType = By.xpath("(//span[contains(@class,'text-sm break-all text-cgy4')])[2]");
	private By lblCustomerService = By.xpath("//span[contains(@class,'undefined break-all text-sm text-cgy4')]");
	private By lblAddressDBA = By
			.xpath("//div[contains(@class,'flex flex-col gap-1 text-sm text-cgy4 break-all capitalize')]");

	public void getBusiness() {
		ExtentTestManager.setInfoMessageInReport(getText(lblBusinessType, "Business info"));
	}

	public void getCustomerService() {
		ExtentTestManager.setInfoMessageInReport(getText(lblCustomerService, "Customer info"));
	}

	public void getAddressDBA() {
		ExtentTestManager.setInfoMessageInReport(getText(lblAddressDBA, "AddressDBA info"));
	}

	// Beneficial Owner(s)

	private By lblBeneficial = By.xpath("//div[contains(@class,'flex items-center mr-2')]");
	private By lblname = By
			.xpath("//span[contains(@class,'flex items-center text-sm capitalize break-all text-cgy4')]");
	private By lblDateOfBirth = By.xpath("//span[contains(@class,'text-sm text-cgy4')]");

	private By lblSSN = By.xpath("//span[contains(@class,'text-sm text-cgy4')]");
	private By lblOwnerShip = By.xpath("//span[contains(@class,'text-sm text-cgy4')]");
	private By lblBenefiAddress = By.xpath("//div[contains(@class,'flex flex-col gap-1 break-word sm:w-28 md:w-44')]");

	public void clickBenefical() {
		click(lblBeneficial, "Beneficial Owner");
	}

	public void getBenefiName() {
		ExtentTestManager.setInfoMessageInReport(getText(lblname, "Name"));
	}

	public void getBenefiDOB() {
		ExtentTestManager.setInfoMessageInReport(getText(lblDateOfBirth, "AddressDBA info"));
	}

	public void getSSN() {
		ExtentTestManager.setInfoMessageInReport(getText(lblSSN, "SSN"));
	}

	public void getOwnerShip() {
		ExtentTestManager.setInfoMessageInReport(getText(lblOwnerShip, "OwnerShip"));
	}

	public void getBenefiAddress() {
		ExtentTestManager.setInfoMessageInReport(getText(lblBenefiAddress, "Address"));
	}

//APi Keys

	private By lblPublicKey = By
			.xpath("//p[contains(@class,'text-sm text-cgy8 font-semibold APIKeys_secret_key__539ou')]");
	private By lblSecretKey = By
			.xpath("//p[contains(@class,'text-sm text-cgy8 font-semibold APIKeys_secret_key__US28X')]");

	private By btnRev = By.xpath("//span[text()='Reveal Key']");

	public void clickRevealKey() {

		click(btnRev, "Reveal Key");

	}
	public int reSize() throws InterruptedException {
        Thread.sleep(3000);
       return getElementsList(btnRev, "").size();
   }

	public void getPublicKey() {
		if(getElementsList(lblPublicKey, "").size()>0) {
		ExtentTestManager.setInfoMessageInReport(getText(lblPublicKey, "Public Key"));
		}
		else {
			ExtentTestManager.setInfoMessageInReport("Public Key is not avaliable");
		}
	}

	public void getSecretKey() {
		ExtentTestManager.setInfoMessageInReport(getText(lblSecretKey, "Secret Key"));
	}

//Agreements

	private By lblAgreement = By.xpath("//span[text()='Terms of Service']");
	private By lblDownload = By.xpath("//span[text()='Download PDF']");

	public void clickTermOfService() {
		click(lblAgreement, "Terms of Service");
	}

	public void clickDownloadAgreement() {
		click(lblDownload, "Download PDF");
	}

	private By lbl = By.xpath("//span[text()='You do not have any transactions.']");

	public int getNoTransactionSize() {
		return getElementsList(lbl, "").size();
	}

	// WebBook

}
