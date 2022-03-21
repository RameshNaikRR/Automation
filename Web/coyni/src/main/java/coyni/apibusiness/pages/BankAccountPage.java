package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankAccountPage extends BrowserFunctions{
	
	private By lblHeading =  By.xpath("//h4[text()='Add Bank Account']");
	private By lnkLearnMore = By.xpath("//strong[text()='Learn More']");
	private By lblAddBankAccountDesc = By.xpath("//p[@class='text-sm text-cgy13 leading-5']");
	private By btnImReady = By.xpath("//button[text()='I’m Ready']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkExit = By.xpath("//Strong[text()='Exit']");
	private By btnBack = By.xpath("//span[text()='Back']");
	private By lblFiserv = By.xpath(" ");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By txtUserName = By.xpath("//input[@name='acctForm:j_idt143:0:login_']");
	private By txtPassword = By.xpath("//input[@name='acctForm:j_idt147:0:password_']");
	private By btnSelectAnotherInst = By.xpath("//a[@id='acctForm:selectFI']");
	private By btnBankNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By chkbxBank = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]/input");
	private By NextButton = By.xpath(" ");
	public void verifyLabelHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, heading, "Heading");
	}
	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}
	public void VerifyAddBankAccountDesc(String AddBankAccountDesc) {
		new CommonFunctions().verifyLabelText(lblAddBankAccountDesc, AddBankAccountDesc, "Add Bank Account Desc");
	}
	public void clickImReady() {
		click(btnImReady, "IM Ready");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void clickExit() {
		click(lnkExit, "Exit");
	}
	public void clickBack() {
		click(btnBack, "Back");
	}
	public void fillBankName(String bankName) {
   enterText(txtBankName, bankName,"bankName");		
	}
	public void fillUserName(String userName) {
		enterText(txtUserName, userName, "userName");
	}
	public void fillPassword(String password) {
		enterText(txtPassword, password, "password");
	}
	public void clickSelectAnotherInstitute() {
		click(btnSelectAnotherInst, "Select Another Institute");
	}
	public void clickBankNext() {
		click(btnBankNext, "Next");
	}
	public void clickChkbxBank() {
		click(chkbxBank, "Bank");
	}
	
}
