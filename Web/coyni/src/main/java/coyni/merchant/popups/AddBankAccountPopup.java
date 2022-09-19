package coyni.merchant.popups;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class AddBankAccountPopup<E> extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[.='Add Bank Account']");
	private By btnIamReady = By.xpath("//button[contains(text(),'Ready')]");
	private By lblDoNotNavigate = By.xpath("//h2[contains(.,'Do Not')]");
	private By lblDescription = By.xpath("//p[contains(.,'coyni uses')]");
	private By lblDescription1 = By.xpath("//p[contains(.,'Please complete')]");
	private By lnkLearnMore = By.xpath("//strong[.='Learn More']");

	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By btnBack = By.cssSelector(" ");
	private By headingNewPage = By.xpath("//h1[contains(text(),'Add Accounts')]");
//	private By headingAddBankAccount = By.xpath("//h1[contains(text(),'Add Bank Account')]");
	private By lnkBankName = By.xpath("(//div[@class='autoResultBankName'])[1]");
	private By txtUserName = By.xpath("//label[.='UserName']/following-sibling::input[1]");
	private By txtPassword = By.xpath("//input[@type='password']");
	private By btnNext = By.xpath("(//span[text()='Next'])[1]");
	private By chckbox = By.xpath("//div[contains(@class,'custom-checkbox')]");
//	private By chckBoxBank1 = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
//	private By chckBoxBank2 = By.xpath("(//div[@class='custom-control custom-checkbox'])[2]");

	public void verifyHeading() {
		String text = getText(lblHeading, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyFiservBankDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyLnkLearnMore() {
		new CommonFunctions().elementView(lnkLearnMore, "Learn more link ");
	}

	public void clickLearnMore() {
		click(lnkLearnMore, "Learm More");
	}

	public void clickIamReady() {
		click(btnIamReady, "click IamReady");
	}

	public void verifyDoNotNavigateLbl() {
		String text = getText(lblDoNotNavigate, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyDescription() {
		String text = getText(lblDescription1, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}

	public void verifyNewWindowHeading() {
		new CommonFunctions().elementView(headingNewPage, "Heading New Page");
	}

	public void enterBankName(String expBanName) {
		click(txtBankName, "");
		enterText(txtBankName, expBanName, "Bank Name");
	}

	public void clickOnBankName() {
		click(lnkBankName, "Bank Name");
	}

	public void enterUserName(String expUserName) {
		enterText(txtUserName, expUserName, "User Name");
//		click(txtPassword, "Password");
	}

	public void enterPassword(String expPassword) {
		enterText(txtPassword, expPassword, " Password");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public void unSelectBank() {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.loader")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
		List<WebElement> List = getElementsList(chckbox, "");
		int size = List.size();
		if (size == 1) {
			ExtentTestManager.setInfoMessageInReport("We have only one bank");
			Object[] windowHandles = driver.getWindowHandles().toArray();
			driver.close();
			driver.switchTo().window(windowHandles[0].toString());
		} else {
			List.get(0).click();
			ExtentTestManager.setInfoMessageInReport("Unselected the extra bank");
			click(btnNext, "Click Next");
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			Object[] windowHandles = driver.getWindowHandles().toArray();
			driver.switchTo().window(windowHandles[0].toString());
		}
	}

	public void clickUncheckBank() {
		click(btnNext, "Click Next");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
