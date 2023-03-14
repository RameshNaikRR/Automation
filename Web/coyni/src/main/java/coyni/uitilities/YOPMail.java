package coyni.uitilities;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class YOPMail extends BrowserFunctions {
	private By txtLogin = By.id("login");
	private By txtTempPswd = By.xpath("(//p[@style='line-height: 1.6em; padding: 0 3em'])[2]");
	private By iframe = By.xpath("//iframe[@name='ifmail']");
	private By btnLogout = By.xpath("//span[text()='power_settings_new']");
	private By txtEmail = By.id("email");
	private By btnContinue = By.xpath("//button[@id='tn-submit-button']/span");
	private By txtPassword = By.id("password");
	private By txtNewPassword = By.xpath("//div[@data-testid='Input']/input[@name='password']");
	private By txtconfirmPassword = By.name("confirm");
	private By btnResetPswd = By.xpath("//span[text()='Reset Password']");
	private By ckboxLicense = By.xpath("//span[text()='I accept the End User License Agreement ']");
	private By btnAccept = By.xpath("//span[text()='Accept']");
	private By lblfirstname = By.xpath("//font[contains(text(),'Dear')] | //font[contains(text(),'Congratulations ')]");
	private By clkActivateAcc = By.xpath("//u[text()=' Activate Account '] |  //u[text()=' coyni get started page ']");

	public void openYopMail() {
		WebDriver driver = DriverFactory.getDriver();
		try {
			System.out.println("open YOP try");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.open('https://yopmail.fr/en/','YopMail');");
			ExtentTestManager.setPassMessageInReport("yopmail launched successfully");
		} catch (Throwable e) {
			System.out.println("open YOP catch");
			System.out.println(e);
			ExtentTestManager.setFailMessageInReport(e + "launching yopmail site is failed");
		}
	}

	public void switchToYopmailWindow() {
		String coyniTab = DriverFactory.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String string : windowHandles) {
			if (!string.equals(coyniTab)) {
//				String yopmailTab=string;
				DriverFactory.getDriver().close();
				ExtentTestManager.setInfoMessageInReport("Closed the current wondow Tab");
				DriverFactory.getDriver().switchTo().window(string);
				ExtentTestManager.setPassMessageInReport("Switched to yopmailWindow");
				break;
			}
		}
	}

	public void clickActivateAccount(String yopmail, String firstname)
			throws InterruptedException, AWTException {
		waitForElement(txtLogin, waittime, WaitForElement.presence);
		click(txtLogin, "Login");
		enterText(txtLogin, yopmail, "Login");
		Thread.sleep(2000);
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		switchToFrame(iframe, "iframe");
		String fname = getText(lblfirstname, "first name");
		System.out.println(fname);
		String infomsg = fname.contains(firstname) ? "Opened Invitation mail" : "Invitation mail not displayed";
		ExtentTestManager.setInfoMessageInReport(infomsg);
		
		click(clkActivateAcc, "Acivate Account");
		Thread.sleep(3000);
		
		String yopMailTab = DriverFactory.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String string : windowHandles) {
			if (!string.equals(yopMailTab)) {
				DriverFactory.getDriver().close();
				ExtentTestManager.setInfoMessageInReport("Closed the current wondow Tab");
				DriverFactory.getDriver().switchTo().window(string);
				ExtentTestManager.setPassMessageInReport("Switched to Coyni Activate Account Tab");
				break;
			}
		}
	}
}
