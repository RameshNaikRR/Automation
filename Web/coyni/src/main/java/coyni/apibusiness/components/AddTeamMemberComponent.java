package coyni.apibusiness.components;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.api.business.popups.AddCustomRolePopup;
import coyni.api.business.popups.FiltersPage;
import coyni.api.business.popups.SaveChangePopUp;
import coyni.apibusiness.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class AddTeamMemberComponent extends BrowserFunctions {
	private By lblAddTeam = By.xpath("(//span[text()='Add New Team Member'])[2]");
	private By btnAddTeam = By.xpath("(//button[text()='Add New Team Member'])");
	private By txtFirstName = By.xpath("//input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By txtEmail = By.xpath("//input[@name='email']");
	private By txtPhone = By.xpath("//input[@name='phoneNumber']");
	private By lnkAddRole = By.xpath("//span[text()='Add Role']");
	private By txtedit = By.xpath("//span[text()='Edit']");
	private By txtCancel = By.xpath("//span[text()='Cancel']");
	private By txtSave = By.xpath("//span[text()='Save']");
	private By btnAdminRole = By.xpath("//p[text()='Admin']");

	private By getUserPermissions(String permissions) {
		return By.xpath(String.format("(//div[contains(@class,'react-toggle-track-x')])[%s]", permissions));
	}

	public void verifyTokenWalletAccess() {
//		new CommonFunctions().elementView(getUserPermissions("1"), "Token Wallet Access");
		click(getUserPermissions("1"), "Token Wallet Access");
	}

	public void verifyTransferToken() {
		new CommonFunctions().elementView(getUserPermissions("1"), "Transfer Token");
		click(getUserPermissions("2"), "Transfer Token");
	}

	public void verifyBuyToken() {
		new CommonFunctions().elementView(getUserPermissions("2"), "Buy Token");
		click(getUserPermissions("3"), "Buy Token");
	}

	public void verifyWithdrawToken() {
		new CommonFunctions().elementView(getUserPermissions("3"), "Withdraw Token");
		click(getUserPermissions("4"), "Withdraw Token");
	}

	public void verifyEcosystemActivity() {
		new CommonFunctions().elementView(getUserPermissions("4"), "Ecosystem Activity");
		click(getUserPermissions("5"), "Ecosystem Activity");
	}

	public void verifyExportedFiles() {
		new CommonFunctions().elementView(getUserPermissions("5"), "Exported Files");
		click(getUserPermissions("6"), "Exported Files");
	}

	public void verifyBusinessSettings() {
		new CommonFunctions().elementView(getUserPermissions("6"), "Business Settings");
		click(getUserPermissions("7"), "Business Settings");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddTeam, "Add New Team", expHeading);
	}

	public void clickAddTeam() {
		click(btnAddTeam, "Add Team Member");
	}

	public void verifyFirstName(String name) {
		enterText(txtFirstName, name, "Name");
	}

	public void verifyLastName(String lastName) {
		enterText(txtLastName, lastName, "LastName");
	}

	public void verifyEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void verifyPhone(String Phone) {
		enterText(txtPhone, Phone, "Phone");
	}

	public void clickAddRole() {
		click(lnkAddRole, "Add Role");
	}

	public void clickEdit() {
		click(txtedit, "Edit");
	}

	public void clickCancel() {
		click(txtCancel, "Cancel");
	}

	public void clickSave() {
		click(txtSave, "Save");
	}
	
	public void clickAdminRole() {
		click(btnAdminRole, "Admin Role");
	}
	

	public void getUserPermission(String option, String eleName) {
		By options = By.xpath("//div[@class='TeamNewMember_add_role__hYYn2 px-2 py-3']/div");
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		boolean status = false;
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(options, "options");
		for (WebElement optionEle : optionsEles) {
			if (optionEle.getText().equalsIgnoreCase(option)) {
				optionEle.click();
				status = true;

				if (status) {
					ExtentTestManager.setInfoMessageInReport(option + " selected from" + eleName + "  List");
					break;
				} else {
					ExtentTestManager.setInfoMessageInReport(option + " not available in " + eleName + " List");
					clickAddRole();
					break;
				}
			}
		}
	}

	public AddCustomRolePopup addCustomRolePopup() {
		return new AddCustomRolePopup();
	}

	public SaveChangePopUp saveChangePopUp() {
		return new SaveChangePopUp();
	}

	public FiltersPage filtersPage() {
		return new FiltersPage();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public TeamComponent teamComponent() {
		return new TeamComponent();
	}

}
