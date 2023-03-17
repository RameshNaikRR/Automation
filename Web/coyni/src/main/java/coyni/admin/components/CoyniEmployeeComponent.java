package coyni.admin.components;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import coyni.admin.pages.EmployeeDetailsPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CoyniEmployeeComponent extends BrowserFunctions {

	private By btnNewEmployee=By.xpath("//button[text()='New Employee']");
	private By txtSearch=By.xpath("//input[@placeholder='Search by Name, Email or Phone']");
	private By lblEmpID=By.xpath("//td[@class='cell-col-0']");
	private By lblAccStatus=By.xpath("//div[contains(@class,'chip__text')]");
	private By btnSubmitSearch=By.xpath("//button[@type='submit']");
	private By btnYES=By.xpath("//button[text()='Yes']");
	
	
	
	private By getXpath(String filterName) {
		return By.xpath(String.format("//input[@type='checkbox'][@value='%s']", filterName));
	}
	
	public void clickNewEmployeeBtn() {
		new CommonFunctions().verifyCursorAction(btnNewEmployee, "new Employee Button");
		click(btnNewEmployee, "new Employee Button");
		
	}
	public AddNewEmployeeComponent addNewEmployeeComponent() {
		return new AddNewEmployeeComponent();
	}
	
	public void clickOnFiltersBtn() {
		new FilterComponent().clickFilters();
	}

	/**
	 * parameter <b>filterName</b> must be matched with the filter names available in coyni employee page.<br>
	 * for an example: <ul>Active, Expired, Deactivated, Administrator, Underwriting, Development, Accounting etc.</ul>
	 * @param filterName
	 */
	public void selectFilter(String filterName) {
		
		try {
			String filtername = StringUtils.capitalize(filterName.trim());
			click(getXpath(filtername),"clicked on filter "+filtername);
		} catch (Exception e) {
			ExtentTestManager.setWarningMessageInReport(String.format("click filter for %s failed due to "+e, filterName));
		}
	}
	
	private String getYOPMail() {
		return new AddNewEmployeeComponent().getYOPMail();
	}
	//FOR SEARCH WE ARE USING YOPMAIL FOR UNIQUENESS
	public void fillSearch() {
		enterText(txtSearch, getYOPMail(), "search field");	
		click(btnSubmitSearch, "submit search");
	}
	public void clickEmployeeDetails() {
		click(lblEmpID, "coyni employee");
	}
	public void verifyPhoneNumber(String phone) {
		String phoneNum = new EmployeeDetailsPage().getPhoneNum();
		String info = phoneNum.equals(phone.trim()) ? "phone number is matched " : "phone number is not matched";
		ExtentTestManager.setInfoMessageInReport(info);
	}
	public void verifyEmail() {
		String infoMsg = (new EmployeeDetailsPage().getPhoneNum()).equalsIgnoreCase(getYOPMail().trim()) ? "email is matched " : "email is not matched";
		ExtentTestManager.setInfoMessageInReport(infoMsg);
	}
	public void verifyEmpID() {
		String infoMsg=(getText(lblEmpID, "emp ID").trim().equalsIgnoreCase(new EmployeeDetailsPage().getEmpID().trim()))?"employee Id is matching":"employee id is not matching";
		ExtentTestManager.setInfoMessageInReport(infoMsg);
	}
	public void verifyAccStatus() {
		String infoMsg=new EmployeeDetailsPage().getAccStatus().trim().contains(getText(lblAccStatus, "").trim())?"Account status is matched":"Account status is not matched";
		ExtentTestManager.setInfoMessageInReport(infoMsg);
	}
	public void clickCancelOrRemoveUser() throws InterruptedException {
		Thread.sleep(5000);
		new EmployeeDetailsPage().clickRemoveUser();
		click(btnYES, "Yes Button");
	}
	public void verifyCancelledAccStatus() {
		String infoMsg=getText(lblAccStatus, "Account status").trim().contains("Cancelled")?"Invitation cancelled":"Invitation not cancelled";
		ExtentTestManager.setInfoMessageInReport(infoMsg);
	}
	
	
}
