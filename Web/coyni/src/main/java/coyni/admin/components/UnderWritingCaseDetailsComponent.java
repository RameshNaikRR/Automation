package coyni.admin.components;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.popups.AddAdditionalDocumentsPopup;
import coyni.admin.popups.ApproveCasePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingCaseDetailsComponent extends BrowserFunctions {

	private By heading = By.xpath("//div[contains(@class,'breadcrumb')]");
	private By lblAccountStatus = By.xpath("//div[contains(text(),'Account ID:')]");
	private By lblMerchantAccountStatus = By.xpath("(//div[contains(@class,'chip__text--orange ')])");
	
	private By lblCaseIdNumber = By.xpath("//p[contains(@class,'PersonalCaseIdDetails')]");
	private By lblCaseID = By.xpath("//p[contains(@class,'PersonalCaseIdDetails_CaseHeader')]");
	private By lblPhoneNumber = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[1]");
	private By lblEmail = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[2]");
	private By lblSSN = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[3]");
	private By lblDateOfBirth = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[4]");
	private By btnDownload = By.xpath("//div[contains(@class,'icon-Download')]");
	private By btnDriversLicense = By.xpath("//button[contains(@class,'PersonalCaseIdDetails_AgreeCard')]");
	private By headingDriversLicence = By.xpath("//span[contains(text(),'DRIVERS_LICENSE')]");
	private By btnDownloadPDF = By.xpath("//button[contains(text(),'Download PDF')]");
	private By btnClose = By.xpath("//div[contains(@class,'icon-close')]");
	private By lblStatus = By.xpath("//div[contains(@class,'PersonalCaseIdDetails_chipStyle')]//div");
	private By btnAssignePlus = By.xpath("//div[contains(@class,'MultiSelectAsignee_plus')]");
	private By btnAprrove = By.xpath("//span[text()='Approve']");
	private By lblDate = By.xpath("//span[contains(text(),'Timestamp')]/following-sibling::span");
	private By lblMerchantDate = By.xpath("//p[contains(@class,'font-bold text-cgy4 ')]");
	private By lblDueDate = By.xpath("//p[contains(text(),'@ ')]"); 
	private By lstAssineNames = By.xpath("//div[contains(@style,'padding-top: 4%')]");
	private By lblAssigneName = By.xpath("//div[contains(text(),'Prajwal')]");
	private By lblMerchantAssigneName = By.xpath("//div[contains(text(),'Santosh Pa...')]");
	
	private By txtAssigneName = By.xpath("");
	private By btnHide = By.xpath("//span[contains(text(),'Hide')]");
    private By btnAddNewTask = By.xpath("//span[text()='Add New Task']");
    private By lblMerchantCaseID = By.xpath("//p[contains(@class,'CaseIdDetails_CaseHeader__7jlV7 pb-5')]");
    private By txtMerchantAccountID = By.xpath("//div[text()='New']");
    private By lblMerchantPhoneNumber = By.xpath("(//span[contains(@class,'CaseIdDetails_hoverDiv__blLFt')])[2]");
    private By lblMerchantEmail = By.xpath("//span[contains(@class,'CaseIdDetails_hoverDiv__blLFt break-words')]");
	
	
	public String verifyDate() {
		String str = getText(lblDate, "Date");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		ExtentTestManager.setInfoMessageInReport("Date is " + str1);
		return str1;
	}
	
	public String verifyMerchantDate() {
		String str = getText(lblMerchantDate, "Date");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		ExtentTestManager.setInfoMessageInReport("Date is " + str1);
		return str1;
	}
	public String VerifyMerchantCaseStatus() {
		 String str = getText(lblMerchantAccountStatus, "New");
		 ExtentTestManager.setInfoMessageInReport("the status is "+ str);
	      return str;
	}
	
	public void clickApprove() {
		click(btnAprrove, "Approve");
	}
	
    public String verifyCaseId() {
    	String str = getText(lblCaseID, "Csae Id");
    	String str1 = str.replaceAll("[^0-9]","");
        ExtentTestManager.setInfoMessageInReport(str1);
        return str1;
    }
    public String verifyMerchantCaseId() {
    	String str = getText(lblMerchantCaseID, "Csae Id");
    	String str1 = str.replaceAll("[^0-9]","");
        ExtentTestManager.setInfoMessageInReport(str1);
        return str1;
    }
	
	
	public void verifyPhoneNumber(String expPhoneNumber) {
		String str = getText(lblPhoneNumber, "PhoneNumber");
		ExtentTestManager.setInfoMessageInReport("the phone Number is"+str);
		if(str.equals(expPhoneNumber)) { 
			ExtentTestManager.setPassMessageInReport("The phone number is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the Phone number is not matched");
		}
		
	}
	public void verifyMerchantPhoneNumber(String expPhoneNumber) {
		String str = getText(lblMerchantPhoneNumber, "PhoneNumber");
		ExtentTestManager.setInfoMessageInReport("the phone Number is"+str);
		if(str.equals(expPhoneNumber)) { 
			ExtentTestManager.setPassMessageInReport("The phone number is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the Phone number is not matched");
		}
		
	}


	public void verifyEmail(String expEmail) {
		String str = getText(lblEmail, "Email");
		ExtentTestManager.setInfoMessageInReport("the email is"+str);
		if(str.equals(expEmail)) { 
			ExtentTestManager.setPassMessageInReport("The email is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the email is not matched");
		}
		
	}
	public void verifyMerchantEmail(String expEmail) {
		String str = getText(lblMerchantEmail, "Email");
		ExtentTestManager.setInfoMessageInReport("the email is"+str);
		if(str.equals(expEmail)) { 
			ExtentTestManager.setPassMessageInReport("The email is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the email is not matched");
		}
		
	}


	public void verifySSNNumber(String expSSNNumber) {
		String str = getText(lblSSN, "SSNNumber");
		ExtentTestManager.setInfoMessageInReport("the SSN Number is"+str);
		if(str.equals(expSSNNumber)) { 
			ExtentTestManager.setPassMessageInReport("The SSN number is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the SSN number is not matched");
		}
		
	}

	public void verifyDateOfBirth(String expDateOfBirth) {
		String str = getText(lblDateOfBirth, "DateOfBirth");
		ExtentTestManager.setInfoMessageInReport("the DateOfBirth is"+str);
		if(str.equals(expDateOfBirth)) { 
			ExtentTestManager.setPassMessageInReport("The DateOfBirth is matched");
		}
		else {
			ExtentTestManager.setWarningMessageInReport("the DateOfBirth is not matched");
		}
		
	}

	
	
	
	
	public String verifyCaseIDNumber() {
		String str = getText(lblCaseIdNumber, "CaseIDNumber");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is "+ str1);
        return str1;  	
	}
	
	public String verifyCustomerID() {
		String str = getText(lblAccountStatus, "CaseIDNumber");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is "+ str1);
        return str1;  	
	}
	public String verifyMerchantID() {
		String str = getText(txtMerchantAccountID, "CaseIDNumber");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is "+ str1);
        return str1;  	
	}
	
	
	public void verifyDownloadDriversLicense() throws InterruptedException {
		click(btnDriversLicense, "DriversLicence");
		Thread.sleep(2000);
		new CommonFunctions().elementView(headingDriversLicence, "Drivers_License");
		click(btnDownloadPDF, "Download pdf");
		Thread.sleep(2000);
		click(btnClose, "Close");
		new CommonFunctions().elementView(btnDownload, "Download");
	    click(btnDownload, "Download");	
	 	}
	
	public String verifyCaseStatus() {
	 String str = getText(lblStatus, "Status");
	 ExtentTestManager.setInfoMessageInReport("the status is "+ str);
      return str;      
	}
	
	public void clickAssignee() {
		click(btnAssignePlus, "Add Assignee");
	}
	
	public String verifyHeading() {
       String str = getText(heading, "heading");
       ExtentTestManager.setInfoMessageInReport("Heading is" + str);
       return str;   
       
	}
	
	public String verifyDueDate() {
		String str = getText(lblDueDate, "DueDate");
		ExtentTestManager.setInfoMessageInReport("Due Date is "+ str);
		return str;
	}
	public String verifyMerchantDueDate() {
		String str = getText(lblDueDate, "DueDate");
		ExtentTestManager.setInfoMessageInReport("Due Date is "+ str);
		return str;
	}
	
	public void verifyListofAssignes() {
        List<WebElement> lst =	getElementsList(lstAssineNames, "List of Assigne Names");
           int k=lst.size();
        for(int i=0; i<k;i++) {
         WebElement str=    lst.get(i); 
       ExtentTestManager.setInfoMessageInReport(str.getText());  
        }
	}
	
	/*
	 * public By getAssigneName(String expAssigneName) { return By.xpath(String.
	 * format("//div[(contains(@style,'padding-top: 4%') and (text(),'%s'))]",
	 * expAssigneName)); }
	 */
	public void selectAssigneName() {
		click(lblAssigneName, "Prajwal");
	}
	public void selectMerchantAssigneName() {
		click(lblMerchantAssigneName, "Sontosh patnala");
	}
	
	public void enterAssigneName(String expAssigneName) {
		enterText(txtAssigneName, expAssigneName, "Assigne Name");
	}
	
	public void clickHide() {
		click(btnHide,"Hide");
	}

	public void clickAddNewTask() {
		click(btnAddNewTask, "Add New Task");
	}
	
	public AddAdditionalDocumentsPopup addAdditionalDocumentsPopup() {
		return new AddAdditionalDocumentsPopup();
	}
	
	public ApproveCasePopup approveCasePopup() {
		return new ApproveCasePopup();
	}
	
		

}