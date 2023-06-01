package coyni.admin.components;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import coyni.admin.popups.AddAdditionalDocumentsPopup;
import coyni.admin.popups.AddRevisionTaskPopup;
import coyni.admin.popups.ApproveCasePopup;
import coyni.admin.popups.DeclineCasePopup;
import coyni.admin.popups.WithdrawCasePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingCaseDetailsComponent extends BrowserFunctions {

	private By heading = By.xpath("//div[contains(@class,'breadcrumb')]");
	private By lblAccountStatus = By.xpath("//div[contains(text(),'Account ID:')]");
	private By lblMerchantAccountStatus = By.xpath("(//div[contains(@class,'chip__text--orange ')])");

	private By lblCaseIdNumber = By.xpath("//p[contains(@class,'PersonalCaseIdDetails')]");
	private By lblCaseID = By.xpath("//p[contains(@class,'CaseIdDetails_CaseHeader')]");
	private By lblPhoneNumber = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[1]");
	private By lblEmail = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[2]");
	private By lblSSN = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[3]");
	private By lblDateOfBirth = By.xpath("(//div[contains(@class,'PersonalCaseIdDetails_tableBorder')]//span)[4]");
	private By btnDownload = By.xpath("//div[contains(@class,'icon-Download')]");
	private By btnDriversLicense = By.xpath("//button[contains(@class,'PersonalCaseIdDetails_AgreeCard')]");
	private By headingDriversLicence = By.xpath("//span[contains(text(),'DRIVERS_LICENSE')]");
	private By btnDownloadPDF = By.xpath("//button[contains(text(),'Download PDF')]");
	private By btnClose = By.xpath("//div[contains(@class,'icon-close')]");
	private By lblStatus = By.xpath("//div[contains(@class,'CaseIdDetails_chipStyle')]//div");
	private By btnAssignePlus = By.xpath("//div[contains(@class,'MultiSelectAsignee_plus')]");
	private By btnAprrove = By.xpath("//button[text()='Approve']");
	private By lblDate = By.xpath("//span[contains(text(),'Timestamp')]/following-sibling::span");
	private By lblMerchantDate = By.xpath("//p[contains(@class,'font-bold text-cgy4 ')]");
	private By lblDueDate = By.xpath("//p[contains(text(),'@ ')]");
	private By lstAssineNames = By.xpath("//div[@class='w-[135px] truncate ml-2']");
	private By lblAssigneName = By.xpath("//div[contains(text(),'Prajwal')]");
	private By lblMerchantAssigneName = By.xpath("//div[contains(text(),'Santosh')]");

	private By txtAssigneName = By.xpath("");
	private By btnHide = By.xpath("//span[contains(text(),'Hide')]");
	private By btnAddNewTaskForDocuments = By
			.xpath("//p[text()='Require Additional Documents']/following-sibling::button");
	private By btnAddNewTaskForWebsite = By.xpath("//p[text()='Require Website Changes']/following-sibling::button");
	private By btnAdd = By.xpath("//button[text()='Add']");
	private By lblMerchantCaseID = By.xpath("//p[contains(@class,'CaseIdDetails_CaseHeader__7jlV7 pb-5')]");
	private By txtMerchantAccountID = By.xpath("(//span[contains(@class,'CaseIdDetails_account_id')])[1]");
	private By lblMerchantPhoneNumber = By.xpath("(//span[contains(@class,'CaseIdDetails_hoverDiv__blLFt')])[2]");
	private By lblMerchantEmail = By.xpath("//span[contains(@class,'CaseIdDetails_hoverDiv__blLFt break-words')]");
	private By txtMessage = By.xpath("//textarea[@name='notemessage']");
	private By btnSend = By.xpath("//button[text()='Send']");
	private By btnUnderwritingsMerchant = By.xpath("//div[@class='breadcrumb']/a");
	private By btnFilter = By.xpath("//button[text()='Filter']");
	private By txtcaseID = By.xpath("//input[@name='caseId']");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");
	private By lblPending = By.xpath("//div[text()='Pending']");
	private By lblCheckListStatus = By.xpath("//p[text()='Updated']");
	private By btnDownloadChcklst = By.xpath("//div[@data-tip='Download']");
	private By btnDownloadChcklst1 = By.xpath("(//div[@data-tip='Download'])[2]");
	// private By btnAcceptAdditionalDocument = By.xpath("(//div[contains(@class,'
	// CaseIdDetails_acceptIcon')]//img)[1]");
	private By btnAcceptAdditionalDocument1 = By.xpath("(//img[contains(@src,'green-circle-icon')])[2]");
	private By btnAcceptWebsiteChanges = By.xpath("(//img[contains(@src,'green-circle-icon')])[3]");
	private By btnAcceptWebsiteChanges1 = By.xpath("(//img[contains(@src,'green-circle-icon')])[4]");
	private By lblFinalStatus = By.xpath("//p[text()='Closed']");
	private By btnDecline = By.xpath("//button[text()='Decline']");
	private By drpdwnChooseReason = By.xpath("//div[contains(@class,'FormField_selected_option')]");
	private By btnWithdraw = By.xpath("//button[text()='Withdraw']");
	private By btnCross = By.xpath("//img[contains(@src,'cross-red')]");
	private By lblCompnayName = By.xpath("//p[text()='Company Name']/following-sibling::span");// span//div[contains(@class,'icon-edit')]
	private By btnEdit = By
			.xpath("//p[text()='Company Name']/following-sibling::span//div[contains(@class,'icon-edit')]");
	private By btnDBAInfo = By.xpath("//button[text()='DBA Info']");
	private By btnEditWebsite = By.xpath("(//div[contains(@class,'icon-edit')])[2]");
	private By lblWebsite = By.xpath("//span[text()='mywebsite.com']");
	private By btnAcceptAdditionalDocument = By.xpath(
			"(//div[contains(@class,'CaseIdDetails_AdditionalRequiredDocs')])[1]/descendant::img[contains(@src,'success-green-circle-icon')]");
	private By eleAddtlDocmts = By.xpath("(//div[contains(@class,'CaseIdDetails_AdditionalRequiredDocs')])[1]");
	private By eleWebsite = By.xpath("(//div[contains(@class,'CaseIdDetails_AdditionalRequiredDocs__Vz8ti')])[1]");
	private By btnWebsiteDoc = By.xpath(
			"(//div[contains(@class,'CaseIdDetails_acceptIcon__9EcTK')])[1]/descendant::img[contains(@src,'success-green-circle-icon')]");
	
	private By getTableItems(String elementName) {
    	return By.xpath(String.format("//span[contains(text(),'No')]", elementName));
    }
    
    public int noPersonalData() {
		int size = getElementsList(getTableItems("No Personal Data Found"), "").size();
		return size;
	}
    public int noMerchantData() {
    	int size = getElementsList(getTableItems("No Merchant Data Found"), "").size();
    	return size;
    }
    public int noApiBusinessData() {
    	int size = getElementsList(getTableItems("No Api Business Data Found"), "").size();
    	return size;
    }

	public void clickEditButton() {
		moveToElement(btnEditWebsite, "WebSite");
		click(btnEditWebsite, "Edit WebSite");
	}

	public void clickAcceptAdditionalDoc() {
		moveToElement(eleAddtlDocmts, "Required Documents");
		click(btnAcceptAdditionalDocument, "Green Accept Tick");
	}

	public void clickAcceptAdditionalDoc1() {
		// APPROACH 1
//		scrollToElement(eleAddtlDocmts, "document");

		// APPROACH 2
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("window.scrollBy(800,100);");

		// APPROACH 3
//		Actions action=new Actions(DriverFactory.getDriver());
//		action.moveByOffset(0, 550).build().perform();

		moveToElement(eleAddtlDocmts, "Required Documents");
		click(btnAcceptAdditionalDocument, "Green Accept Tick");

	}

	public void clickDBAInfo() {
		click(btnDBAInfo, "DBA Info");
	}

	public void clickDropDown() {
		click(drpdwnChooseReason, "Choose a reason");
	}

	public void clickEditCompanyName() {
		moveToElement(lblCompnayName, "Company");
		click(btnEdit, "Edit");
	}

	public void clickDecline() {
		click(btnDecline, "Declline");
	}

	public String verifyDate() {
		String str = getText(lblDate, "Date");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		ExtentTestManager.setInfoMessageInReport("Date is " + str1);
		return str1;
	}

	public String verifyMerchantDate() {
		String str = getText(lblMerchantDate, "Date");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceFirst(" ", "");
		ExtentTestManager.setInfoMessageInReport("Date is " + str2);
		return str2;
	}

	public String VerifyMerchantCaseStatus() {
		String str = getText(lblMerchantAccountStatus, "New");
		ExtentTestManager.setInfoMessageInReport("the status is " + str);
		return str;
	}

	public void clickApprove() {
		click(btnAprrove, "Approve");
	}

	public String verifyCaseId() {
		String str = getText(lblCaseID, "Csae Id");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport(str1);
		return str1;
	}

	public String verifyMerchantCaseId() {
		String str = getText(lblMerchantCaseID, "Csae Id");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport(str1);
		return str1;
	}

	public void verifyPhoneNumber(String expPhoneNumber) {
		String str = getText(lblPhoneNumber, "PhoneNumber");
		ExtentTestManager.setInfoMessageInReport("the phone Number is" + str);
		if (str.equals(expPhoneNumber)) {
			ExtentTestManager.setPassMessageInReport("The phone number is matched");
		} else {
			ExtentTestManager.setWarningMessageInReport("the Phone number is not matched");
		}

	}

	public void verifyMerchantPhoneNumber() {
		String str = getText(lblMerchantPhoneNumber, "PhoneNumber");
		ExtentTestManager.setInfoMessageInReport("the phone Number is" + str);

	}

	public void verifyEmail(String expEmail) {
		String str = getText(lblEmail, "Email");
		ExtentTestManager.setInfoMessageInReport("the email is" + str);
		if (str.equals(expEmail)) {
			ExtentTestManager.setPassMessageInReport("The email is matched");
		} else {
			ExtentTestManager.setWarningMessageInReport("the email is not matched");
		}

	}

	public void verifyMerchantEmail() {
		String str = getText(lblMerchantEmail, "Email");
		ExtentTestManager.setInfoMessageInReport("the email is" + str);
	}

	public void verifySSNNumber(String expSSNNumber) {
		String str = getText(lblSSN, "SSNNumber");
		ExtentTestManager.setInfoMessageInReport("the SSN Number is" + str);
		if (str.equals(expSSNNumber)) {
			ExtentTestManager.setPassMessageInReport("The SSN number is matched");
		} else {
			ExtentTestManager.setWarningMessageInReport("the SSN number is not matched");
		}

	}

	public void verifyDateOfBirth(String expDateOfBirth) {
		String str = getText(lblDateOfBirth, "DateOfBirth");
		ExtentTestManager.setInfoMessageInReport("the DateOfBirth is" + str);
		if (str.equals(expDateOfBirth)) {
			ExtentTestManager.setPassMessageInReport("The DateOfBirth is matched");
		} else {
			ExtentTestManager.setWarningMessageInReport("the DateOfBirth is not matched");
		}

	}

	public String verifyCaseIDNumber() {
		String str = getText(lblCaseIdNumber, "CaseIDNumber");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is " + str1);
		return str1;
	}

	public String verifyCustomerID() {
		String str = getText(lblAccountStatus, "CaseIDNumber");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is " + str1);
		return str1;
	}

	public String verifyMerchantID() {
		String str = getText(txtMerchantAccountID, "CaseIDNumber");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceAll(":", "");
		String str3 = str2.replaceAll(" ", "");
		String str4 = "M" + str3;
		ExtentTestManager.setInfoMessageInReport("Case ID Number is " + str4);
		return str4;
	}

	public String verifyMerchantIDForReserve() {
		String str = getText(txtMerchantAccountID, "CaseIDNumber");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceAll(":", "");
		String str3 = str2.replaceAll(" ", "");
		String str4 = str3.replaceAll("-", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is " + str4);
		return str4;
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
		ExtentTestManager.setInfoMessageInReport("the status is " + str);
		return str;
	}

	public void verifyFinalStatus() {
		String str = getText(lblFinalStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("The final case status is " + str);
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
		ExtentTestManager.setInfoMessageInReport("Due Date is " + str);
		return str;
	}

	public String verifyMerchantDueDate() {
		String str = getText(lblDueDate, "DueDate");
		ExtentTestManager.setInfoMessageInReport("Due Date is " + str);
		return str;
	}

	public void verifyListofAssignes() {
		List<WebElement> lst = getElementsList(lstAssineNames, "List of Assigne Names");
		int k = lst.size();
		for (int i = 0; i < k; i++) {
			WebElement str = lst.get(i);
			String str1 = str.getText();
			ExtentTestManager.setInfoMessageInReport(str1);
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
		click(btnHide, "Hide");
	}

	public void clickAddNewTaskForDocumets() {
		click(btnAddNewTaskForDocuments, "Add New Task for Documets");
	}

	public void clickAddNewTaskForWebsite() {
		click(btnAddNewTaskForWebsite, "Add New Task for Website");
	}

	public void enterMessageToUser(String expMessage) {
		enterText(txtMessage, expMessage, "Message to user");
	}

	public void clickSend() {
		click(btnSend, "Send");
	}

	public void verifyCheckListStatus() {
		String str = getText(lblCheckListStatus, "");
		ExtentTestManager.setInfoMessageInReport("The Required Chcek List Status is" + str);
	}

	public void clickDownloadCheckList() {
		click(btnDownloadChcklst, "Download");
	}

	public void clickDowloadCheckList1() {
		click(btnDownloadChcklst1, "Download Check list");
	}

	public void clickUnderWritingsMerchant() {
		click(btnUnderwritingsMerchant, "UnderWritings Merchant");
	}

	public AddAdditionalDocumentsPopup addAdditionalDocumentsPopup() {
		return new AddAdditionalDocumentsPopup();
	}

	public ApproveCasePopup approveCasePopup() {
		return new ApproveCasePopup();
	}

	public void clickFilter() {
		click(btnFilter, "filter");
	}

	public void clickWithdraw() {
		moveToElement(btnWithdraw, "Withdraw");
		click(btnWithdraw, "Withdraw");
	}

	public void clickRedCross() {
		click(btnCross, "Red Cross");
	}

	public void enterCaseID(String expCaseID) {
		enterText(txtcaseID, expCaseID, "Case ID");
	}

	public void clickApplyFilters() {
		click(btnApplyFilters, "Apply Filters");
	}

	public void verifyStatus() {
		verifyElementDisplayed(lblPending, "Pending");
		ExtentTestManager.setInfoMessageInReport("The Status is Pending");
	}

//	public void clickAcceptAdditionalDoc() {
//		click(btnAcceptAdditionalDocument, "Green Accept Tick");
//	}

//	public void clickAcceptAdditionalDoc1() {
//		moveToElement(btnAcceptAdditionalDocument1, "Required Documents");
//		click(btnAcceptAdditionalDocument1, "Green Accept Tick");
//	}

	public void clickAcceptWebsiteChanges() {
		moveToElement(btnAcceptWebsiteChanges, "Wibesite changes");
		click(btnAcceptWebsiteChanges, "Green Accept Tick");
	}

	public void clickAcceptWebsiteChanges1() {
		moveToElement(btnAcceptWebsiteChanges1, "Wibesite changes");
		click(btnAcceptWebsiteChanges1, "Green Accept Tick");
	}

	public DeclineCasePopup declineCasePopup() {
		return new DeclineCasePopup();
	}

	public WithdrawCasePopup withdrawCasePopup() {
		return new WithdrawCasePopup();
	}

	public AddRevisionTaskPopup addRevisionTaskPopup() {
		return new AddRevisionTaskPopup();
	}
	
	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

}