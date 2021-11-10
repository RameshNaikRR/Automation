package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.customer.popups.AccountProfileImagePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class UserDetailsComponent extends BrowserFunctions{
	
	private By lblUserDetailsHeading =By.cssSelector("");
	
	private By btnEditUserImage =By.cssSelector("");
	
	private By lnkRemoveImage = By.cssSelector("");
	
	private By btnRemove =By.cssSelector("");
	
	private By btnUploadNewImage =By.cssSelector("");
	
	private By btnSave =By.cssSelector("");
	
    private By lblUserName =By.cssSelector("");
    
    private By lblAccountStatus =By.cssSelector("");
    
    private By lblEmail =By.cssSelector("");
    
    private By lblAddress =By.cssSelector("");
    
    private By lnkEditAccountEmail =By.cssSelector("");
    
    private By lnkEditAccountPhNum =By.cssSelector("");
    
    private By lnkEditAccountAddress=By.cssSelector("");
    
    private By iconEditEmail =By.cssSelector("");
    
    private By iconEditPhNum =By.cssSelector("");
    
    private By iconEditAddress =By.cssSelector("");
    
    private By lblAccountID =By.cssSelector("");
    
    private By lblPhoneNumber =By.cssSelector("");
    
    public void clickEditUserImage() {
    	click(btnEditUserImage, "Edit User Image");
    }
    public void clickRemoveImage() {
    	click(lnkRemoveImage, "Remove Image");
    }
    public void clickRemove() {
    	click(btnRemove, "Remove Button");
    }
    public void clickUploadNewImage() {
    click(btnUploadNewImage, "Upload New Image Button");
    }
    
    public void clickSave() {
    	click(btnSave, "Save Button");
    }
    public void verifyUserName(String expUserName) {
    	new CommonFunctions().verifyLabelText(lblUserName, "UserName", expUserName);
    }
    
    public void verifyAccountStatus(String expAccountStatus) {
    	new CommonFunctions().verifyLabelText(lblAccountStatus, "Account Status", expAccountStatus);
    }
    
    public void verifyEmail(String expEmail) {
    	new CommonFunctions().verifyLabelText(lblEmail, "Email", expEmail);
    }
    
    public void verifyAddress(String expAddress) {
    	new CommonFunctions().verifyLabelText(lblAddress, "Address", expAddress);
    }
    public void clickEditAccountEmail() {
    	click(lnkEditAccountEmail, "Click Edit Email");
    }
    public void clickEditAccountPhNumber() {
    	click(lnkEditAccountPhNum, "Click Edit PhoneNumber");
    }
    public void clickEditAccountAddress() {
    	click(lnkEditAccountAddress, "Click Edit Address");
    }
    public void clickIconEditEmail() {
    	click(iconEditEmail, "Click Edit Email Icon");
    }
    public void clickIconEditPhNum() {
    	click(iconEditPhNum, "Click Edit Phone Icon");
    }
    public void clickIconEditAddress() {
    	click(iconEditAddress, "Click Edit Address Icon");
    	
    }
    public void verifyUserDetailsView() {
		new CommonFunctions().elementView(lblUserDetailsHeading, " User Details ");
	}

    public void verifyUserNameView() {
    	new CommonFunctions().elementView(lblUserName, "User Name ");
    }
    public void verifyAccountStatusView() {
    	new CommonFunctions().elementView(lblAccountStatus, "Account Status");
    }
    
    public void verifyAccountIDView() {
    	new CommonFunctions().elementView(lblAccountID, "Account ID ");
    }
    public void verifyPhoneNumberView() {
    	new CommonFunctions().elementView(lblPhoneNumber, "Phone Number ");
    }
    public void verifyEmailView() {
    	new CommonFunctions().elementView(lblEmail, "Email ");
    }
    
    public void verifyAddressView() {
    	new CommonFunctions().elementView(lblAddress, "Address ");
    }
    
    public void verifyEditImageView() {
    	new CommonFunctions().elementView(btnEditUserImage, "Edit user Image");
    }
    
    public MailingAddressComponent mailingAddressComponent() {
    	return new MailingAddressComponent();
    }
    public ToastComponent toastComponent() {
    	return new ToastComponent();
    }
    public NotificationsComponent notificationsComponent() {
    	return new NotificationsComponent();
    }
   public AccountProfileImagePopup accountProfileImagePopup() {
	   return new AccountProfileImagePopup();
   }
    }


