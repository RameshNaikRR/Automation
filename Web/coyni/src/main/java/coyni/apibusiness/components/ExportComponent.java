package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class ExportComponent extends BrowserFunctions {
	BrowserFunctions objBrowserFunctions = new BrowserFunctions();
	private By btnPopupExport = By.xpath("(//button[text()='Export'])[2]");
	private By btnExport = By.xpath("(//button[text()='Export'])[1]");
	private By lblExportSelectedOptions = By.xpath("//h3[text()='Export Selected Transactions']");
	private By lblDateRange = By.xpath("//h3[text()='Date Range']");
	private By lblColumns = By.xpath("//h3[text()='Columns']");
	private By txtStartDate = By.xpath("//span[text()='Start Date']");
	private By txtEndDate = By.xpath("//span[text()='End Date']");
	private By txtReceiver = By.xpath("//span[text()='Receiver']");
	private By txtSender = By.xpath("//span[text()='Sender']");
	private By imgDropdown = By.xpath("//div[text()='Default (10)']/following-sibling::img");
	private By lnkCustom = By.xpath("//span[text()='Custom']");
	private By lnkDeselectAll = By.xpath("//span[text()='Deselect All']");
	private By lblDefault10 = By.xpath("//div[text()='Default (10)']");
	private By txtdefault10Desc = By.xpath("//p[@class='export-modal__default-column-label']");
	private By lblpopuphdng = By.xpath("//h2[text()='Your Export is Being Prepared']");
	private By lnkExportPage = By.xpath("//strong[text()='Export page.']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By popuphdngDesc = By.xpath("//span[@class='text-sm text-cgy3']");
	private By lblDefault8 = By.xpath("//div[text()='Default (8)']");
	private By lblexportbeingPrepared = By.xpath("//h2[text()='Your Export is Being Prepared']");
	private By description = By.xpath("//span[@class='text-sm text-cgy3']");

	public void verifyPopupHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblpopuphdng, "heading", "heading");
	}

	public void verifyPopupHeadingView() {
		new CommonFunctions().elementView(popuphdngDesc, "Export popup description");
	}

	public void clickExportPage() {
		click(lnkExportPage, "Export Page");
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(btnClose, "Close");
		String str = getElement(btnClose, "").getCssValue("color");
		ExtentTestManager.setPassMessageInReport(str);
		click(btnClose, "close");
	}

	public void exportBeingPrepared() {
		String str = getText(lblexportbeingPrepared, "Export Being Prepared");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void exportBeingPrepareddescription() {
		String str = getText(description, "Export Being Prepared Description");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyStartDate(String expectedDate) {
		String actualDate = getText(txtStartDate, "start Date");
		if (actualDate.equals(expectedDate)) {
			ExtentTestManager.setPassMessageInReport("start Date is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("start Date is not verified");
		}
	}

	public void verifyEndDate(String expectedDate) {
		String actualDate = getText(txtEndDate, "end Date");
		if (actualDate.equals(expectedDate)) {
			ExtentTestManager.setPassMessageInReport("End date is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("End Date is not verified");
		}
	}

	public By getToggleInputs(String text) {
		return By.xpath(String.format("//span[text()='%s']/preceding-sibling::input", text));
	}

	public void clickToggleInputs(String text) {
		click(getToggleInputs(text), text);
	}

//	public By getExportCheckBoxes(String text) {
//		return By.xpath(String.format("(//span[text()='%s'])[2]/preceding-sibling::input", text));
//	}
	public By getExportCheckBoxes(String text) {
		return By.xpath(String.format("//input[@type='checkbox']", text));
	}

	public void ClickSelectAllCheckboxes() {
		try {
			By options = By.xpath("//input[@type='checkbox']");
			boolean status = false;
			objBrowserFunctions.waitForElement(options, BrowserFunctions.waittime, WaitForElement.presence);
			List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
			for (WebElement optionEle : optionsEles) {
				optionEle.click();
				status = true;
			}
			if (status) {
				ExtentTestManager.setInfoMessageInReport("All checkBoxes are selected");
			} else {
				ExtentTestManager.setFailMessageInReport("CheckBox  is not selected");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("select custom drop down failed due to exception " + e);
		}
	}

	public void clickExportCheckBoxes(String text) {
		click(getExportCheckBoxes(text), text);
	}

	public void verifyDefault10View() {
		String str = getText(lblDefault10, "Default 10");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().verifyCursorAction(lblDefault10, "Default 10");
		new CommonFunctions().elementView(txtdefault10Desc, "description");
		click(lblDefault10, "Default(10)");
	}

	public void verifyDefault8View() {
		new CommonFunctions().elementView(lblDefault8, "Default(8)");
	}

	public void clickDateandTimeChkbx() {
		click(getExportCheckBoxes("Date & Time "), "Date & Time");
	}

	public void verifyDateandTimeChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Date & Time"), "Date & Time");
	}

	public void clickReferenceIDChkbx() {
		click(getExportCheckBoxes("Reference ID"), "Reference ID");
	}

	public void verifyReferenceIDChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Reference ID"), "Reference ID");
	}

	public void clickTypeChkbx() {
		click(getExportCheckBoxes("Type"), "Type");
	}

	public void verifyTypeChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Type"), "Type");
	}

	public void clickSubTypeChkbx() {
		click(getExportCheckBoxes("SubType"), "SubType");
	}

	public void verifySubTypeChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("SubType"), "SubType");
	}

	public void clickDescriptionChkbx() {
		click(getExportCheckBoxes("Description"), "Description");
	}

	public void verifyDescriptionChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Description"), "Description");
	}

	public void clickAmountChkbx() {
		click(getExportCheckBoxes("Amount"), "Amount");
	}

	public void verifyAmountChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Amount"), "Amount");
	}

	public void clickBalanceChkbx() {
		click(getExportCheckBoxes("Balance"), "Balance");
	}

	public void verifyBalanceChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Balance"), "Balance");
	}

	public void clickStatusChkbx() {
		click(getExportCheckBoxes("Status"), "Status");
	}

	public void verifyStatusChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Status"), "Status");
	}

	public void clickReceiverChkbx() {
		click(getExportCheckBoxes("Receiver"), "Receiver");
	}

	public void verifyReceiverChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Receiver"), "Receiver");
	}

	public void clickSenderChkbx() {
		click(getExportCheckBoxes("Sender"), "Sender");
	}

	public void verifySenderChkbxView() {
		new CommonFunctions().elementView(getExportCheckBoxes("Sender"), "Sender");
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void clickPopupExport() {
		if (getElement(btnPopupExport, "Export").isEnabled()) {
			click(btnPopupExport, "Export ");
		} else {
			ExtentTestManager.setPassMessageInReport("Export button is in disabled mode");
		}
	}

	public void verifyExportBackgroundColor(String expColour) {
		new CommonFunctions().verifyTextBoxBorderColor(expColour);
	}

	public void verifyExportCursorAction() {
		new CommonFunctions().verifyCursorAction(btnExport, "Export");
	}

	public void verifyExportsSelectedOptionsView() {
		new CommonFunctions().elementView(lblExportSelectedOptions, "Export selected Options");
	}

	public void verifyDateRangeView() {
		new CommonFunctions().elementView(lblDateRange, "Date Range");
	}

	public void verifyColumnsView() {
		new CommonFunctions().elementView(lblColumns, "Columns");
	}

	public void clickToday() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Today"), "Today");
		String str = getElement(getToggleInputs("Today"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Today"), "Today");
	}

	public void verifyTodayView() {
		new CommonFunctions().elementView(getToggleInputs("Today"), "Today");
	}

	public void clickYesterday() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Yesterday"), "Yesterday");
		String str = getElement(getToggleInputs("Yesterday"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Yesterday"), "Yesterday");
	}

	public void verifyYesterdayView() {
		new CommonFunctions().elementView(getToggleInputs("Yesterday"), "Yesterday");
	}

	public void clickLast7Days() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Last 7 Days"), "Last 7 Days");
		String str = getElement(getToggleInputs("Last 7 Days"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Last 7 Days"), "Last 7 Days");
	}

	public void verifyLast7DatsView() {
		new CommonFunctions().elementView(getToggleInputs("Last 7 Days"), "Last 7 Days");
	}

	public void clickMonthtoDate() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Month to Date"), "Month to Date");
		String str = getElement(getToggleInputs("Month to Date"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Month to Date"), "Month to Date");
	}

	public void verifyMonthtoDateView() {
		new CommonFunctions().elementView(getToggleInputs("Month to Date"), "Month to Date");
	}

	public void clickLastMonth() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Last Month"), "Last Month");
		String str = getElement(getToggleInputs("Last Month"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Last Month"), "Last Month");
	}

	public void verifyLastMonthView() {
		new CommonFunctions().elementView(getToggleInputs("Last Month"), "Last Month");
	}

	public void clickCustomDateRange() {
		new CommonFunctions().verifyCursorAction(getToggleInputs("Custom Date Range"), "Custom Date Range");
		String str = getElement(getToggleInputs("Custom Date Range"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getToggleInputs("Custom Date Range"), "Custom Date Range");
	}

	public void verifyCustomDateRangeView() {
		new CommonFunctions().elementView(getToggleInputs("Custom Date Range"), "Custom Date Range");
	}

	public void clickStartDate() {
		new CommonFunctions().verifyCursorAction(txtStartDate, "startDate");
		click(txtStartDate, "startDate");
	}

	public void clickimgDropdown() {
		click(imgDropdown, "Dropdown");
	}

	public void clickCustom() {
		// new CommonFunctions().verifyMouseHoverAction(lnkCustom, "Custom",
		// getPageTitle(), getCopiedData());
		moveToElement(lnkCustom, "Moved to custom");
		new CommonFunctions().verifyCursorAction(lnkCustom, "Custom");
		click(lnkCustom, "Custom");
	}

	public void clickDeselectAll() {
		click(lnkDeselectAll, "Deselect All");
	}

	public void verifyDeselectAllView() {
		new CommonFunctions().elementView(lnkDeselectAll, "Deselect All");
	}

	public void verifyDefault10Desc(String description) {
		new CommonFunctions().verifyLabelText(txtdefault10Desc, "description", "description");
	}

	public void verifyDefault8Desc() {
		String str = getText(txtdefault10Desc, "Default 8");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(txtdefault10Desc, "description");
		click(lblDefault8, "Default(8)");
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

}
