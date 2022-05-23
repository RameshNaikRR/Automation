package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ColumnsSelectedTransactions extends BrowserFunctions {
//	private By btnCustomDetails = By.xpath("//span[text()='%s']//preceding-sibling::input[@type='checkbox']");
	private By btnExport = By.xpath("//button[text()='Export']");
	private By lnkDeselectAll=By.xpath("//span[text()='Deselect All']");
	private By getCustomDetails(String HeadingNum) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input[@type='checkbox']", HeadingNum));
	}

	public void clickAccountBalance() {
		click(getCustomDetails("Account Balance"), "Account Balance");
	}
	public void clickUserType() {
		click(getCustomDetails("User Type"), "User Type");
		
	}
	public void clickDeselectAll() {
		click(lnkDeselectAll, "DeselectAll");
	}
	public void clickuserID() {
		click(getCustomDetails("userID"), "userID");
	}
	public void clickExport() {
		click(btnExport, "export");
	}
	public void clickCheckBox(String checkBox) {
		By checkCheckBoxes = By.xpath(String
		.format("//input[@type='checkbox']/following::span[text()='%s']/preceding-sibling::input", checkBox));
		click(checkCheckBoxes, checkBox + "Check Box ");
		}
}
