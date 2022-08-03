package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountLimitsPage extends BrowserFunctions{
	private By lbltxtHeading =By.xpath("//span[@class='relative text-base text-cgy4']");
	private By btnYourLimits =By.xpath("//span[text()='Your Limits']");
	private By lbltxtyourLimitsHeading =By.xpath("//p[@class='YourLimits_side_heading__j+dJ9 mt-4']");
	private By btnUserLimits = By.xpath("//span[text()='User Limits']");
	private By lbltxtUserLimitsHeading =By.xpath("//p[@class='UserLimits_side_heading__ggN-t mt-4']");
	private By txtgetFeesCharges = By.xpath("//div[@class='YourLimits_fees__asu3o']");
	private By txtgetLables = By.xpath("//div[@class='flex flex-row gap-3']");
	
	private By yourLimitsLableHeadings = By.xpath("//div[@class='YourLimits_h650__bTiNr flex flex-col']/div[1]");
	
	private By txtUserLimitsLables = By.xpath("//div[@class='flex flex-row gap-3']");
	private By txtUserLimitsLableHeadings = By.xpath("//div[@class='UserLimits_topLabel__lg7Mx']");
	private By txtUserAcountlimits = By.xpath("//div[@class='UserLimits_fees__65eSZ']");

	
	public void clickYourLimits() {
		click(btnYourLimits, "yourLimits");
	}
	public void verifYAccountLimitsHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lbltxtHeading, "Heading", Heading);
	}
	public void verifyYourLimitsHeading(String YourLimitsHeading) {
		new CommonFunctions().verifyLabelText(lbltxtyourLimitsHeading, "YourLimitsHeading", YourLimitsHeading);
	}
	public void verifyYourLimitsLableHeadings() {
		List<WebElement> rows = getElementsList(yourLimitsLableHeadings, "YourLimitsoTpLables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
			
		}
	}
	public void verifyYourLimitsLabels() {
		List<WebElement> rows = getElementsList(txtgetLables, "Lables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
			
		}
	}
	public void verifyYourLimitsAccountlimits() {
		List<WebElement> rows = getElementsList(txtgetFeesCharges, "YourLimitsAccountlimits");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
			
		}
	}
	
	//
	
	public void clickUserLimits() {
		click(btnUserLimits, "UserLimits");
	}
	public void verifyUserLimitsHeading(String UserLimitsHeading) {
		new CommonFunctions().verifyLabelText(lbltxtUserLimitsHeading, "UserLimitsHeading", UserLimitsHeading);
	}
	public void verifyUserLimitsLabels() {
		List<WebElement> rows = getElementsList(txtUserLimitsLables, "Lables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
		
		}
	}
	public void verifyUserLimitsLableHeadings() {
		List<WebElement> rows = getElementsList(txtUserLimitsLableHeadings, "UserLimitsTopLables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
			
		}
	}
	public void verifyUserLimitsAccountlimits() {
		List<WebElement> rows = getElementsList(txtUserAcountlimits, "userLimitsAccountLimits");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");		
		}
	}
	
}
