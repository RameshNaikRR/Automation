package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ProfileComponent extends BrowserFunctions {

	private By lblPersonalHeading = By.xpath("//span[contains(text(),'Personal')]");
	private By txtSearch = By.xpath("//input[contains(@class,'search-bar')]");
	private By btnFilter = By.cssSelector("//div[@class='flex flex-row mr-5']");
	private By btnExport = By.cssSelector("");
	private By btnSearchIcon = By.cssSelector(".icon-search");
	private By btnNewEmployee = By.xpath("//button[.='New Employee']");
	private By lblSearchBar = By.xpath("//input[@placeholder='Search by Name, Email, or Phone']");
	private By lblSearchIcon = By.xpath("//button[@class='icon-search']");
	private By btnSearch = By.xpath("//button[@class='icon-search']");
	private By lblNoRecordFound = By.xpath("//span[contains(text(),'No Records Found')]");

	private By lblApiBusiness = By.xpath("//p[text()='API Business']");

	public void clickApiBusiness() {
		click(lblApiBusiness, "Api Business");
	}

	public void verifyNoRecords() {
		new CommonFunctions().elementView(lblNoRecordFound, "No record found");
	}
	
	public void verifyPersonalHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPersonalHeading, "Page Heading ", expHeading);
	}

	public void fillSearch(String text) {
		enterText(txtSearch, text, "Search");
        click(btnSearch,"Serach");
	}
	private By txtSearchMerchant = By.xpath("//input[contains(@class,' BusinessProfiles_search_bar_gbox__fDkrE')]");
	public void fillSearchForMerchantDetails(String text) {
		enterText(txtSearchMerchant, text, "Search");
        click(btnSearch,"Serach");
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

	public CreateNewApiBusinessUser createNewApiBusinessUser() {
		return new CreateNewApiBusinessUser();
	}

	public SideBarApiBusinessComponent sideBarApiBusinessComponent() {
		return new SideBarApiBusinessComponent();
	}

	private By lblApiBusinessDetails = By.xpath("(//tr[contains(@class,'  businessRow mb-0')])[1]");

	public void clickUser() {
		click(lblApiBusinessDetails, "User");
	}

}
