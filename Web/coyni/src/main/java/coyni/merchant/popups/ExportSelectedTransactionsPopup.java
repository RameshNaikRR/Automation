package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.FilterCalenderComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ExportSelectedTransactionsPopup extends BrowserFunctions {

	private By radBtnToday = By.xpath("//span[text()='Today']");
	private By radBtnYesterday = By.xpath("//span[text()='Yesterday']");
	private By radBtn7Days = By.xpath("//span[text()='Last 7 Days']");
	private By radBtnMonthToDate = By.xpath("//span[contains(text(),'Month to Date')]");
	private By radBtnLastMonth = By.xpath("//span[text()='Last Month']");
	private By radBtnCustomDateRange = By.xpath("//span[text()='Custom Date Range']");
	private By btnExport = By.xpath("(//button[text()='Export'])[2]");
	private By btnReserveExport = By.xpath("(//button[text()='Export'])[2]");
	private By drpdwnDefault = By.xpath("(//div[text()='Default (8)'])[1]");
	private By drpdwnCustom = By.xpath("//div[text()='Custom']");
	private By chckbxReferenceId = By.xpath("//span[text()='Reference ID']");
	private By chckbxAmount = By.xpath("//span[text()='Amount']");
	private By chckbxDateTime = By.xpath("(//span[text()='Date & Time'])[1]");
	private By chckbxType = By.xpath("//span[text()='Type']");
	private By chckbxBalance = By.xpath("(//span[text()='Balance'])[1]");
	private By chckbxStatus = By.xpath("(//span[text()='Status'])[1]");
	private By chckbxDescription = By.xpath("(//span[text()='Description'])[1]");
	private By lnkDeselectAll = By.xpath("//span[text()='Deselect All']");
	private By lblHeading = By.cssSelector(".modal__header__infos__title");
	private By lblExportHeading = By.xpath("//h3[text()='Export Rolling Releases']");
	private By btnclose = By.xpath("//button[text()='Close']");
	private By pagetitle = By.xpath("//h2[text()='Your Export is Being Prepared']");
	private By lnkExportPage = By.xpath("//strong[@class='underline cursor-pointer text-cbl5']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Export Selected Transactions ");
	}

	public void verifyReserveExportHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblExportHeading, expHeading, "Export Selected Transactions ");
	}

	public void clickExportPage() {
		click(lnkExportPage, "ExportPage");
	}

	public void verifyTitle(String expHeading) {
		new CommonFunctions().verifyLabelText(pagetitle, "Exportpage  heading", expHeading);
	}

	public void clickExportPageLink() {
		click(lnkExportPage, "Export Page");
	}

	public void clickClose() {
		click(btnclose, "Close");
	}

	public void clickOnToday() {
		click(radBtnToday, "Click Today");
	}

	public void clickOnYesterday() {
		click(radBtnYesterday, "Click Yesterday");
	}

	public void clickOn7Days() {
		click(radBtn7Days, "Click 7Days");
	}

	public void clickMonthTODate() {
		click(radBtnMonthToDate, "Click MonthTODate");
	}

	public void clickOnLastMonth() {
		click(radBtnLastMonth, "Click LastMonth");
	}

	public void clickCustomDateRange() {
		click(radBtnCustomDateRange, "Click CustomDateRange");
	}

	public void clickOnExport() {
		if (getElement(btnExport, "Enabled").isEnabled()) {
			click(btnExport, "Export");
		} else {
			ExtentTestManager.setPassMessageInReport("Export button is Disabled");
		}

	}

	public void clickOnReserveExport() {
		click(btnReserveExport, "Export");
	}

	public void clickOnReferenceIdCheckBox() {
		if (!verifyElementSelected(chckbxReferenceId, "ReferenceId is Not Checked"))
			;
		click(chckbxReferenceId, "ReferenceId Checked");
	}

	public void clickOnAmountCheckBox() {
		if (!verifyElementSelected(chckbxAmount, "Amount is Not Checked"))
			;
		click(chckbxAmount, "Amount Checked");
	}

	public void clickOnDateTimeCheckBox() {
		if (!verifyElementSelected(chckbxDateTime, "DateTime is Not Checked"))
			;
		click(chckbxDateTime, "DateTime Checked");
	}

	public void clickOnTypeCheckBox() {
		if (!verifyElementSelected(chckbxType, "Type is Not Checked"))
			;
		click(chckbxType, "Type Checked");
	}

	public void clickOnBalanceCheckBox() {
		if (!verifyElementSelected(chckbxBalance, "Balance is Not Checked"))
			;
		click(chckbxBalance, "Balance Checked");
	}

	public void clickOnStatusCheckBox() {
		if (!verifyElementSelected(chckbxStatus, "Status is Not Checked"))
			;
		click(chckbxStatus, "Status Checked");
	}

	public void clickOnDescriptionCheckBox() {
		if (!verifyElementSelected(chckbxDescription, "Description is Not Checked"))
			;
		click(chckbxDescription, "Description Checked");
	}

	public void clickOnDeselectAll() {
		click(lnkDeselectAll, "Click DeselectAll");
	}

	public void selectDefaut(String Default) {

		click(drpdwnDefault, "Default");

		new CommonFunctions().selectCustomDropDown(Default, "Default");
	}

	public void selectCustom(String Custom) {

		click(drpdwnCustom, "Custom");

		new CommonFunctions().selectCustomDropDown(Custom, "Custom");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public FilterCalenderComponent filterCalenderComponent() {
		return new FilterCalenderComponent();
	}

}