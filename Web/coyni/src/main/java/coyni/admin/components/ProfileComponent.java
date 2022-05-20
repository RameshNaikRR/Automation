package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ProfileComponent extends BrowserFunctions {
	
	private By lblHeading = By.cssSelector("");
	private By txtSearch  = By.cssSelector("input[class*='search_bar']");
	private By btnFilter =By.cssSelector("//div[@class='flex flex-row mr-5']");
	private By btnExport =By.cssSelector("");
	private By btnSearchIcon = By.cssSelector(".icon-search");
	private By btnNewEmployee = By.xpath("//button[.='New Employee']");
	private By lblSearchBar = By.xpath("//input[@placeholder='Search by Name, Email, or Phone']");
	private By lblSearchIcon = By.xpath("//button[@class='icon-search']");

	 
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading ", expHeading);
	}
	public void fillSearch(String text) {
		enterText(txtSearch, text, "Search");
	}
	public void clickFilter() {
		click(btnFilter, "Filter");
	}
	public void clickExport() {
		click(btnExport, "Export");
	}
	public void clickSearchIcon() {
		click(btnSearchIcon, "Search Icon");
	}
	public void clickAddNewEmployee() {
		click(btnNewEmployee, "New Employee");
	}
	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}
	public void verifySearchLables() {
		new CommonFunctions().elementView(lblSearchBar, "Search Bar lable");
		new CommonFunctions().elementView(lblSearchIcon, "Search Icon");
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
