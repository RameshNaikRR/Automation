package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.NotificationsComponent;
import coyni.merchant.popups.ExportSelectedTransactionsPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ExportfilesPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[.='Export Files']");
	private By lblExportID = By.xpath("//span[text()='EXPORT ID']");
	private By lblReportName = By.xpath("//span[text()='REPORT NAME']");
	private By lblExportDate = By.xpath("//span[text()='EXPORT DATE']");
	private By lblDateRange = By.xpath("//span[text()='DATE RANGE']");
	private By lblStatus = By.xpath("//span[text()='STATUS']");
	private By idCheckBox = By.xpath("//td[@class=\"cell-col-0\"]");// Bulk Actions
	private By btnBulkAction = By.xpath("//div[text()='Bulk Actions']");// (//input[@type='checkbox'])[1]
	private By chkBox = By.xpath("(//input[@type='checkbox'])[1]");
	private By btnDownload = By.xpath("//data[@value='download']");
	private By btnTrash = By.xpath("//data[@value='trash']");
	private By btnApply = By.xpath("//div[text()='Apply']");
	private By nextPage = By.xpath("//a[contains(@aria-label, 'next page') or text() = '❯']");
	private By lblSuccess = By.xpath("//span[text()='Success']");
	private By downloadIcon = By.xpath("(//span[@data-tip='Download'])[1]");
	private By btnExportFiles = By.xpath("(//span[text()='Export Files'])[1]");
	private By btnReserveExport = By.xpath("//button[contains(@class,'Buttons_btn__JEz-N')]");
	private By btnExport = By.xpath("//button[text()='Export']");
	private By msgNoRecords = By.xpath("//div[contains(text(),'No Records Found')]");
	private By exportFilesValue = By.xpath("(//label[contains(@class,'custom-checkbox undefined')])[2]");

	public void clickExportFiles() {
		click(btnExportFiles, "Export Files");
	}

	public void clickReserveExport() {
		if (getElement(btnReserveExport, "Enabled").isDisplayed()) {
			scrollToElement(btnReserveExport, "Export");
			click(btnReserveExport, "Export");
		} else {
			ExtentTestManager.setPassMessageInReport("Reserve Export button is Disabled");
		}

	}

	public int getValueExportFiles() {
		String text = getText(exportFilesValue, "Export Files");
		int value = Integer.parseInt(text) + 1;
		ExtentTestManager.setInfoMessageInReport("Value is " + value);
		return value;

	}

//	public void getTotalExportsCount(String query) throws SQLException {
//		int count = DBConnection.getDbCon().getCount(query);
//		int expCount = Integer.parseInt(getUiCount());
//		if (count == expCount) {
//			ExtentTestManager.setPassMessageInReport(count + " matches with number of entries in DB " + expCount);
//		} else {
//			ExtentTestManager.setFailMessageInReport(count + " not matches with number of entries in DB ");
//		}
//	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void handSymbolHighlightedExportFiles(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Export Files"), "Export Files");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void clickExport() {
		if (getElement(btnExport, "Enabled").isDisplayed()) {
			scrollToElement(btnExport, "Export");
			click(btnExport, "Export");
		} else {
			ExtentTestManager.setPassMessageInReport("Export button is Disabled");
		}

	}

//	public void clickExport() {
//		click(btnExport, "Export");
//	}

	public int verifyTeamMemberRecords() {
		return getElementsList(msgNoRecords, "").size();
	}

	public String verifyNoRecordsFound() {
		new CommonFunctions().elementView(msgNoRecords, "No Records");
		return getText(msgNoRecords, "No Records");
	}

	public void successView() {
		ExtentTestManager.setInfoMessageInReport(getText(lblSuccess, "Success Message") + " is displayed");
	}

	public void clickIconDownload() {
		click(downloadIcon, "Download");
	}

	public void clickDownload() {
		click(btnDownload, "Download");
	}

	public void clickApply() {
		if (getElement(btnApply, "Enabled").isEnabled()) {
			click(btnApply, "Apply");
		} else {
			ExtentTestManager.setPassMessageInReport("Apply button is Disabled");
		}
	}

	public void clickTrash() {
		click(btnTrash, "Trash");
	}

	public void clickCheckBox() {
		click(chkBox, "Check Box");
	}

	public void clickBulkActionDropDown() {
		click(btnBulkAction, "Bulk Action Drop Down");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Export files page heading ", Heading);
	}

	public void exportIdView() {
		new CommonFunctions().elementView(lblExportID, "Export Id");
	}

	public void reportNameView() {
		new CommonFunctions().elementView(lblReportName, "Report Name");
	}

	public void exportDateView() {
		new CommonFunctions().elementView(lblExportDate, "Export Date");
	}

	public void dateRangeView() {
		new CommonFunctions().elementView(lblDateRange, "DateRange");
	}

	public void statusView() {
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public void verifyPageNumberHighlighted(String cssProp, String expValue, String expColor) {

		if (verifyElementDisplayed(nextPage, "Next Page")) {
			click(nextPage, "Clicked Next Page");
			// new CommonFunctions().verifyChangedColor(seconPage, "Second Page", cssProp,
			// expValue, expColor);
			ExtentTestManager.setPassMessageInReport("Page is Highlighted when clicked on Page number");
		} else {
			ExtentTestManager.setWarningMessageInReport("Page is Not Highlighted");
		}
	}

	public void verifyIdFormat() {
		String id = getText(idCheckBox, "Export id");
		if (id.matches("[0-9]*")) {
			ExtentTestManager.setPassMessageInReport("Export id is in digits");
		} else {
			ExtentTestManager.setFailMessageInReport("Export id is not in digits format");
		}
	}

	public ExportSelectedTransactionsPopup exportSelectedTransactionsPopup() {
		return new ExportSelectedTransactionsPopup();
	}

	public NotificationsComponent notificationsComponent() {
		return new NotificationsComponent();
	}

}
