package coyni_mobile.pages;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class GiftCardPage extends MobileFunctions {

	private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBox = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By iconCross = MobileBy.xpath(" ");

	private By lblHeading = MobileBy.xpath("//*[@text='Select Your Gift Card']");

	private By lblPopularCard = MobileBy.xpath("//*[@text='Brands']");

	private By lblGiftCardHeading = MobileBy.xpath("//*[@text='Purchase Gift Card']");

	private By imgAmazon = MobileBy.xpath("//*[@text='Amazon.com']");
	private By imgVisa = MobileBy.xpath("//*[contains(@text,'Visa')]");

	private By lnkAmount = MobileBy.id("com.coyni.mapp:id/volET");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/amountET");
	private By txtFirstName = MobileBy.id("com.coyni.mapp:id/firstNameET");
	private By txtLastName = MobileBy.id("com.coyni.mapp:id/lastNameET");
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By btnNext = MobileBy.id("com.coyni.mapp:id/purchaseCV");
	private By btnAdd = MobileBy.id("com.coyni.mapp:id/keyActionLL");

	private By lblheadingOrderPreview = MobileBy.xpath("//*[@text='Order Overview']");//

	private By lblAmazon = MobileBy.xpath("//*[contains(@resource-id,'giftCardTypeTV')]");

	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");
	private By btnSideView = MobileBy.xpath("//*[contains(@resource-id,'tv_lable')]");

	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'giftCardDescTV')]");

	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By lblFees = MobileBy.id("com.coyni.mapp:id/tvFeePer");

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyWithdrawGiftCard(String expHeading) {
		new CommonFunctions().verifyLabelText(lblGiftCardHeading, "Withdraw Gift Card", expHeading);
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expHeading);
	}

	public void verifyOrderPreviewHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblheadingOrderPreview, "Order Overview", expHeading);
	}

	public void verifyAmazonHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmazon, "Amazon", expHeading);
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public void sideBar() {
		swipeOnElement(btnSideView, "Purchase", SwipeDirection.RIGHT);
	}

	public void verifyGiftCardHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Select Your Gift Card", expHeading);
	}

	public void verifyBrandHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPopularCard, "Popular Brands", expHeading);
	}

	public void clickAmazon() {
		click(imgAmazon, "Amazon");
	}

	public void clickVisa() {
		click(imgVisa, "Visa");
	}

	public void fillFirstName(String firstName) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtFirstName, "First Name");
		enterText(txtFirstName, firstName, "First Name");
	}

	public void fillLastName(String lastName) {
		DriverFactory.getDriver().hideKeyboard();
//		click(txtLastName, "Last Name");
		enterText(txtLastName, lastName, "Last Name");
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void clickLastName() {
		scrollDownToElement(txtLastName, "Last Name");
		click(txtLastName, "Last Name");
	}

	public void clickEmail() {
		scrollDownToElement(txtEmail, "Email");
		click(txtEmail, "Email");
	}

	public void fillEmail(String email) {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(txtEmail, "Email");
//		click(txtEmail, "Email");
		enterText(txtEmail, email, "Email");
//		new CommonFunctions().clickTab();
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickAmount() {
		click(lnkAmount, "Amount");
	}

	public void clickAdd() {
		click(btnAdd, "Add");
	}

	public void clickNext() {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(btnNext, "Next");
		new CommonFunctions().clickEnabledElement(btnNext, "Next");
	}

	public void validateNext() {
		new CommonFunctions().verifyDisabledElement(btnNext, "Next");
	}

	public void clickSearch() {
		click(iconSearch, "Search");
	}

	public void fillSearchBox(String userName) {
		enterText(txtSearchBox, userName, "User Name");

	}

	public void clickCross() {
		click(iconCross, "Cross");
	}

	public Double validateProcessingFees() {
		String[] fee1 = getText(lblFees).replace(" ", "").split(":");
		String feeDollars = fee1[1].replace("$", "");
		Double feeDollar = Double.parseDouble(feeDollars);
		DecimalFormat df = new DecimalFormat("#.##");
		double fee = Double.parseDouble(df.format(feeDollar));
		System.out.println(fee);
		return fee;
	}

	public Double validateTotal() {
		Double purchaseAmount = Double.parseDouble(getText(txtAmount));
		Double amount = validateProcessingFees() + purchaseAmount;
		DecimalFormat df = new DecimalFormat("#.##");
		double totalAmount = Double.parseDouble(df.format(amount));
		System.out.println(totalAmount);
		return totalAmount;
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
////	private By lblHeading =MobileBy.xpath("//*[@name='Withdraw Gift Card']");
//	private By lblHeading =MobileBy.AccessibilityId("Withdraw Gift Card");
//	private By pageDes =MobileBy.xpath("//XCUIElementTypeStaticText[@name='Amazon.com']/following-sibling::*[1]");
//	private By visaDesc = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Visa® Prepaid Card USD']/following-sibling::*[1]");
//	private By lblVisaCard = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Visa® Prepaid Card USD']");
//	private By lblAmazon = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Amazon.com']");
//	private By lnkViewAll = MobileBy.xpath("//XCUIElementTypeButton[@name='View all']");
//	private By lnkViewLess = MobileBy.xpath("//XCUIElementTypeButton[@name='View Less']");
//	private By btnReturn = MobileBy.xpath("//*[@name='Return']");
//	
////	private By txtAmount =MobileBy.xpath("//*[@name='Amount']");
//	private By txtAmount =MobileBy.AccessibilityId("Amount");
////	private By txtFirstName = MobileBy.xpath("//*[@name='First Name']");
//	private By txtFirstName = MobileBy.AccessibilityId("First Name");
////	private By txtLastName = MobileBy.xpath("//*[@name='Last Name']");
//	private By txtLastName = MobileBy.AccessibilityId("Last Name");
////	private By txtEmail =MobileBy.xpath("//*[@name='Email']");
//	private By txtEmail =MobileBy.AccessibilityId("Email");
//	private By btnNext =MobileBy.xpath("(//*[@name='Purchase'])[1]");
//	private By lblAvailableBalance = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Available Balance']/following-sibling::*[2]");
//	private By lblErrMsg = MobileBy.xpath("//*[contains(@name,'Amount,    Your transaction')]");
//	
//	
//	
////Select gift Card screen
//	private By lblPurchaseGiftCard =MobileBy.AccessibilityId("Select Your Gift Card");
//	private By iconSearch = MobileBy.xpath(" ");
//	private By txtSearchBox = MobileBy.xpath("(//*[@name='search']/following-sibling::XCUIElementTypeTextField)[2]");
//	private By lblBrands = MobileBy.AccessibilityId("Brands");
//    private By btnAdd = MobileBy.AccessibilityId("");
//    
//    public void clickAdd() {
//    	if(getElement(btnNext, "Add").isEnabled()) {
//    		click(btnNext, "Add");
//    	}else {
//    		ExtentTestManager.setInfoMessageInReport("Next buton is disbaled");
//    	}
//    }
//	
//	
//	
//	public void verifyBrandsView() {
//		new CommonFunctions().elementView(lblBrands, "Brands");
//	}
//	
//	public void verifyPurchaseGiftCardHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblPurchaseGiftCard, "Page Heading ", expHeading);
//	}
//	public void clickSearch() {
//		click(iconSearch,"Search");
//	}
//	public void fillSearchBox(String cardName) {
//	//	click(txtSearchBox, "search icon");
//		enterText(txtSearchBox, cardName, "Search box");
//	}
//	public void clickGiftCard(String cardName) {
//		click(getGiftCard(cardName), "Gift Card");
//	}
//	public By getGiftCard(String cardName) {
//		return MobileBy.xpath(String.format("//*[contains(@name,'%s')]",cardName));
//	}
//	public OrderPreviewPopup orderPreviewPopup() {
//		return new OrderPreviewPopup();
//	}
//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
//	public ChoosePinComponent choosePinComponent() {
//		return new ChoosePinComponent();
//	}
//	
//
//	private float getAmountFromtext(By ele) {
//		String text = getText(ele);
//		System.out.println(text);
//		String texts = text.replace(",","");
//		System.out.println(texts);
//		Pattern pattern = Pattern.compile("\\d+.\\d+");
//		Matcher match = pattern.matcher(texts);
//		while (match.find()) {
//			float amount = Float.parseFloat(match.group());
//			return amount;
//		}
//		return 0.0f;
//	}
//	
//	public void verifyErrMsg(String errMsg) {
//		new CommonFunctions().verifyLabelText(lblErrMsg, "errMsg", errMsg);
//	}
//	
//	
//	public float getAvailableBalance() {
//		
//		//	if(getElementList(lblAvailableBalance, "").size()> 0){
//			return this.getAmountFromtext(lblAvailableBalance);
//		//	}
//		//	return 0;
//		}
//	
//	
//	
//	
//	public void verifyGiftCardDesc() {
//		if(getElementList(lblAmazon, "Amazon").size()>0) {
//			verifyAmazonView();
//		}else {
//			verifyVisaView();
//		}
//		click(lnkViewAll, "View All");
//		click(lnkViewLess, "view less");
//	}
//	
//	
//	public void clickReturn() {
//		click(btnReturn, "return");
//	}
//	public void verifyAmazonView() {
//		new CommonFunctions().elementView(lblAmazon, "Amazon");
//		ExtentTestManager.setInfoMessageInReport("Amazon description is : " + getText(pageDes));
//	}
//	
//	public void verifyVisaView() {
//		new CommonFunctions().elementView(lblVisaCard, "visa card");
//		ExtentTestManager.setInfoMessageInReport("Amazon description is : " + getText(visaDesc));
//	}
//	
//	
//	public void verifyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading ", expHeading);
//	}
//	public void fillAmount(String amount) {
//		enterText(txtAmount, amount, "Amount");
////	//	clickReturn();
////		new CommonFunctions().clickDone();
//	}
//    public void fillFirstName(String firstName) {
//    	scrollDownToElement(txtFirstName, "first Name");
//    	enterText(txtFirstName, firstName, "First Name");
////   // 	clickReturn();
////   	   new CommonFunctions().clickDone();
//    }
//    public void fillLastName(String lastName) {
//    	scrollDownToElement(txtLastName, "Last Name");
//    	enterText(txtLastName, lastName, "Last Name");
////    //	clickReturn();
////    	new CommonFunctions().clickDone();
//    }
//    public void fillEmail(String email) {
//    	scrollDownToElement(txtEmail, "Email");
//    	enterText(txtEmail, email, "Email");
////   // 	clickReturn();
////     	new CommonFunctions().clickDone();
//    }
//    public void clickNext() {
//    	if(getElement(btnNext, "Next").isEnabled()) {
//    		click(btnNext, "Purchase");
//    	}
//    	else {
//    		ExtentTestManager.setInfoMessageInReport("Next button is disabled");
//    	}
//    }
//    
//    public void validateAmount(String amount) {
//		String[] field = amount.split(",");
//		new CommonFunctions().validateField(txtAmount, "amount", field[0]);
//		new CommonFunctions().validateFieldMaxichar(txtAmount, "amount", field[1]);
//	}
//    
//    public void validateFirstNameField(String firstName) {
//		new SignUpPage().validateNameField(txtFirstName, "First Name", firstName);
//	}
//
//	public void validateLastNameField(String LastName) {
//		new SignUpPage().validateNameField(txtLastName, "Last Name", LastName);
//	}
//	public void validateEmail(String email) {
//		new SignUpPage().validateEmail(email);
//	}
////    public OrderOverviewPopup orderOverviewPopup() {
////    	return new OrderOverviewPopup();
////    }

}
