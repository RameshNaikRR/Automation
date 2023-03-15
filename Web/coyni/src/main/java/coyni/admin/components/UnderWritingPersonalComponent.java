package coyni.admin.components;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingPersonalComponent extends BrowserFunctions {
	
	private By btnNew = By.xpath("(//div[contains(@class,'BusinessUsers_sub_fixfont__J5psl')])[2]");
	private By btnrow = By.xpath("//tr[@class='  businessRow mb-0']");
	private By lblCaseId = By.xpath("//tr//td[contains(@class,'id')]");
	private By lblDate = By.xpath("//tr//td[contains(@class,'updatedDate')]");
	private By lblMerchantDate = By.xpath("//div[contains(@class,'font-s')]");
	private By lblCustomerId = By.xpath("//tr//td[contains(@class,'customerId')]");
	private By lblMerchantId = By.xpath("(//tr[@class='  businessRow mb-0']//td)[3]");
	private By lblCustomerName = By.xpath("//tr//td[contains(@class,'customerFullName')]");
	private By lblDueDate = By.xpath("//div[contains(@class,'PersonalUsers_dueFont')]");
    private By lblHeading = By.xpath("//span[text()='Underwriting - Personal']");
    private By btnInReview = By.xpath("//button//div[contains(text(),'In Review')]");
    private By lblUnderwritingMerchnat = By.xpath("//span[text()='Underwriting - Merchant']");
	private By lblCaseStatus = By.xpath("(//tr[@class='  businessRow mb-0']//td)[5]");
	private By lblMerchantDueDate = By.xpath("//div[contains(@class,'font-semibold BusinessUsers_dueFont__j4wD5')]");
	private By btnPending = By.xpath("//button//div[contains(text(),'Pending')]");
	
	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Heading");
	}
	public void verifyUnderwritingMerchantHeading() {
		new CommonFunctions().elementView(lblUnderwritingMerchnat, "Heading");
	}
	public void clickNew() {
		click(btnNew, "Click New");
	}
	public void clickCustomer() {
		click(btnrow, "Click Customer");
	}
	
	public String verifyCaseID() {
		String str = getText(lblCaseId, "CaseId");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case id is " + str1);
		return str1;
	}
	
	public String verifyDate() {
		String str = getText(lblDate, "Date");
		ExtentTestManager.setInfoMessageInReport("Date is" + str);
		return str;
	}
	
	public String verifyMerchantDate() {
		String str = getText(lblMerchantDate, "Date");
		ExtentTestManager.setInfoMessageInReport("Date is" + str);
		return str;
	}
	public String verifyCustomerID() {
		String str = getText(lblCustomerId, "CustomerId");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Custmoer id is " + str1);
		return str1;
	}
	public String verifyMerchantID() {
		String str = getText(lblMerchantId, "MerchantId");
		//String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Merchant id is " + str);
		return str;
	}
	
	public String verifyCustomerName() {
		String str = getText(lblCustomerName, "Customer Name");
		ExtentTestManager.setInfoMessageInReport("Customer Name is" + str);
		return str;
	}
	
	public String verifyCaseStatus() {
		String str = getText(lblCaseStatus, "Case Status");
		ExtentTestManager.setInfoMessageInReport("Case Status is" + str);
		return str;
	}
	
	public String verifyDueDate() {
		String str = getText(lblDueDate, "Due Date");
		ExtentTestManager.setInfoMessageInReport("Due Date is" + str);
		return str;
	}
	public String verifyMerchantDueDate() {
		String str = getText(lblMerchantDueDate, "Due Date");
		ExtentTestManager.setInfoMessageInReport("Due Date is" + str);
		return str;
	}
	
	public UnderWritingCaseDetailsComponent underWritingCaseDetailsComponent() {
		return new UnderWritingCaseDetailsComponent();
	}
	
	public void clickInReview() {
		click(btnInReview, "In Review");
	}
	
	public void clickPending() {
		click(btnPending, "Pending");
	}
	public void openMerchantPortal() {
    	WebDriver driver =  DriverFactory.getDriver();
        try {	
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("window.open('https://members-qa.coyni.com/choose-account','Merchant portal');");
        ExtentTestManager.setPassMessageInReport("Merchant portal launched successfully");
    }
    catch(Exception e){
        ExtentTestManager.setFailMessageInReport(e+ "launching Merchant portal site is failed");
    }
	}
    public void switchToYopmailWindow() {
        String gmailWindow = DriverFactory.getDriver().getWindowHandle();
        Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
        for (String string : windowHandles) {
            if (!string.equals(gmailWindow)) {
                DriverFactory.getDriver().switchTo().window(string);
                ExtentTestManager.setPassMessageInReport("Switched to Merchant portal");
                break;
            }
        }
    }
    public void switchBackToAdmin() throws InterruptedException {
    	WebDriver driver =  DriverFactory.getDriver();
    	try {
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("window.open('https://members-qa.coyni.com/choose-account','Merchant portal');");
        ExtentTestManager.setPassMessageInReport("yopmail launched successfully");
        }
        catch(Exception e){
        ExtentTestManager.setFailMessageInReport(e+ "launching yopmail site is failed");
        }
        String gmailWindow = DriverFactory.getDriver().getWindowHandle();
        Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
        for (String string : windowHandles) {
            if (!string.equals(gmailWindow)) {
                DriverFactory.getDriver().switchTo().window(string);
                ExtentTestManager.setPassMessageInReport("*Switched back to Admin portal*");
                break;
            }
        }
        
		
    }

	
	
	
	

	
       	

}
