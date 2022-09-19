package coyni.admin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import coyni.admin.components.AccountTableComponent;
import coyni.admin.components.DatePickerComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class FeeStructurePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Fee Structure']");
	private By lnkPersonal = By.xpath("//div[text()='Personal']");
	private By lnkMerchant = By.xpath("//button[contains(text(),'Merchant')]/..");
	private By btnView = By.xpath("//button[contains(@data-tip,'View')]");
	private By btnEdit = By.xpath("//button[contains(@class,'icon-edit')]");
	private By lblInactive = By.xpath("(//div[text()='Inactive'])[1]");
	private By lblActive = By.xpath("//div[text()='Active'])[1]");
	private By lblCancelled = By.xpath("//div[text()='Cancelled'])[1]");
	private By lblScheduled = By.xpath("//div[text()='Scheduled'])[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void clickPersonal() {
		click(lnkPersonal, "personal");

	}

	public void clickMerchant() {
		click(lnkMerchant, "merchant");
	}

	public void clickView() {
		click(btnView, "view");
	}

	public void clickEdit() {
		click(btnEdit, "edit");
	}

	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public void statusView() {

		if (verifyElementDisplayed(lblInactive, "Inactive")) {
			ExtentTestManager.setInfoMessageInReport("Status is Inactive displayed");
		}

		else if (verifyElementDisplayed(lblActive, "Active")) {
			ExtentTestManager.setInfoMessageInReport("Status is Inactive displayed");
		} else if (verifyElementDisplayed(lblCancelled, "Cancelled")) {
			ExtentTestManager.setInfoMessageInReport("Status is Cancelled displayed");
		} else if (verifyElementDisplayed(lblScheduled, "Scheduled")) {
			ExtentTestManager.setInfoMessageInReport("Status is Scheduled displayed");
		} else {
			ExtentTestManager.setInfoMessageInReport("Status is not displayed");
		}

	}

	public ViewPersonalFeeStructurePage viewPersonalFeeStructurePage() {
		return new ViewPersonalFeeStructurePage();
	}

	public EditPersonalFeeStructurePage editPersonalFeeStructurePage() {
		return new EditPersonalFeeStructurePage();
	}

	public ViewMerchantfeeStructurePage viewMerchantfeeStructurePage() {
		return new ViewMerchantfeeStructurePage();
	}

	public EditMerchantFeeStructurePage editMerchantFeeStructurePage() {
		return new EditMerchantFeeStructurePage();
	}

	private By btnActive = By.xpath("//div[text()='Active']/ancestor::tr[@class=' ']/descendant::button");

	public void clickActiveEdit() throws InterruptedException {
		moveToElement(btnActive, "btnActive");
		Thread.sleep(2000);
		click(btnActive, "btnActive");
	}

	private By btnEditDebit = By
			.xpath("(//label[text()='Debit Card']//ancestor::div[@class='flex flex-row mt-5 h-7']/descendant::p)[1]");

	public void enterTextDebit(String debitAmnt) throws InterruptedException {
		Thread.sleep(2000);
		click(btnEditDebit, "btnEditDebit");
		WebElement ele = getElement(btnEditDebit, "btnEditDebit");
		Actions a = new Actions(DriverFactory.getDriver());
		a.doubleClick(ele).sendKeys(debitAmnt).perform();
		ExtentTestManager.setInfoMessageInReport("Clicked on element debit");
		ExtentTestManager.setInfoMessageInReport("Entered text in element Debit");
	}

	private By btnShedule = By.xpath("//button[text()='Schedule']");

	public void clickSheduled() {
		click(btnShedule, "btnShedule");
	}

	private By btnSelectDate = By.xpath("//input[@placeholder='Select A Date']");

	public void clickSelectDate(String selectDate) {
		click(btnSelectDate, "btnSelectDate");
		new DatePickerComponent().setDate(selectDate);
		ExtentTestManager.setInfoMessageInReport("Entered date in element btnSelectDate");
	}

	private By btnShedule2 = By.xpath("(//button[text()='Schedule'])[2]");

	public void clickSheduled2() {
		click(btnShedule2, "btnShedule2");

	}

	private By txtCreditedBy = By.xpath("(//h1[@class='text-sm font-semibold text-cgy4'])[3]");

	public String getCreditedByname() {
		waitForElement(txtCreditedBy, waittime, WaitForElement.presence);
		return getText(txtCreditedBy, "CreditedByName");
	}

	private By txtDate = By.xpath("//td");

	public List<WebElement> getStartDate() throws InterruptedException {
		return getElementsList(txtDate, "txtDate");
	}
}