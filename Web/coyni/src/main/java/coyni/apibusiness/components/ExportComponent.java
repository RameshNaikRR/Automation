package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ExportComponent extends BrowserFunctions {
	private By btnExport = By.xpath("//button[text()='Export'] or (//button[text()='Export'])[2]");
	private By lblExportSelectedOptions = By.xpath("//h3[text()='Export Selected Transactions']");
	private By lblDateRange = By.xpath("//h3[text()='Date Range']");
	private By lblColumns = By.xpath("//h3[text()='Columns']");
	private By txtStartDate = By.xpath("//span[text()='Start Date']");
	private By txtEndDate = By.xpath("//span[text()='End Date']");
	private By imgDropdown = By.xpath("//div[text()='Default (8)']/following-sibling::img");
	private By lnkCustom = By.xpath("//div[text()='Custom']");
	private By lnkDeselectAll = By.xpath("//span[text()='Deselect All']");
	private By lblDefault8 = By.xpath("//div[text()='Default (8)']");
	private By txtdefault8Desc  = By.xpath("//p[@class='export-modal__default-column-label']");
    private By lblpopuphdng  = By.xpath("//h2[text()='Your Export is Being Prepared']");
    private By lnkExportPage = By.xpath("//strong[text()='Export page.']");
    private By btnClose = By.xpath("//button[text()='Close']");
    private By popuphdngDesc = By.xpath("//span[@class='text-sm text-cgy3']");
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
    	click(btnClose, "close");
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
	public By getExportCheckBoxes(String text) {
		return By.xpath(String.format("(//span[text()='%s'])[2]/preceding-sibling::input", text));
	}
	public void clickExportCheckBoxes(String text) {
		click(getExportCheckBoxes(text), text);
	}
	public void verifyDefault8View() {
		new CommonFunctions().elementView(lblDefault8, "Default8");
	}
    public void clickDateandTimeChkbx(){
    	click(getExportCheckBoxes("Date & Time"), "Date & Time");
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
	public void clickExport() {
		click(btnExport, "Export");
	}
	public void verifyExportBackgroundColor(String backGround,String border) {
		new CommonFunctions().verifyMouseHoverAction(btnExport, "Export", backGround, border);
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
		click(getToggleInputs("Today"), "Today");
	}
	public void verifyTodayView() {
		new CommonFunctions().elementView(getToggleInputs("Today"), "Today");
	}

	public void clickYesterday() {
		click(getToggleInputs("Yesterday"), "Yesterday");
	}
	public void verifyYesterdayView() {
		new CommonFunctions().elementView(getToggleInputs("Yesterday"), "Yesterday");
	}
	public void clickLast7Days() {
		click(getToggleInputs("Last 7 Days"), "Last 7 Days");
	}
	public void verifyLast7DatsView() {
		new CommonFunctions().elementView(getToggleInputs("Last 7 Days"), "Last 7 Days");
	}
	public void clickMonthtoDate() {
		click(getToggleInputs("Month to Date"), "Month to Date");
	}
	public void verifyMonthtoDateView() {
		new CommonFunctions().elementView(getToggleInputs("Month to Date"), "Month to Date");
	}
	public void clickLastMonth() {
		click(getToggleInputs("Last Month"), "Last Month");
	}
	public void verifyLastMonthView() {
		new CommonFunctions().elementView(getToggleInputs("Last Month"), "Last Month");
	}
	public void clickCustomDateRange() {
		click(getToggleInputs("Custom Date Range"), "Custom Date Range");
	}
	public void verifyCustomDateRangeView() {
		new CommonFunctions().elementView(getToggleInputs("Custom Date Range"), "Custom Date Range");
	}
	public void clickStartDate() {
		click(txtStartDate, "startDate");
	}
	public void clickimgDropdown() {
		click(imgDropdown, "Dropdown");
	}
	public void clickCustom() {
		click(lnkCustom, "Custom");
	}
	public void clickDeselectAll() {
		click(lnkDeselectAll, "Deselect All");
	}
	public void verifyDeselectAllView() {
		new CommonFunctions().elementView(lnkDeselectAll, "Deselect All");
	}
	public void verifyDefault8Desc(String description) {
		new CommonFunctions().verifyLabelText(txtdefault8Desc, "description", "description");
	}
	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}
	
}
