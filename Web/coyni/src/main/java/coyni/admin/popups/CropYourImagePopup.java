package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class CropYourImagePopup extends BrowserFunctions {

	private By btnSelectImage = By.xpath("");
	private By lblCropYourImageHeading= By.xpath("//h1[text()='Crop Your Image']");
	private By btnSave = By.xpath("//button[contains(text(),'Save')]");
	
	
	public void clickSelectYourImage() {
		click(btnSelectImage,"Select Your Image");
	}
	
	public void uploadSelectImage(String folderName,String fileName) {
		getElement(btnSelectImage, "select Image").sendKeys(FileHelper.getFilePath(folderName,fileName));
	}
	
	public void verifyCropYourImageHeading() {
		new CommonFunctions().elementView(lblCropYourImageHeading, getCopiedData());
	}
	
	public void clickSave() {
		if(getElement(btnSave, "save").isEnabled()) {
			click(btnSave, "Save");
		}
		
		else {
			ExtentTestManager.setPassMessageInReport("Save is button Disabled ");
		}
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
	

