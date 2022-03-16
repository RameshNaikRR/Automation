package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AccountProfileImagePopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i ']");
	private By lnkRemoveImg = By
			.xpath("//span[@class='mt-2 text-sm cursor-pointer text-cgy3 hover:underline hover:text-cgy4']");
	private By btnUploadNewImg = By.cssSelector(".w-60");
	private By crossIcon = By.xpath("//button[@class='self-end']");

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
		click(lnkRemoveImg, "Click on Remove Link");
	}

}
