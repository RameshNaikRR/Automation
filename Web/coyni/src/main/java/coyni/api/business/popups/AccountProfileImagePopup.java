package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__5E762 ']");
	private By lnkRemoveImg = By
			.xpath("//span[@class='mt-2 text-sm cursor-pointer text-cgy3 hover:underline hover:text-cgy4']");
	private By btnUploadNewImg = By.cssSelector(".w-60");
	private By crossIcon = By.xpath("//button[@class='self-end']");
	private By btnUploadNewImage = By.xpath("//button[text()='Upload New Image']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Account Profile Image Heading", expHeading);
	}

	public void clickUploadImageBtn() {
		click(btnUploadNewImg, "Click on Upload New Button");
	}

	public void clickCrossIcon() {
		click(crossIcon, "Click on crossIcon");
	}

	public void clickRemoveLnk() {
		new CommonFunctions().verifyCursorAction(lnkRemoveImg, "Remove");
		click(lnkRemoveImg, "Click on Remove Link");
	}

	public void clickUploadNewImage() {
		new CommonFunctions().verifyCursorAction(btnUploadNewImage, "Upload Image");
		click(btnUploadNewImage, "Upload New Image");
	}

	public CropYourImagePopup cropYourImagePopup() {
		return new CropYourImagePopup();
	}

	public RemoveProfileImagePopup removeProfileImagePopup() {
		return new RemoveProfileImagePopup();
	}

}
