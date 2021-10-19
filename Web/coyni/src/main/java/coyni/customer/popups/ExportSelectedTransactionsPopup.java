package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ExportSelectedTransactionsPopup extends BrowserFunctions{
	
	private By radBtnToday = By.cssSelector("");
	private By radBtnYesterday = By.cssSelector("");
	private By radBtn7Days = By.cssSelector("");
	private By radBtnMonthToDate = By.cssSelector("");
	private By radBtnLastMonth = By.cssSelector("");
	private By radBtnCustomDate = By.cssSelector("");
	private By btnCurrentFilter = By.cssSelector("");
	private By btnExport = By.cssSelector("");
	private By drpdwnDefault = By.cssSelector("");
	private By drpdwnCustom = By.cssSelector("");
	private By chckbxReferenceId = By.cssSelector("");
	private By chckbxAmount = By.cssSelector("");
	private By chckbxDateTime = By.cssSelector("");
	private By chckbxType = By.cssSelector("");
	private By chckbxBalance = By.cssSelector("");
	private By chckbxStatus = By.cssSelector("");
	private By chckbxDescription = By.cssSelector("");
	private By lnkDeselectAll = By.cssSelector("");
	
	
	
	
	public void clickOnToday() {
		click(radBtnToday,"Click Today");
	}
	public void clickOnYesterday() {
		click(radBtnYesterday,"Click Yesterday");
	}
	public void clickOn7Days() {
		click(radBtn7Days,"Click 7Days");
	}
	public void clickMonthTODate() {
		click(radBtnMonthToDate,"Click MonthTODate");
	}
	public void clickOnLastMonth() {
		click(radBtnLastMonth,"Click LastMonth");
	}
	public void clickOnCustomDate() {
		click(radBtnCustomDate,"Click CustomDate");
	}
	public void clickOnCurrentFilter() {
		click(btnCurrentFilter,"Click CurrentFilter");
	}
	public void clickOnExport() {
		click(btnExport,"Click Export");
	}
	public void clickOnReferenceIdCheckBox() {
        if(!verifyElementSelected(chckbxReferenceId, "ReferenceId is Not Checked"));
        click(chckbxReferenceId, "ReferenceId Checked");
	}
	public void clickOnAmountCheckBox() {
        if(!verifyElementSelected(chckbxAmount, "Amount is Not Checked"));
        click(chckbxAmount, "Amount Checked");
	}
	public void clickOnDateTimeCheckBox() {
        if(!verifyElementSelected(chckbxDateTime, "DateTime is Not Checked"));
        click(chckbxDateTime, "DateTime Checked");
	}
	public void clickOnTypeCheckBox() {
        if(!verifyElementSelected(chckbxType, "Type is Not Checked"));
        click(chckbxType, "Type Checked");
	}
	public void clickOnBalanceCheckBox() {
        if(!verifyElementSelected(chckbxBalance, "Balance is Not Checked"));
        click(chckbxBalance, "Balance Checked");
	}
	public void clickOnStatusCheckBox() {
        if(!verifyElementSelected(chckbxStatus, "Status is Not Checked"));
        click(chckbxStatus, "Status Checked");
	}
	public void clickOnDescriptionCheckBox() {
        if(!verifyElementSelected(chckbxDescription, "Description is Not Checked"));
        click(chckbxDescription, "Description Checked");
	}
	public void clickOnDeselectAll() {
		click(lnkDeselectAll,"Click DeselectAll");
	}
	public void selectDefaut(String Default) {
		
		click(drpdwnDefault, "Default");
		
		new CommonFunctions().selectCustomDropDown(Default, "Default");
	}
    public void selectCustom(String Custom) {
		
		click(drpdwnCustom, "Custom");
		
		new CommonFunctions().selectCustomDropDown(Custom, "Custom");
	}
}